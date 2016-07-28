package fr.marseille.permissionmanagement.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class JPAUtil.
 */
public class JPAUtil {

    /** The Constant LOG. */
    private static final Logger         LOG              = Logger.getLogger(JPAUtil.class);

    /** The Constant PERSISTANCE_UNIT. */
    private static final String         PERSISTANCE_UNIT = "permissionmanagement";

    /** The manager factory. */
    private static EntityManagerFactory managerFactory;

    /** The entity manager. */
    private static EntityManager        entityManager;

    /**  The entity transaction. */
    private static EntityTransaction    transaction;

    /**
     * Instantiates a new JPA util.
     */
    private JPAUtil() {

    }

    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    public synchronized static EntityManager getEntityManager() {

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = JPAUtil.getManagerFactory().createEntityManager();
        }

        return entityManager;

    }

    /**
     * Gets the manager factory.
     *
     * @return the manager factory
     */
    public synchronized static EntityManagerFactory getManagerFactory() {

        if (managerFactory == null || !managerFactory.isOpen()) {
            managerFactory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT);
        }

        return managerFactory;
    }

    /**
     * Gets the entity manager transaction.
     *
     * @return the entity manager transaction
     */
    public synchronized static EntityTransaction getTransaction() {

        if (transaction == null) {
            transaction = getEntityManager().getTransaction();
        }

        return transaction;
    }

    /**
     * Begin the entity manager transaction.
     */
    public synchronized static void beginTransaction() {
        if (!getTransaction().isActive()) {
            getTransaction().begin();
        }
    }

    /**
     * Commit the entity manager transaction.
     */
    public synchronized static void commitTransaction() {
        if (getTransaction().isActive()) {
            getTransaction().commit();
        }
    }

    /**
     * Commit the entity manager transaction.
     */
    public synchronized static void rollbackTransaction() {
        if (getTransaction().isActive()) {
            LOG.debug("rollback transaction");
        }
    }

    /**
     * Close all.
     */
    public static void closeAll() {
        closeEntityManager();
        closeManagerFactory();
    }

    /**
     * Close manager factory.
     */
    public static void closeManagerFactory() {
        if (managerFactory != null && managerFactory.isOpen()) {
            managerFactory.close();
        }
    }

    /**
     * Close entity manager.
     */
    public static void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
