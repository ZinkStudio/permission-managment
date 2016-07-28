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

@ManagedBean
@SessionScoped
public class LabelView implements Serializable {

    private static final long     serialVersionUID = 1L;

    private LabelService          service          = new LabelService();

    private List<PermissionLabel> labels;

    private List<PermissionLabel> filteredLabels;

    private PermissionLabel       label;

    private Permission            permission;

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

    public void update() {
        try {
            service.update(label);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
    }

    public void delete() {
        try {
            service.delete(label.getId());
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Label" + label.getId() + " deleted "));
    }

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

    public List<PermissionLabel> getLabels() {
        init();
        return labels;
    }

    public void setLabels(List<PermissionLabel> labels) {
        this.labels = labels;
    }

    public PermissionLabel getLabel() {
        return label;
    }

    public void setLabel(PermissionLabel label) {
        this.label = label;
    }

    public List<PermissionLabel> getFilteredLabels() {
        return filteredLabels;
    }

    public void setFilteredLabels(List<PermissionLabel> filteredLabels) {
        this.filteredLabels = filteredLabels;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
