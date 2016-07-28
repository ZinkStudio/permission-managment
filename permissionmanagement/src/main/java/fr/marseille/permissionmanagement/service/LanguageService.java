package fr.marseille.permissionmanagement.service;

import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.LanguageDAO;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;

// TODO: Auto-generated Javadoc
/**
 * The Class LanguageService.
 */
public class LanguageService {

    /** The Constant LOG. */
    private static final Logger LOG         = Logger.getLogger(LanguageService.class);

    /** The language dao. */
    public LanguageDAO          languageDAO = DAOFactory.getLanguageDAO();

    /**
     * Instantiates a new language service.
     */
    public LanguageService() {
        LOG.debug("constructor of languageDAO called");
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the language
     * @throws ServiceException the service exception
     */
    public Language find(Integer id) throws ServiceException {
        return languageDAO.find(id);
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Language> findAll() throws ServiceException {
        return languageDAO.findAll();
    }

    /**
     * Update.
     *
     * @param language the language
     * @return the language
     * @throws ServiceException the service exception
     */
    public Language update(Language language) throws ServiceException {
        return languageDAO.update(language);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean delete(Integer id) throws ServiceException {
        return languageDAO.delete(id);
    }

    /**
     * Save.
     *
     * @param language the language
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean save(Language language) throws ServiceException {
        return languageDAO.save(language);
    }

}