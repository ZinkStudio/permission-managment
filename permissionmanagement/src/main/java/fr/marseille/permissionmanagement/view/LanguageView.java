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

// TODO: Auto-generated Javadoc
/**
 * The Class LanguageView.
 */
@ManagedBean
@SessionScoped
public class LanguageView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The service. */
    private LanguageService   service          = new LanguageService();

    /** The languages. */
    private List<Language>    languages;

    /** The language. */
    private Language          language;

    /**
     * Inits the.
     */
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

    /**
     * Update.
     */
    public void update() {
        try {
            service.update(language);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Language Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
    }

    /**
     * Delete.
     */
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

    /**
     * Gets the language.
     *
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language
     *            the new language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * Gets the languages.
     *
     * @return the languages
     */
    public List<Language> getLanguages() {
        init();
        return languages;
    }

}
