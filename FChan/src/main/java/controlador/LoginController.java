
package controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author jonathan
 */
@ManagedBean
@SessionScoped
public class LoginController  {
    
    
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public String login() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.busca(username);
        FacesContext context = FacesContext.getCurrentInstance();

        if (u == null) {
            context.addMessage(null, new FacesMessage("El correo que ingresó no está registrado, intente de nuevo"));
            username = null;
            password = null;
            return null;
        } else if(u.getContrasena().equals(this.password)){
            context.getExternalContext().getSessionMap().put("user", u);
            
            return "inicioLogin?faces-redirect=true";
        } else {
            context.addMessage(null, new FacesMessage("Contraseña incorrecta"));
            username = null;
            password = null;
            return null; 
        }
    }

    public String  logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/inicio?faces-redirect=true";
    }
}