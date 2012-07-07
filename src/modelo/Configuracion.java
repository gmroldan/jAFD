/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

import javax.swing.JOptionPane;

public class Configuracion {
    private Alfabeto alfabeto;
    private String palabra;    
    private int posicionCabezal;
    
    public Configuracion(Alfabeto alfabeto){
        this.alfabeto=alfabeto;        
    }
    
    public void ingresarPalabra(String palabra){        
        if(!perteneceAlfabeto(palabra))
            JOptionPane.showMessageDialog(null, "Verifique la cadena ingresada", "ERROR", JOptionPane.ERROR_MESSAGE);//modificar esta línea
        else
            this.palabra=palabra;                        
    }
    
    public boolean perteneceAlfabeto(String palabra){
        boolean resultado=true;
        for(int i=0;i<palabra.length();i++){
            if(!alfabeto.pertenece(String.valueOf(palabra.charAt(i)))){
                resultado=false;
                break;
            }
        }
        return resultado;
    }

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
