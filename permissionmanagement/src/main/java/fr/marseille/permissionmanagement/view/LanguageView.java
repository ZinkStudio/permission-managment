package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.service.LanguageService;

@ManagedBean
@SessionScoped
public class LanguageView implements Serializable {

    private static final long serialVersionUID = 1L;

    private LanguageService   service          = new LanguageService();

    private List<Language>    languages;

    private Language          language;

    // @PostConstruct
    public void init() {
        languages = new ArrayList<Language>();

        try {
            languages = service.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Language Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void update() {
        try {
            service.update(language);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Language Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
    }

    public void delete() {
        try {
            service.delete(language.getId());
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Language " + language.getId() + " deleted "));
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Language> getLanguages() {
        init();
        return languages;
    }

}
