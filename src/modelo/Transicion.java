/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

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

    public int getProximoEstado() {
        return proximoEstado;
    }

    public String getSimbolo() {
        return simbolo;
    }    
}
