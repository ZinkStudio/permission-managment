package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TabMenuView implements Serializable {

    private static final long serialVersionUID = 1L;
    private int               index            = 0;

    private int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    @PostConstruct
    public void init() {

    }
}
