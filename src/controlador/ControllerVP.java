/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package controlador;

import modelo.AutomataFinito;

public class ControllerVP {
    private AutomataFinito afdActual;
    
    public void nuevoAFD(){
        afdActual=new AutomataFinito();
    }
    
    public String simularAFD(String palabra){
        return afdActual.simular(palabra);
    }

    public AutomataFinito getAfdActual() {
        return afdActual;
    }    
}
