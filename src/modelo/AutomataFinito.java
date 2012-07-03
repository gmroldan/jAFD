/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package modelo;

import java.util.ArrayList;


public class AutomataFinito {    
    private static ArrayList<Integer> estados;
    private static ArrayList<Integer> estadosFinales;
    private static ArrayList<Transicion> transiciones;
    private static Alfabeto alfabeto;      
    private Configuracion configuracion;
        
    public AutomataFinito(){
        estados=new ArrayList<Integer>();
        estadosFinales=new ArrayList<Integer>();
        transiciones=new ArrayList<Transicion>();
    } 
    
    public static void ingresarEstados(int cantidad){        
        for(int i=0;i<cantidad;i++)
            estados.add(i);        
    }
    
    public static void ingresarEstadosFinales(String[] texto) throws Exception{         
        for(int i=0;i<texto.length;i++){
            if(Integer.parseInt(texto[i])>0 && Integer.parseInt(texto[i])<getEstados().size()){
                if(pertenece(Integer.parseInt(texto[i]))){
                    if(!perteneceFinales(Integer.parseInt(texto[i])))
                        estadosFinales.add(Integer.parseInt(texto[i]));                
                    else
                        throw new Exception();
                }                             
                else
                    throw new Exception();
            }
            else
                throw new Exception();                
        }
    }
    
    private static boolean pertenece(int estadoFinal){
        boolean resultado=false;
        for(int i=0;i<estados.size();i++){
            if(estados.get(i).equals(estadoFinal)){
                resultado=true;
                break;
            }
        }
        return resultado;
    }
    
    private static boolean perteneceFinales(int estado){
        boolean resultado=false;
        for(Integer e:estadosFinales){
            if(e==estado){
                resultado=true;
                break;
            }
        }        
        return resultado;
    }
    
    public static void ingresarTransiciones(int estadoActual,String simbolo,int proximoEstado){             
        transiciones.add(new Transicion(estadoActual,simbolo,proximoEstado));
    }
    
    public String simular(String palabra){        
        int pos=0;
        configuracion=new Configuracion(getAlfabeto());
        configuracion.ingresarPalabra(palabra);
        configuracion.setPosicionCabezal(0);
        String resultado="Cadena = "+configuracion.getPalabra();
        for(int i=0;i<configuracion.getPalabra().length();i++){            
            resultado=resultado.concat("\n\nLetra leída = "+configuracion.getPalabra().charAt(i));
            for(int j=0;j<alfabeto.getSimbolos().size();j++){
                if(configuracion.getPalabra().charAt(i)==alfabeto.getSimbolos().get(j).charAt(0)){
                    pos=j;
                    break;                
                }                    
            }
            resultado=resultado.concat("\nEstado Actual = q"+configuracion.getPosicionCabezal());
            configuracion.setPosicionCabezal(proximoEstado(configuracion.getPosicionCabezal(),pos));
            resultado=resultado.concat("\nSe transiciona al estado q"+configuracion.getPosicionCabezal());
        }
        
        resultado=resultado.concat("\n\nFin del análisis de la palabra...\nSe terminó en el estado q"+configuracion.getPosicionCabezal());
        if(aceptarPalabra(configuracion.getPosicionCabezal()))            
            resultado=resultado.concat("\nCadena Aceptada\n\n");
        else            
            resultado=resultado.concat("\nCadena Rechazada\n\n");                     
        return resultado;
    }
    
    private int proximoEstado(int c,int p){
        int proximoQ=0;
        for(Transicion t:getTransiciones()){
            if(t.getEstadoActual()==c && t.getSimbolo().equals(alfabeto.getSimbolos().get(p)))
                proximoQ=t.getProximoEstado();
        }
        return proximoQ;
    }
    
    public boolean aceptarPalabra(int posicioneCabezal){
        boolean resultado=false;
        for(Integer e:getEstadosFinales()){
            if(e==posicioneCabezal){
                resultado=true;
                break;
            }
        }            
        return resultado;
    }  

    public Configuracion getConfiguracion() {
        return configuracion;
    }   

    public static ArrayList<Integer> getEstados() {
        return estados;
    }

    public static ArrayList<Integer> getEstadosFinales() {
        return estadosFinales;
    }

    public static Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public static void setAlfabeto(Alfabeto alfabeto) {
        AutomataFinito.alfabeto = alfabeto;
    }
        
    public static ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }
}
