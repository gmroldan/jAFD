/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package vista.controladores;

import java.util.ArrayList;
import modelo.AutomataFinito;
import modelo.Maquina;
import modelo.Transicion;
import modelo.excepciones.MachineException;

public class Controlador {
    private Maquina maquinaActual;
    
    public void nuevoAFD(){
        maquinaActual = new AutomataFinito();
    }
    
    public void ingresarAlfabeto(String[] texto) throws Exception {
        maquinaActual.ingresarAlfabeto(texto);
    }
    
    public void ingresarEstados(int cantidad) {
        maquinaActual.ingresarEstados(cantidad);
    }
    
    public void ingresarEstadosFinales(String[] texto) throws Exception{
        maquinaActual.ingresarEstadosFinales(texto);       
    }
    
    public void nuevaTransicion(int qActual, String simboloActual, int proximoEstado) throws MachineException {
        maquinaActual.nuevaTransicion(qActual, simboloActual, proximoEstado);
    }
    
    public String simularAFD(String palabra) throws MachineException{
        return maquinaActual.simular(palabra);
    }

    public Maquina getMaquinaActual() {
        return maquinaActual;
    }
    
    public String getSimbolo(int index) {
        return maquinaActual.getSimbolo(index);
    }
    
    public String getAlfabeto() {
        return maquinaActual.getAlfabeto().toString();
    }
    
    public String getEstados() {
        return maquinaActual.getEstados().toString();
    }
    
    public String getEstadosFinales() {
        return maquinaActual.getEstadosFinales().toString();
    }
    
    public ArrayList<Transicion> getTransiciones() {
        return maquinaActual.getTransiciones();
    }
    
    public int getCantidadEstados() {
        return maquinaActual.getEstados().size();
    }
    
    public int getCantidadSimbolos() {
        return maquinaActual.getAlfabeto().getSimbolos().size();
    }
}
