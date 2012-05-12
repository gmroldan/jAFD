/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package automatafinitodeterminista;

public class Transicion {
    private int estadoActual;
    private int proximoEstado;
    private String simbolo;
    
    public Transicion(){
        
    }
    
    public Transicion(int estadoActual,String simbolo,int proximoEstado){
        this.estadoActual=estadoActual;
        this.simbolo=simbolo;
        this.proximoEstado=proximoEstado;
    }

    public int getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(int estadoActual) {
        this.estadoActual = estadoActual;
    }

    public int getProximoEstado() {
        return proximoEstado;
    }

    public void setProximoEstado(int proximoEstado) {
        this.proximoEstado = proximoEstado;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
}
