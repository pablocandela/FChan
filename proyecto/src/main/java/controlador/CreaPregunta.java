/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author Rafael
 */
@ManagedBean
@ViewScoped
public class CreaPregunta {
    
    private String titulo;
    private int id;
    private Usuario usuario;
    private String descripcion;
    private Date fecha;
    private Set respuestas = new HashSet(0);

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }    
    
    public void setDescripcion(String des) {
        this.descripcion = des;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setFecha() {
	this.fecha = new Date();
        
        
    }
    
    public Date getFecha() {
        return fecha;
    }
        
     public String guardaPregunta(){
         setFecha();
         Pregunta p = new Pregunta(0,null,titulo, descripcion, fecha, respuestas);
        
        //p.setTitulo(titulo);
        //p.setUsuario(usuario);
        //p.setDescripcion(descripcion);
        //p.setFecha(fecha);
        //p.setRespuestas(respuestas);
        //Usuario e=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        //p.setUsuario(null);
        
        PreguntaDAO pd = new PreguntaDAO();
        pd.guarda(p);
        
        
        return "index";
    }
    
}