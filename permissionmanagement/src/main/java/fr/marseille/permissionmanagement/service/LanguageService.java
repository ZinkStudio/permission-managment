package fr.marseille.permissionmanagement.service;

import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.LanguageDAO;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;

public class LanguageService {

    private static final Logger LOG         = Logger.getLogger(LanguageService.class);

    public LanguageDAO          languageDAO = DAOFactory.getLanguageDAO();

    public LanguageService() {
        LOG.debug("constructor of languageDAO called");
    }

    public Language find(Integer id) throws ServiceException {
        return languageDAO.find(id);
    }

    public List<Language> findAll() throws ServiceException {
        return languageDAO.findAll();
    }

    public Language update(Language language) throws ServiceException {
        return languageDAO.update(language);
    }

    public boolean delete(Integer id) throws ServiceException {
        return languageDAO.delete(id);
    }

    public boolean save(Language language) throws ServiceException {
        return languageDAO.save(language);
    }

}