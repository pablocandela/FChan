package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "confirmar registro")
@SessionScoped
public class ConfirmarCorreo {

	String correo;

	public String getEmail() {
		return correo;
	}

	public void setEmail(String email) {
		this.correo = correo;
	}

	public String register() {
		return "registro?faces-redirect=true";
	}

}