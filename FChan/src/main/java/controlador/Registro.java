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
import javax.validation.constraints.Pattern;
import modelo.Pregunta;
import javax.validation.constraints.Pattern;
import modelo.PreguntaDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author Pablo
 */
@ManagedBean
@ViewScoped
public class Registro  {
    
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
    @Pattern(regexp="/\\S+@\\S+/")
    private String pattern;
    private Set respuestas = new HashSet(0);
    private Set preguntas = new HashSet(0);
    
   public String guardaUsuario(){  
        setFecharegistro();
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario p = new Usuario();        
        UsuarioDAO pd = new UsuarioDAO();
        p.setUsername(username);
        p.setPaterno(paterno);
        p.setMaterno(materno);
        p.setCarrera(carrera);
        p.setRol(rol);
        p.setContrasena(contrasena);
        p.setNombre(nombre);
        p.setCorreo(correo);     
        String con = "";
        con = confirmarcontrasena;
        if(con.equals(p.getContrasena()) && !p.getUsername().equals(null) && !p.getUsername().equals("") 
           && !p.getCorreo().equals(null) && !p.getCorreo().equals("") && !p.getNombre().equals(null)
           && !p.getNombre().equals("")){
            pd.guarda(p);
            return "index";
        }else
            context.addMessage(null, new FacesMessage("Contraseña incorrecta"));
            return "p";
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
    
     public String getPattern() {
        return pattern;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
}