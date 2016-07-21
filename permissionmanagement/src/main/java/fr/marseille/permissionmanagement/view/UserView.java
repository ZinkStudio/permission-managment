package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "ttBasicView")
@ViewScoped
public class UserView implements Serializable {

    private TreeNode root;
    // private Document selectedDocument;

    // @ManagedProperty("#{documentService}")
    // private DocumentService service;

    @PostConstruct
    public void init() {
        // root = service.createDocuments();
    }

    public TreeNode getRoot() {
        return root;
    }

    // public void setService(DocumentService service) {
    // this.service = service;
    // }
    //
    // public Document getSelectedDocument() {
    // return selectedDocument;
    // }
    //
    // public void setSelectedDocument(Document selectedDocument) {
    // this.selectedDocument = selectedDocument;
    // }
    // }
    //
}
