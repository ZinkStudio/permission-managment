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

public class LabelService {

    private static final Logger LOG           = Logger.getLogger(LabelService.class);

    private PermissionDAO       permissionDAO = DAOFactory.getPermissionDAO();
    private LanguageDAO         languageDAO   = DAOFactory.getLanguageDAO();
    private PermissionLabelDAO  labelDAO      = DAOFactory.getPermissionLabelDAO();

    public LabelService() {

    }

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

    public PermissionLabel find(Integer id) throws ServiceException {
        return labelDAO.find(id);
    }

    public List<PermissionLabel> findAll() throws ServiceException {
        return labelDAO.findAll();
    }

    public PermissionLabel update(PermissionLabel label) throws ServiceException {
        return labelDAO.update(label);
    }

    public boolean delete(Integer id) throws ServiceException {
        return labelDAO.delete(id);
    }

    public boolean save(PermissionLabel label) throws ServiceException {
        return labelDAO.save(label);
    }

}