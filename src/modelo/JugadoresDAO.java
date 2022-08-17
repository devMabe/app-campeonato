
package modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Beltran
 */
public class JugadoresDAO {
    
    public void addJugadores (Jugadores jugadores){
       SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        try (Session session = sessFact.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(jugadores);
            tx.commit();
        }
    }
    
    
    
    public List listarJugadores(){
         SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
         List<Jugadores> jugadores;
        try (Session session = sessFact.openSession()) {
            jugadores = session.createQuery("from Jugadores").list();
            System.out.println(jugadores.get(0).getNombre());
        }
        
         return jugadores;
    }
    public List listarJugadoresEquipo(int equipo){
         SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
         List<Jugadores> jugadores;
        try (Session session = sessFact.openSession()) {
            jugadores = session.createQuery("from Jugadores where equipo = '"+equipo+"'").list();
        }
        
         return jugadores;
    }
    public Jugadores buscarJugadores(int cedula){
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Jugadores j;
        try (Session session = sessFact.openSession()) {
            j = (Jugadores)session.get(Jugadores.class,cedula);
        }
         return j;
    }
    
    
    public void modificarJugadores(Jugadores jugadores){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesionFact.openSession();
        Transaction tx = session.beginTransaction();
        session.update(jugadores);
        tx.commit();
        session.close();
    }
    
    
    public void eliminarJugadores(Jugadores jugadores){
        SessionFactory sesionFact = NewHibernateUtil.getSessionFactory();
        try (Session session = sesionFact.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(jugadores);
            tx.commit();
        }
    }
    
    
}
