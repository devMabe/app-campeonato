
package modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Beltran
 */
public class PartidoDAO {
     
     public void addPartido(Partido partido){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesionFact.openSession();
        Transaction tx = session.beginTransaction();
        session.save(partido);
        tx.commit();
        session.close();
    }
    
    public List listarPartido(){
         SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
         List<Partido> partidos;
         try (Session session = sessFact.openSession()) {
             partidos = session.createQuery("from Partido").list();
         }
        
         return partidos;
    }
   
    public Partido bucarPartido(int id){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        Partido partido;
         try (Session session = sesionFact.openSession()) {
             partido = (Partido)session.get(Partido.class, id);
         }
        return partido;
    }
    
    public void modificarPartido(Partido partido){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesionFact.openSession();
        Transaction tx = session.beginTransaction();
        session.update(partido);
        tx.commit();
        session.close();
    }
    
    public void eliminarPartido(Partido partido){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
         try (Session session = sesionFact.openSession()) {
             Transaction tx = session.beginTransaction();
             session.delete(partido);
             tx.commit();
         }
    }
}
