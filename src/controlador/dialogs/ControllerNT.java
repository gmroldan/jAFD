/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package controlador.dialogs;

import modelo.AutomataFinito;

public class ControllerNT {
    public void nuevaTransicion(int estadoActual,String simbolo,int proximoEstado){
        AutomataFinito.ingresarTransiciones(estadoActual, simbolo, proximoEstado);
    }
}
