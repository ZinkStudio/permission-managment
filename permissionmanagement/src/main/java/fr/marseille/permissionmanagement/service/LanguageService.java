package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.LanguageDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;

public class LanguageService {

    private static final Logger LOG         = Logger.getLogger(LanguageService.class);

    public LanguageDAO          languageDAO = DAOFactory.getLanguageDAO();

    public LanguageService() {

    }

    public Language find(Integer id) throws ServiceException {
        Language language = null;

        try {
            language = languageDAO.find(id);
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return language;
    }

    public List<Language> findAll() throws ServiceException {
        List<Language> languages = new ArrayList<Language>();

        try {
            languages = languageDAO.findAll();
            LOG.debug("languages found : " + languages.size());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return languages;
    }

    public Language update(Language language) throws ServiceException {

        try {
            language = languageDAO.update(language);
            LOG.debug("update language id : " + language.getId());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return language;
    }

    public boolean delete(Integer id) throws ServiceException {
        boolean status = false;
        try {
            status = languageDAO.delete(id);
        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return status;
    }

    public boolean save(Language language) throws ServiceException {
        boolean status = false;
        try {
            status = languageDAO.save(language);
        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return status;
    }

}