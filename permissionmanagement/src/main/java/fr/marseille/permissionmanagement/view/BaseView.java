package fr.marseille.permissionmanagement.view;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

public abstract class BaseView implements Serializable {

    protected void redirectWithMessages(String location) {
        this.redirectWithMessages(location, "cmd-flash");
    }

    protected void redirectWithMessages(String location, String commandbutton) {
        try {
            RequestContext.getCurrentInstance()
                    .execute("setTimeout(function(){ $('#" + commandbutton + "').click(); }, 3000);");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().getExternalContext().redirect(location);
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Redirect Error"));
        }
    }
}
