/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import org.hibernate.Query;
import java.util.List;
import org.hibernate.Session;
//
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author PABLO
 */
public class UsuarioDAO {
     private SessionFactory sessionFactory;
    
 public UsuarioDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

 
 
  /**
     * Regresa una lista con todos los usuarios que estan activos en la base de datos.
     * @return 
     */
public List<Usuario> usuarios() {
        List<Usuario> result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql = "from Usuario";
            Query query = session.createQuery(hql);
            result = (List<Usuario>)query.list();
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }

public void guarda(Usuario u){
    Session session = sessionFactory.openSession();
     Transaction tx = null;
     try {
           tx = session.beginTransaction();
           session.save(u);
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }
           session.close();
}

 public Usuario busca(String correo) {
        Usuario result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql = " from Usuario where correo like '%"+correo+"%'";
            Query query = session.createQuery(hql);
            //query.setParameter("correo", correo);
            result = (Usuario)query.uniqueResult();
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }

   
    

}