/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package controlador.dialogs;

import modelo.Alfabeto;
import modelo.AutomataFinito;

public class ControllerNA {    
    public void ingresarAlfabeto(int cantidad,String[] texto) throws Exception{
        Alfabeto alfabetoActual=new Alfabeto();
        alfabetoActual.ingresarSimbolos(cantidad, texto);
        AutomataFinito.setAlfabeto(alfabetoActual);
    }
    
}
