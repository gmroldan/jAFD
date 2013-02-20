/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

import java.util.ArrayList;
import modelo.excepciones.MachineException;


public class AutomataFinito {
    /*
     * Atributos
     */
    private ArrayList<Integer> estados;
    private ArrayList<Integer> estadosFinales;
    private ArrayList<Transicion> transiciones;
    private Alfabeto alfabeto;      
    private Configuracion configuracion;
        
    /*
     * Constuctor por defecto
     */
    public AutomataFinito(){
        estados = new ArrayList<Integer>();
        estadosFinales = new ArrayList<Integer>();
        transiciones = new ArrayList<Transicion>();
    }
    
    /*
     * Métodos
     */    
    public void ingresarAlfabeto(String[] texto) throws Exception {
        alfabeto = new Alfabeto();
        alfabeto.ingresarSimbolos(texto.length, texto);
    }
    
    public void ingresarEstados(int cantidad){        
        for(int i = 0; i < cantidad; i++) {
            estados.add(i);
        }        
    }
    
    public void ingresarEstadosFinales(String[] texto) throws Exception{         
        for(int i = 0; i < texto.length; i++){
            if(Integer.parseInt(texto[i]) > 0 && Integer.parseInt(texto[i]) < getEstados().size()){
                if(pertenece(Integer.parseInt(texto[i]))){
                    if(!perteneceFinales(Integer.parseInt(texto[i]))) {
                        estadosFinales.add(Integer.parseInt(texto[i]));
                    }                
                    else {
                        throw new Exception();
                    }
                }                             
                else {
                    throw new Exception();
                }
            }
            else {
                throw new Exception();
            }                
        }
    }
    
    private boolean pertenece(int estadoFinal){
        return estados.contains(estadoFinal);
    }
    
    private boolean perteneceFinales(int estado){
        return estadosFinales.contains(estado);
    }
    
    public String getSimbolo(int index) {
        return alfabeto.getSimbolos().get(index);
    }
    
    public void nuevaTransicion(int estadoActual, String simbolo, int proximoEstado) throws MachineException{
        if(pertenece(proximoEstado)) {
            transiciones.add(new Transicion(estadoActual, simbolo, proximoEstado));
        } else {
            throw new MachineException("El estado ingresado no pertenece al Conjunto de Estados del AFD");
        }
    }
    
    public String simular(String palabra){        
        int pos = 0;
        configuracion = new Configuracion(getAlfabeto());
        configuracion.ingresarPalabra(palabra);
        configuracion.setPosicionCabezal(0);
        String resultado = "Cadena = " + configuracion.getPalabra();
        for(int i = 0; i < configuracion.getPalabra().length(); i++){
            resultado = resultado.concat("\n\nLetra leída = " + configuracion.getPalabra().charAt(i));
            for(int j = 0; j < alfabeto.getSimbolos().size(); j++){
                if(configuracion.getPalabra().charAt(i) == alfabeto.getSimbolos().get(j).charAt(0)){
                    pos=j;
                    break;                
                }
            }
            resultado = resultado.concat("\nEstado Actual = q"+configuracion.getPosicionCabezal());
            configuracion.setPosicionCabezal(proximoEstado(configuracion.getPosicionCabezal(),pos));
            resultado = resultado.concat("\nSe transiciona al estado q"+configuracion.getPosicionCabezal());
        }
        
        resultado = resultado.concat("\n\nFin del análisis de la palabra...\nSe terminó en el estado q" + configuracion.getPosicionCabezal());
        if(aceptarPalabra(configuracion.getPosicionCabezal())) {            
            resultado = resultado.concat("\nCadena Aceptada\n\n");
        }
        else {
            resultado = resultado.concat("\nCadena Rechazada\n\n");
        }                     
        return resultado;
    }
    
    private int proximoEstado(int c, int p){
        int proximoQ = 0;
        for(Transicion t: transiciones){
            if(t.getEstadoActual() == c && t.getSimbolo().equals(alfabeto.getSimbolos().get(p))) {
                proximoQ=t.getProximoEstado();
            }
        }
        return proximoQ;
    }
    
    private boolean aceptarPalabra(int posicioneCabezal){
        boolean resultado = false;
        for(Integer e: estadosFinales){
            if(e == posicioneCabezal){
                resultado = true;
                break;
            }
        }            
        return resultado;
    }
    
    /*
     * Métodos accesores y mutadores
     */
    public Configuracion getConfiguracion() {
        return configuracion;
    }   

    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public ArrayList<Integer> getEstadosFinales() {
        return estadosFinales;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }
        
    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }
}
