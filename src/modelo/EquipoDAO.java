
package modelo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Beltran
 */
public class EquipoDAO {
    
    public void addEquipo(Equipo equipo){
       SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        try (Session session = sessFact.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(equipo);
            tx.commit();
        }
    }
    
    public List listarEquipo(){
         SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
         List<Equipo> equipos;
        try (Session session = sessFact.openSession()) {
            equipos = session.createQuery("from Equipo").list();
        }
        
         return equipos;
    }
    
    public Equipo buscarEquipo(int id){
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Equipo e;
        try (Session session = sessFact.openSession()) {
            e = (Equipo)session.get(Equipo.class, id);
        }
         return e;
    }
    
    public void modificarEquipo(Equipo equipo){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesionFact.openSession();
        Transaction tx = session.beginTransaction();
        session.update(equipo);
        tx.commit();
        session.close();
    }
    
    
    public void eliminarEquipo(Equipo equipo){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        try (Session session = sesionFact.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(equipo);
            tx.commit();
        }
    }
    
    
    public List buscarEquipoPorNombre(String nombre){
         SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
         List<Equipo> equipos;
        try (Session session = sessFact.openSession()) {
            equipos = session.createQuery("from Equipo where nombre_e ='"+nombre+"'").list();
        }
        
         return equipos;
    } 
    
    
    public List buscarEquipoPorPais(String pais){
          SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
          List<Equipo> equipos;
        try (Session session = sessFact.openSession()) {
            equipos = session.createQuery("from Equipo where pais ='"+pais+"'").list();
        }
        
         return equipos;
    } 
    
    
    
    
}
