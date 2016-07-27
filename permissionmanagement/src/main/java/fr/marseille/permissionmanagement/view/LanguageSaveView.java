package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.service.LanguageService;

@ManagedBean
@RequestScoped
public class LanguageSaveView implements Serializable {

    private static final long serialVersionUID = 1L;

    private LanguageService   service          = new LanguageService();

    private Language          language;

    @PostConstruct
    public void init() {
        language = new Language();
    }

    public void save() {
        try {
            service.save(language);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Language Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}
