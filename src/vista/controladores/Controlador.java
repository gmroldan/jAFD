/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package vista.controladores;

import java.util.ArrayList;
import modelo.AutomataFinito;
import modelo.Transicion;
import modelo.excepciones.MachineException;

public class Controlador {
    private AutomataFinito afdActual;
    
    public void nuevoAFD(){
        afdActual = new AutomataFinito();
    }
    
    public void ingresarAlfabeto(String[] texto) throws Exception {
        afdActual.ingresarAlfabeto(texto);
    }
    
    public void ingresarEstados(int cantidad) {
        afdActual.ingresarEstados(cantidad);
    }
    
    public void ingresarEstadosFinales(String[] texto) throws Exception{
        afdActual.ingresarEstadosFinales(texto);       
    }
    
    public void nuevaTransicion(int qActual, String simboloActual, int proximoEstado) throws MachineException {
        afdActual.nuevaTransicion(qActual, simboloActual, proximoEstado);
    }
    
    public String simularAFD(String palabra){
        return afdActual.simular(palabra);
    }

    public AutomataFinito getAfdActual() {
        return afdActual;
    }
    
    public String getSimbolo(int index) {
        return afdActual.getSimbolo(index);
    }
    
    public String getAlfabeto() {
        return afdActual.getAlfabeto().toString();
    }
    
    public String getEstados() {
        return afdActual.getEstados().toString();
    }
    
    public String getEstadosFinales() {
        return afdActual.getEstadosFinales().toString();
    }
    
    public ArrayList<Transicion> getTransiciones() {
        return afdActual.getTransiciones();
    }
    
    public int getCantidadEstados() {
        return afdActual.getEstados().size();
    }
    
    public int getCantidadSimbolos() {
        return afdActual.getAlfabeto().getSimbolos().size();
    }
}
