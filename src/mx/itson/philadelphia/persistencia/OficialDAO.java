/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.JOptionPane;
import mx.itson.philadelphia.entities.Oficial;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Christian
 */
public class OficialDAO {
    
    /**
     * 
     * @return 
     */
    public List<Oficial> ObtenerTodos(){
    
        List<Oficial> oficiales = new ArrayList<>();

        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Oficial> criteriaQuery = session.getCriteriaBuilder().createQuery(Oficial.class);
            criteriaQuery.from(Oficial.class);
            
            oficiales = session.createQuery(criteriaQuery).getResultList();
                    
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex);
            
        }
        
        return oficiales;
    
    }
    
    public boolean guardar(String nombre, String telefono){
        
        boolean resultado = false;
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Oficial o = new Oficial();
            o.setNombre(nombre);
            o.setTelefono(telefono);
            
            session.save(o);
            
            session.getTransaction().commit();
            
            resultado = o.getId() != 0;
            
        }catch(Exception ex){
            
                System.err.println("Ocurrio un error" + ex.getMessage());
            
        }
        
        return resultado;
        
    }
    
    public Oficial obtenerPorId(int id){
        
        Oficial conductor = new Oficial();
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            conductor = session.get(Oficial.class,  id);
            
        }catch(HibernateException ex){
            
            System.err.println("Ocurrio un error: " + ex);
            
        }
        
        return conductor;
        
    }
    
    public boolean editar(int id, String nombre, String telefono){
        
        boolean resultado = false;
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Oficial oficial = obtenerPorId(id);
            
            if(oficial != null){
                
                oficial.setNombre(nombre);
                oficial.setTelefono(telefono);
                
                session.saveOrUpdate(oficial);
                session.getTransaction().commit();
                
                resultado = true;
                
            }
            
        }catch(HibernateException ex){
            
            System.err.println("Ocurrio un error: " + ex);
            
        }
        
        return resultado;
        
    }
    
    public boolean eliminar(int id){
        
        boolean resultado = false;
        
        String[] options = {"Si", "No"};
        int x = JOptionPane.showOptionDialog(null, "El registro sera eliminado ¿Esta seguro de esto?", "Atencion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if(x == 0){
        
            try{

               Session session = HibernateUtil.getSessionFactory().openSession();
               session.beginTransaction();

               Oficial oficial = obtenerPorId(id);

               if(oficial != null){

                   session.delete(oficial);
                   session.getTransaction().commit();

                   resultado = true;

               }

            }catch(HibernateException ex){

               System.err.println("Ocurrio un error: " + ex);

           }
            
        }
         
         return resultado;
        
    }
    
}
