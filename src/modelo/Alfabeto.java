/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

import java.util.ArrayList;

public class Alfabeto {
    /*
     * Atributos
     */
    private ArrayList<String> simbolos; 
    
    /*
     * Constructor por defecto
     */
    public Alfabeto(){
        simbolos = new ArrayList<String>();
    }
    
    /*
     * Métodos
     */    
    public void ingresarSimbolos(int cantidad, String[] texto) throws Exception{        
        for(int i = 0;i < cantidad; i++){
            if(!perteneceAlfabetoMayusculas(texto[i].charAt(0))){
                if(texto[i].length() == 1){
                    if(!pertenece(texto[i])){
                        simbolos.add(texto[i]);
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
    
    public boolean perteneceAlfabetoMayusculas(char simbolo){
        return (simbolo < 'A' || simbolo > 'Z')? false:true;
    }
        
    public boolean pertenece(String simbolo){       
        return simbolos.contains(simbolo);
    }

    @Override
    public String toString() {
        return simbolos.toString();
    }

    /*
     * Métodos accesores y mutadores
     */
    public ArrayList<String> getSimbolos() {
        return simbolos;
    }
}
