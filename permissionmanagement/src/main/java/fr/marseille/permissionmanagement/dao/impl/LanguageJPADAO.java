package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.LanguageDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class LanguageJPADAO implements LanguageDAO {

    private static final Logger LOG = Logger.getLogger(LanguageJPADAO.class);

    public LanguageJPADAO() {

    }

    @Override
    public boolean save(Language language) throws DAOException {
        boolean status = false;

        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().persist(language);
            JPAUtil.commitTransaction();
            status = true;
        } catch (RuntimeException e) {
            status = false;
            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return status;
    }

    @Override
    public List<Language> findAll() throws DAOException {
        List<Language> languages = new ArrayList<Language>();

        try {
            languages = JPAUtil.getEntityManager().createQuery("from Language", Language.class).getResultList();
        } catch (RuntimeException e) {
            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return languages;
    }

    @Override
    public Language find(Integer id) throws DAOException {

        Language language = null;

        try {
            language = JPAUtil.getEntityManager().find(Language.class, id);
        } catch (RuntimeException e) {
            String msg = "find : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return language;
    }

    public void setDefault(Language language) throws DAOException {
        if (true == language.getIsDefault()) {
            List<Language> languages = this.findDefaultLanguages();
            languages.remove(language);

            for (Language lang : languages) {
                lang.setIsDefault(false);
                this.update(lang);
            }
        }
    }

    public List<Language> findDefaultLanguages() throws DAOException {
        return JPAUtil.getEntityManager()
                .createQuery("Select lang from Language lang where lang.isDefault=:arg1", Language.class)
                .setParameter("arg1", true).getResultList();
    }

    @Override
    public Language update(Language language) throws DAOException {
        Language mergeLanguage = language;

        try {
            JPAUtil.beginTransaction();
            mergeLanguage = JPAUtil.getEntityManager().merge(language);
            JPAUtil.commitTransaction();
            this.setDefault(mergeLanguage);
        } catch (RuntimeException e) {
            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return mergeLanguage;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        boolean status = false;

        Language language = this.find(id);

        if (null != language) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(language);
                JPAUtil.commitTransaction();
            } catch (RuntimeException e) {
                status = false;
                String msg = "remove : " + e.getMessage();
                LOG.error(msg);
                JPAUtil.rollbackTransaction();
                throw new DAOException(msg, e);
            }
        }

        return status;
    }

}
