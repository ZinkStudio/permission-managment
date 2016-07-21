package fr.marseille.permissionmanagement.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "HelloController")
@RequestScoped
public class PermissionController {

	private String message = "";
	private String password = "1234";

	public PermissionController() {
		super();
	}

	/**
	 * ajout d'une methode publique me permettant de faire une redirection
	 * dynamique vers une autre page
	 */

	public String nextPage() {
		if (message.isEmpty()) {
			return null;
		}
		return "redirectPage";
	}

	public String nextPage(String page) {
		return page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
