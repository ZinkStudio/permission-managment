package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.PermissionLabel;
import fr.marseille.permissionmanagement.service.LabelService;

// TODO: Auto-generated Javadoc
/**
 * The Class LabelView.
 */
@ManagedBean
@SessionScoped
public class LabelView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long     serialVersionUID = 1L;

    /** The service. */
    private LabelService          service          = new LabelService();

    /** The labels. */
    private List<PermissionLabel> labels;

    /** The filtered labels. */
    private List<PermissionLabel> filteredLabels;

    /** The label. */
    private PermissionLabel       label;

    /** The permission. */
    private Permission            permission;

    /**
     * Inits the.
     */
    // @PostConstruct
    public void init() {
        labels = new ArrayList<PermissionLabel>();

        try {
            labels = service.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
    }

    /**
     * Update.
     */
    public void update() {
        try {
            service.update(label);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
    }

    /**
     * Delete.
     */
    public void delete() {
        try {
            service.delete(label.getId());
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Label" + label.getId() + " deleted "));
    }

    /**
     * Filter by language.
     *
     * @param value the value
     * @param filter the filter
     * @param locale the locale
     * @return true, if successful
     */
    // filter method showcase
    public boolean filterByLanguage(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    /**
     * Gets the labels.
     *
     * @return the labels
     */
    public List<PermissionLabel> getLabels() {
        init();
        return labels;
    }

    /**
     * Sets the labels.
     *
     * @param labels the new labels
     */
    public void setLabels(List<PermissionLabel> labels) {
        this.labels = labels;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public PermissionLabel getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(PermissionLabel label) {
        this.label = label;
    }

    /**
     * Gets the filtered labels.
     *
     * @return the filtered labels
     */
    public List<PermissionLabel> getFilteredLabels() {
        return filteredLabels;
    }

    /**
     * Sets the filtered labels.
     *
     * @param filteredLabels the new filtered labels
     */
    public void setFilteredLabels(List<PermissionLabel> filteredLabels) {
        this.filteredLabels = filteredLabels;
    }

    /**
     * Gets the permission.
     *
     * @return the permission
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * Sets the permission.
     *
     * @param permission the new permission
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
