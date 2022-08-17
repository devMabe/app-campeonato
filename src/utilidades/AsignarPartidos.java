
package utilidades;

import controlador.EquipoController;
import controlador.PartidoController;
import java.util.List;
import modelo.Equipo;

/**
 *
 * @author Beltran
 */
public class AsignarPartidos {
    
     
    EquipoController ec = new EquipoController();
    PartidoController pc = new PartidoController();

    List<Equipo> equipos = ec.listarEquipos();
    int numEquipos =  equipos.size();
    public AsignarPartidos(){
        iniciarLiga();
    }
    
    public class Partido {

        public int local = -1, visitante = -1;
    }
    
    private void iniciarLiga(){
        mostrarPartidos(calcularLiga());
    }
    
    private  Partido[][] calcularLigaNumEquiposPar() {
        int numRondas = numEquipos - 1;
        int numPartidosPorRonda = numEquipos / 2;

        Partido[][] rondas = new Partido[numRondas][numPartidosPorRonda];

        for (int i = 0, k = 0; i < numRondas; i++) {
            for (int j = 0; j < numPartidosPorRonda; j++) {
                rondas[i][j] = new Partido();

                rondas[i][j].local = k;
                k++;
                if (k == numRondas) {
                    k = 0;
                }
            }
        }

        for (int i = 0; i < numRondas; i++) {
            if (i % 2 == 0) {
                rondas[i][0].visitante = numEquipos - 1;
            } else {
                rondas[i][0].visitante = rondas[i][0].local;
                rondas[i][0].local = numEquipos - 1;
            }
        }

        int equipoMasAlto = numEquipos - 1;
        int equipoImparMasAlto = equipoMasAlto - 1;

        for (int i = 0, k = equipoImparMasAlto; i < numRondas; i++) {
            for (int j = 1; j < numPartidosPorRonda; j++) {
                rondas[i][j].visitante = k;
                k--;
                if (k == -1) {
                    k = equipoImparMasAlto;
                }
            }
        }

        return rondas;
    }

    private Partido[][] calcularLigaNumEquiposImpar() {
        int numRondas = numEquipos;
        int numPartidosPorRonda = numEquipos / 2;

        Partido[][] rondas = new Partido[numRondas][numPartidosPorRonda];

        for (int i = 0, k = 0; i < numRondas; i++) {
            for (int j = -1; j < numPartidosPorRonda; j++) {
                if (j >= 0) {
                    rondas[i][j] = new Partido();

                    rondas[i][j].local = k;
                }

                k++;
                if (k == numRondas) {
                    k = 0;
                }
            }
        }

        int equipoMasAlto = numEquipos - 1;

        for (int i = 0, k = equipoMasAlto; i < numRondas; i++) {
            for (int j = 0; j < numPartidosPorRonda; j++) {
                rondas[i][j].visitante = k;
                k--;
                if (k == -1) {
                    k = equipoMasAlto;
                }
            }
        }

        return rondas;
    }

    public Partido[][] calcularLiga() {
        if (numEquipos % 2 == 0) {
            return calcularLigaNumEquiposPar();
        } else {
            return calcularLigaNumEquiposImpar();
        }
    }

    public void mostrarPartidos(Partido[][] rondas) {
        //eliminamos los partidos exisentes antes de mostrar los que  se genararan.
        eliminarPartidos();
        for (Partido[] ronda : rondas) {
            for (Partido ronda1 : ronda) {
                pc.addPartido("" + equipos.get(ronda1.local).getId(), "" + equipos.get(ronda1.visitante).getId());
            }
        }
        /*
        for (int i = 0; i < rondas.length; i++) {
        for (int j = 0; j < rondas[i].length; j++) {
        pc.addPartido(""+equipos.get(rondas[i][j].visitante).getId(), ""+equipos.get(rondas[i][j].local).getId());
        }
        }
         */
    }
    
    
    public void eliminarPartidos(){
        
        List<modelo.Partido> p = pc.listarPartidos();
       
        for(int i= 0; i<p.size(); i++){
            pc.eliminarPartido(""+p.get(i).getId());
        }
        
    }
   
    
    
}
