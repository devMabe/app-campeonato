
package controlador;

import java.util.List;
import modelo.Equipo;
import modelo.Partido;
import modelo.PartidoDAO;

/**
 *
 * @author Beltran
 */
public class PartidoController {
      PartidoDAO pDAO = new PartidoDAO();

    public boolean addPartido(String p1, String p2){
        try{
            Partido p = new Partido();
            EquipoController ec = new EquipoController();
            Equipo e1 = ec.buscarEquipo(p1); 
            Equipo e2 = ec.buscarEquipo(p2);
            p.setEquipoByEquipo1(e1);
            p.setEquipoByEquipo2(e2);
            p.setAmarillas1(0);
            p.setAmarillas2(0);
            p.setFinalizar(0);
            p.setGoles1(0);
            p.setGoles2(0);
            p.setRojas1(0);
            p.setRojas2(0);
            pDAO.addPartido(p);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    }
    public Partido buscarPartido(String id){
        Partido p = new Partido();
        try{
            p = pDAO.bucarPartido(Integer.parseInt(id));
            EquipoController ec = new EquipoController();
            Equipo eq1 = ec.buscarEquipo(""+p.getEquipoByEquipo1().getId());
            Equipo eq2 = ec.buscarEquipo(""+p.getEquipoByEquipo2().getId());
            p.setEquipoByEquipo1(eq1);
            p.setEquipoByEquipo2(eq2);
        }catch(Exception e){
            p = null;
        }
        
        return p;
    }
    
    public List listarPartidos() {
        EquipoController ec = new EquipoController();
        List<Partido> partidos = pDAO.listarPartido();
        
        for(int i = 0; i < partidos.size(); i++){
            Equipo eq1 = new Equipo();
            Equipo eq2 = new Equipo();
            eq1 = ec.buscarEquipo(""+partidos.get(i).getEquipoByEquipo1().getId());
            eq2 = ec.buscarEquipo(""+partidos.get(i).getEquipoByEquipo2().getId());
            partidos.get(i).setEquipoByEquipo1(eq1);
            partidos.get(i).setEquipoByEquipo2(eq2);
        }
        
        return partidos;
    }
    
    public boolean modificarPartido(String id, String gol1,String gol2,String ama1,String ama2, String roja1, String roja2, String finalizar){
        
        try{
            Partido p = pDAO.bucarPartido(Integer.parseInt(id));
            p.setAmarillas1(Integer.parseInt(ama1));
            p.setAmarillas2(Integer.parseInt(ama2));
            p.setGoles1(Integer.parseInt(gol1));
            p.setGoles2(Integer.parseInt(gol2));
            p.setRojas1(Integer.parseInt(roja1));
            p.setRojas2(Integer.parseInt(roja2));
            p.setFinalizar(Integer.parseInt(finalizar));
            
            pDAO.modificarPartido(p);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean modificarPartido(Partido p){
        try{
            pDAO.modificarPartido(p);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean eliminarPartido(String id){
        try{
            Partido p = new Partido();
            p = pDAO.bucarPartido(Integer.parseInt(id));
            pDAO.eliminarPartido(p);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
