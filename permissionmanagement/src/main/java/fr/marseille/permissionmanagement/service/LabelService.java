package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.LanguageDAO;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.dao.PermissionLabelDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.PermissionLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class LabelService.
 */
public class LabelService {

    /** The Constant LOG. */
    private static final Logger LOG           = Logger.getLogger(LabelService.class);

    /** The permission dao. */
    private PermissionDAO       permissionDAO = DAOFactory.getPermissionDAO();
    
    /** The language dao. */
    private LanguageDAO         languageDAO   = DAOFactory.getLanguageDAO();
    
    /** The label dao. */
    private PermissionLabelDAO  labelDAO      = DAOFactory.getPermissionLabelDAO();

    /**
     * Instantiates a new label service.
     */
    public LabelService() {

    }

    /**
     * Creates the labels.
     *
     * @param size the size
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<PermissionLabel> createLabels(int size) throws DAOException {
        List<PermissionLabel> labels = new ArrayList<PermissionLabel>();

        List<Language> languages = languageDAO.findAll();
        Permission permission = permissionDAO.findAll().get(0);

        for (Language language : languages) {
            labels.add(new PermissionLabel(null, language.getLocale() + "_label", language, permission));
        }

        LOG.debug("generate false labels data");

        return labels;
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the permission label
     * @throws ServiceException the service exception
     */
    public PermissionLabel find(Integer id) throws ServiceException {
        return labelDAO.find(id);
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<PermissionLabel> findAll() throws ServiceException {
        return labelDAO.findAll();
    }

    /**
     * Update.
     *
     * @param label the label
     * @return the permission label
     * @throws ServiceException the service exception
     */
    public PermissionLabel update(PermissionLabel label) throws ServiceException {
        return labelDAO.update(label);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean delete(Integer id) throws ServiceException {
        return labelDAO.delete(id);
    }

    /**
     * Save.
     *
     * @param label the label
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean save(PermissionLabel label) throws ServiceException {
        return labelDAO.save(label);
    }

}