
package controlador;

import java.util.List;
import modelo.Equipo;
import modelo.Jugadores;
import modelo.JugadoresDAO;

/**
 *
 * @author Beltran
 */
public class JugadoresController {
    JugadoresDAO jDAO  = new JugadoresDAO();
    
    
    public boolean addJugadores(String cedula, String nombre , String equipo , String amarillas, String rojas, String goles){
        EquipoController ec = new EquipoController();
        Equipo equipos  = new Equipo();
        Jugadores j;
        try {
           equipos = ec.buscarEquipo(equipo);
           j = new Jugadores( Integer.parseInt(cedula), nombre, equipos, Integer.parseInt(amarillas),  Integer.parseInt(rojas),  Integer.parseInt(goles));
           jDAO.addJugadores(j);
           return true;
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public List<Jugadores> listarJugadoresEquipo(String equipo){
        return jDAO.listarJugadoresEquipo(Integer.parseInt(equipo));
    }
    
    public boolean modificar1(Jugadores jugador){
        try{
            jDAO.modificarJugadores(jugador);
            return true;
        }catch(Exception e){
            return false;
        }
         
        
    }
}
