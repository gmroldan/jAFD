/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

import java.util.ArrayList;

public class Alfabeto {
    private ArrayList<String> simbolos; 
    
    public Alfabeto(){
        simbolos=new ArrayList<String>();
    }
    
    public void ingresarSimbolos(int cantidad,String[] texto) throws Exception{        
        for(int i=0;i<cantidad;i++){
            if(!perteneceAlfabetoMayusculas(texto[i].charAt(0))){
                if(texto[i].length()==1){
                    if(!pertenece(texto[i])){
                        simbolos.add(texto[i]);
                    }
                }
                else
                    throw new Exception();                    
            }                
            else
                throw new Exception();                
        }
    }
    
    public boolean perteneceAlfabetoMayusculas(char simbolo){
        return (simbolo<'A' || simbolo>'Z')? false:true;
    }
    
    public boolean pertenece(String simbolo){
        boolean resultado=false;
        for(int i=0;i<simbolos.size();i++){
            if(simbolos.get(i).equals(simbolo)){
                resultado=true;
                break;
            }
        }        
        return resultado;
    }    
    
    public boolean pertenece(char simbolo){
        boolean resultado=false;
        for(int i=0;i<simbolos.size();i++){
            if(simbolos.get(i).charAt(0)==simbolo){
                resultado=true;
                break;
            }
        }        
        return resultado;
    }

    public ArrayList<String> getSimbolos() {
        return simbolos;
    }
}
