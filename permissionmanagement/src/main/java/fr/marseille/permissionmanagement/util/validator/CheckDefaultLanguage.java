package fr.marseille.permissionmanagement.util.validator;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.LanguageDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Language;

@FacesValidator
public class CheckDefaultLanguage implements Validator {

    private LanguageDAO languageDAO  = DAOFactory.getLanguageDAO();
    private String      errorMessage = "there is no default language yet ! this one has to be a default one";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<Language> languages = new ArrayList<Language>();

        try {
            languages = languageDAO.findDefaultLanguages();
        } catch (DAOException e) {
            errorMessage = e.getMessage();
        }

        if (languages.isEmpty() && false == Boolean.parseBoolean(value.toString())) {
            FacesMessage msg = new FacesMessage("Incorrect input provided", errorMessage);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}
