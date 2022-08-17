package modelo;
// Generated 11/06/2021 09:40:19 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Equipo generated by hbm2java
 */
public class Equipo  implements java.io.Serializable {


     private Integer id;
     private String nombreE;
     private String pais;
     private String codigo;
     private int numPuntos;
     private int PGanados;
     private int PPerdidos;
     private int PJugados;
     private Set jugadoreses = new HashSet(0);
     private Set partidosForEquipo2 = new HashSet(0);
     private Set partidosForEquipo1 = new HashSet(0);

    public Equipo() {
    }

	
    public Equipo(String nombreE, String pais, String codigo, int numPuntos, int PGanados, int PPerdidos, int PJugados) {
        this.nombreE = nombreE;
        this.pais = pais;
        this.codigo = codigo;
        this.numPuntos = numPuntos;
        this.PGanados = PGanados;
        this.PPerdidos = PPerdidos;
        this.PJugados = PJugados;
    }
    public Equipo(String nombreE, String pais, String codigo, int numPuntos, int PGanados, int PPerdidos, int PJugados, Set jugadoreses, Set partidosForEquipo2, Set partidosForEquipo1) {
       this.nombreE = nombreE;
       this.pais = pais;
       this.codigo = codigo;
       this.numPuntos = numPuntos;
       this.PGanados = PGanados;
       this.PPerdidos = PPerdidos;
       this.PJugados = PJugados;
       this.jugadoreses = jugadoreses;
       this.partidosForEquipo2 = partidosForEquipo2;
       this.partidosForEquipo1 = partidosForEquipo1;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombreE() {
        return this.nombreE;
    }
    
    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getNumPuntos() {
        return this.numPuntos;
    }
    
    public void setNumPuntos(int numPuntos) {
        this.numPuntos = numPuntos;
    }
    public int getPGanados() {
        return this.PGanados;
    }
    
    public void setPGanados(int PGanados) {
        this.PGanados = PGanados;
    }
    public int getPPerdidos() {
        return this.PPerdidos;
    }
    
    public void setPPerdidos(int PPerdidos) {
        this.PPerdidos = PPerdidos;
    }
    public int getPJugados() {
        return this.PJugados;
    }
    
    public void setPJugados(int PJugados) {
        this.PJugados = PJugados;
    }
    public Set getJugadoreses() {
        return this.jugadoreses;
    }
    
    public void setJugadoreses(Set jugadoreses) {
        this.jugadoreses = jugadoreses;
    }
    public Set getPartidosForEquipo2() {
        return this.partidosForEquipo2;
    }
    
    public void setPartidosForEquipo2(Set partidosForEquipo2) {
        this.partidosForEquipo2 = partidosForEquipo2;
    }
    public Set getPartidosForEquipo1() {
        return this.partidosForEquipo1;
    }
    
    public void setPartidosForEquipo1(Set partidosForEquipo1) {
        this.partidosForEquipo1 = partidosForEquipo1;
    }




}

