package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.marseille.permissionmanagement.dao.UserDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.User;

/**
 * 
 */
public class UserJPADAO implements UserDAO {

	/**
	 * Default constructor
	 */
	public UserJPADAO() {
	}

	@Override
	public boolean save(User user) throws DAOException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return true;
	}

	@Override
	public List<User> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<User> lstUsers = (List<User>) entityManager.createQuery("from User");
		entityManager.close();
		entityManagerFactory.close();
		return lstUsers;
	}

	@Override
	public User find(Integer id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		entityManager.close();
		entityManagerFactory.close();
		return user;

	}

	@Override
	public User update(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(User.class, user.getId());
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return user;

	}

	@Override
	public boolean delete(Integer id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return true;
	}

}