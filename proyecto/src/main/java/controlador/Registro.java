/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import modelo.Pregunta;
import modelo.PreguntaDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author Rafael
 */
@ManagedBean
@ViewScoped
public class Registro {
    
    private String username;
    private String nombre;
    private String paterno;
    private String materno;
    private String carrera;
    private String contrasena;
    private String correo;
    private String rol;
    private String confirmarcontrasena;
    private Date fecharegistro;
    private Set respuestas = new HashSet(0);
    private Set preguntas = new HashSet(0);
    
   public String guardaUsuario(){  
      
        setFecharegistro();
        Usuario p = new Usuario(username,nombre,paterno,materno,carrera,fecharegistro,contrasena,correo,rol,respuestas,preguntas);
                
        UsuarioDAO pd = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(confirmarcontrasena==null || confirmarcontrasena.equals("")){
                context.addMessage(null, new FacesMessage("Confirmacion de contraseña vacia o incorrecta"));
              
                return null;      
            }

            if(contrasena==null || contrasena.equals("")){
                context.addMessage(null, new FacesMessage("LLene el campo de contraseña"));
                return null;
               
            }

            if(correo==null || correo.equals("")){
                context.addMessage(null, new FacesMessage("LLene el campo de correo"));
                return null;
              
            }

            if(!contrasena.equals(confirmarcontrasena)) {
               context.addMessage(null, new FacesMessage("Tiene que confirmar la contraseña"));
                return null;
                
            }

            if(paterno==null || paterno.equals("")){
               context.addMessage(null, new FacesMessage("Llene el campo de apellido paterno"));
                return null;
            }

            if(nombre==null || nombre.equals("")){
                context.addMessage(null, new FacesMessage("Ingrese su nombre"));
                return null;
            }

            if(materno==null || materno.equals("")){
               context.addMessage(null, new FacesMessage("Llene el campo de apellido materno"));
               return null;
            }

        pd.guarda(p);
           
       
        return "index";
    }

   public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPaterno() {
        return this.paterno;
    }
    
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return this.materno;
    }
    
    public void setMaterno(String materno) {
        this.materno = materno;
    }
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro() {
       this.fecharegistro = new Date();
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
   
    public String getConfirmarContrasena(){
		return this.confirmarcontrasena;
	}

	public void setConfirmarContrasena(String confirmarcontrasena){
		this.confirmarcontrasena=confirmarcontrasena;
	}

    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    private boolean validar(){

        boolean validacion = true;

           if(confirmarcontrasena==null || confirmarcontrasena.equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Falta agregar la confirmacion de la contraseña", ""));
                validacion=false;
            }

            if(contrasena==null || contrasena.equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Falta agregar contraseña", ""));
                validacion=false;
            }

            if(correo==null || correo.equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Falta agregar correo", ""));
                validacion=false;
            }

            if(!contrasena.equals(confirmarcontrasena)) {
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Las contraseñas no son iguales", ""));
                validacion=false;
            }

            if(paterno==null || paterno.equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Agrege su apellido paterno", ""));
                validacion=false;
            }

            if(nombre==null || nombre.equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Agrege su nombre", ""));
                validacion=false;
            }

            if(materno==null || materno.equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Agrege su apelido materno", ""));
                validacion=false;
            }

		
		return validacion;
	}
   
    
}