package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;

public class Language implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Language() {
    }

    private Integer          id;

    private String           locale;

    private Boolean          isDefault;

    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}