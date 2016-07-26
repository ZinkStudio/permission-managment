package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexView implements Serializable {

    private static final long serialVersionUID = 1L;

    @PostConstruct
    public void init() {

    }
}
