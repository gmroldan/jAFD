/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

import modelo.excepciones.MachineException;

public class Configuracion {
    /*
     * Atributos
     */
    private Alfabeto alfabeto;
    private String palabra;    
    private int posicionCabezal;
    
    /*
     * Constructor
     */
    public Configuracion(Alfabeto alfabeto){
        this.alfabeto = alfabeto;        
    }
    
    /*
     * Métodos
     */
    public void ingresarPalabra(String palabra) throws MachineException {        
        if(!perteneceAlfabeto(palabra)) {            
            throw new MachineException("Verifique la cadena ingresada");
        } else {
            this.palabra = palabra;
        }                        
    }
    
    public boolean perteneceAlfabeto(String palabra) {
        boolean resultado = true;
        for(int i = 0; i < palabra.length(); i++){
            if(!alfabeto.pertenece(String.valueOf(palabra.charAt(i)))){
                resultado = false;
                break;
            }
        }
        return resultado;
    }
    
    /*
     * Métodos accesores y mutadores
     */
    public String getPalabra() {
        return palabra;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public int getPosicionCabezal() {
        return posicionCabezal;
    }

    public void setPosicionCabezal(int posicionCabezal) {
        this.posicionCabezal = posicionCabezal;
    }    
}
