/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entities.*;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Christian
 */
public class ConductorDAO {
    
    /**
     * 
     * @return 
     */
    public List<Conductor> ObtenerTodos(){
    
        List<Conductor> conductores = new ArrayList<>();

        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Conductor> criteriaQuery = session.getCriteriaBuilder().createQuery(Conductor.class);
            criteriaQuery.from(Conductor.class);
            
            conductores = session.createQuery(criteriaQuery).getResultList();
                    
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error" + ex);
            
        }
        
        return conductores;
    
    }
    
    public boolean guardar(String nombre, String numeroLicencia, Date fechaAlta){
        
        boolean resultado = false;
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Conductor c = new Conductor();
            c.setNombre(nombre);
            c.setNumeroLicencia(numeroLicencia);
            c.setFechaAlta(fechaAlta);
            
            session.save(c);
            
            session.getTransaction().commit();
            
            resultado = c.getId() != 0;
            
        }catch(Exception ex){
            
                System.err.println("Ocurrio un error" + ex.getMessage());
            
        }
        
        return resultado;
        
    }
    
    public Conductor obtenerPorId(int id){
        
        Conductor conductor = new Conductor();
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            conductor = session.get(Conductor.class,  id);
            
        }catch(HibernateException ex){
            
            System.err.println("Ocurrio un error: " + ex);
            
        }
        
        return conductor;
        
    }
    
    public boolean editar(int id, String nombre, String numeroLicencia, Date fechaAlta){
        
        boolean resultado = false;
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Conductor conductor = obtenerPorId(id);
            
            if(conductor != null){
                
                conductor.setNombre(nombre);
                conductor.setFechaAlta(fechaAlta);
                conductor.setNumeroLicencia(numeroLicencia);
                
                session.saveOrUpdate(conductor);
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
        
         try{
        
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Conductor conductor = obtenerPorId(id);
            
            if(conductor != null){
                
                session.delete(conductor);
                session.getTransaction().commit();
                
                resultado = true;
                
            }
            
         }catch(HibernateException ex){
            
            System.err.println("Ocurrio un error: " + ex);
            
        }
         
         return resultado;
        
    }
    
}
