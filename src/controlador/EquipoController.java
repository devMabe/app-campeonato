package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;
import modelo.EquipoDAO;

/**
 *
 * @author Beltran
 */
public class EquipoController {
    
    EquipoDAO eDAO = new EquipoDAO();
    
    public boolean addEquipo(String nombre, String pais, String codigo, String num_puntos, String p_ganados, String p_perdidos, String p_jugados) {
        Equipo e;
        try {
            e = new Equipo(nombre, pais, codigo, Integer.parseInt(num_puntos), Integer.parseInt(p_ganados), Integer.parseInt(p_perdidos), Integer.parseInt(p_jugados));
            eDAO.addEquipo(e);
            return true;
        } catch (NumberFormatException r) {
            System.err.println(r.getMessage());
            return false;
        }
        
    }
    
    public List listarEquipos() {
        List<Equipo> equipos = eDAO.listarEquipo();
        return equipos;
    }
    
    public Equipo buscarEquipo(String id) {
        Equipo e = new Equipo();
        try {
            e = eDAO.buscarEquipo(Integer.parseInt(id));
        } catch (NumberFormatException r) {
            System.err.println(r.getMessage());
            e = null;
        }
        
        return e;
    }
    
    public List buscarEquiposPorNombre(String nombre) {
        Equipo e = new Equipo();
          List<Equipo> equipos = new ArrayList<>();
        try {
            
         equipos = eDAO.buscarEquipoPorNombre(nombre);
        } catch (Exception r) {
            System.err.println(r.getMessage());
            e = null;
        }
        
        return equipos;
    }
    
     public List buscarEquiposPorPais(String pais) {
        Equipo e = new Equipo();
        List<Equipo> equipos = new ArrayList<>();
        try {
         equipos = eDAO.buscarEquipoPorPais(pais);
        } catch (Exception r) {
            System.err.println(r.getMessage());
            e = null;
        }
        
        return equipos;
    }
    
    public boolean modificarEquipo(String id, String nombre, String pais) {
        Equipo e = new Equipo();
        try {
            e = eDAO.buscarEquipo(Integer.parseInt(id));
            e.setNombreE(nombre);
            e.setPais(pais);
            eDAO.modificarEquipo(e);
            return true;
        } catch (NumberFormatException r) {
            System.err.println(r.getMessage());
            return false;
        }
    }
    
    public boolean elimiarEquipo(String id) {
        Equipo e = new Equipo();
        
        try {
            e = eDAO.buscarEquipo(Integer.parseInt(id));
            eDAO.eliminarEquipo(e);
            return true;
        } catch (NumberFormatException r) {
            System.err.println(r.getMessage());
            return false;
        }
        
    }
    
}
