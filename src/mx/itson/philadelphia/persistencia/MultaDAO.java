/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entities.Multa;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Christian
 */
public class MultaDAO {
    
    /**
     * 
     * @return 
     */
    public List<Multa> ObtenerTodos(){
    
        List<Multa> multas = new ArrayList<>();

        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Multa> criteriaQuery = session.getCriteriaBuilder().createQuery(Multa.class);
            criteriaQuery.from(Multa.class);
            
            multas = session.createQuery(criteriaQuery).getResultList();
                    
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error" + ex);
            
        }
        
        return multas;
    
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
        
        String[] options = {"Si", "No"};
        int x = JOptionPane.showOptionDialog(null, "El registro sera eliminado ¿Esta seguro de esto?", "Atencion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if(x == 0){
        
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
            
        }
         
         return resultado;
        
    }
    
}