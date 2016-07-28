package fr.marseille.permissionmanagement.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

// TODO: Auto-generated Javadoc
/**
 * The Class NoWhiteSpaceValidator.
 */
@FacesValidator
public class NoWhiteSpaceValidator implements Validator {

    /* (non-Javadoc)
     * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (value.toString().trim().isEmpty()) {
            FacesMessage msg = new FacesMessage("Incorrect input provided",
                    "Are you a Monkey ? The input must provide some meaningful character");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}
