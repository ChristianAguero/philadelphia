/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.JOptionPane;
import mx.itson.philadelphia.entities.*;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
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

    public boolean guardar(String folio, String motivo, Date fecha, Conductor conductor, Oficial Oficial){
        
        boolean resultado = false;
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Multa m = new Multa();
            m.setFolio(folio);
            m.setMotivo(motivo);
            m.setFecha(fecha);
            m.setConductor(conductor);
            m.setOficial(Oficial);
            
            session.save(m);
            
            session.getTransaction().commit();
            
            resultado = m.getId() != 0;
            
        }catch(Exception ex){
            
                System.err.println("Ocurrio un error" + ex.getMessage());
            
        }
        
        return resultado;
        
    }
    
    public Multa obtenerPorId(int id){
        
        Multa multa = new Multa();
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            multa = session.get(Multa.class,  id);
            
        }catch(HibernateException ex){
            
            System.err.println("Ocurrio un error: " + ex);
            
        }
        
        return multa;
        
    }
    
    public boolean editar(int id, String folio, String motivo, Date fechaMulta, Conductor conductor, Oficial oficial){
        
        boolean resultado = false;
        
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Multa multa = obtenerPorId(id);
            
            if(conductor != null){
                
                multa.setConductor(conductor);
                multa.setFecha(fechaMulta);
                multa.setFolio(folio);
                multa.setMotivo(motivo);
                multa.setOficial(oficial);
                
                session.saveOrUpdate(multa);
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

               Multa multa = obtenerPorId(id);

               if(multa != null){

                   session.delete(multa);
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
