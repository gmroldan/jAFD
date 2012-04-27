package automatafinitodeterminista;

import java.util.*;
import javax.swing.JOptionPane;
import gui.VentanaPrincipal;


public class AutomataFinito {    
    private ArrayList<Integer> estados=new ArrayList<Integer>();
    private ArrayList<Integer> estadosFinales=new ArrayList<Integer>();
    private Alfabeto alfabeto=new Alfabeto();
    private Integer estadoInicial=0;        
    private ArrayList<Transicion> transiciones;
    private Configuracion configuracion;
        
    public AutomataFinito(){
        
    } 
    
    public void ingresarEstados(int cantidad){        
        for(int i=0;i<cantidad;i++){
            estados.add(i);
        }        
    }
    
    public void ingresarEstadosFinales(String[] texto) throws Exception{         
        for(int i=0;i<texto.length;i++){
            if(Integer.parseInt(texto[i])>0 && Integer.parseInt(texto[i])<estados.size()){
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
    
    public boolean pertenece(int estadoFinal){
        boolean resultado=false;
        for(int i=0;i<getEstados().size();i++){
            if(getEstados().get(i).equals(estadoFinal)){
                resultado=true;
                break;
            }
        }
        return resultado;
    }
    
    public boolean perteneceFinales(int estado){
        boolean resultado=false;
        for(Integer e:estadosFinales){
            if(e==estado){
                resultado=true;
                break;
            }
        }        
        return resultado;
    }
    
    public void crearNuevaTablaDeTransiciones(){        
        transiciones=new ArrayList<Transicion>();
        
    }
    
    public void ingresarTransiciones(int estadoActual,String simbolo,int proximoEstado){             
        transiciones.add(new Transicion(estadoActual,simbolo,proximoEstado));
    }
    
    public void simular(String palabra){        
        int pos=0;
        configuracion=new Configuracion(getAlfabeto());
        configuracion.ingresarPalabra(palabra);
        configuracion.setPosicionCabezal(0);
        VentanaPrincipal.textSimulacion.append("\nCadena = "+configuracion.getPalabra());
        for(int i=0;i<configuracion.getPalabra().length();i++){  
            VentanaPrincipal.textSimulacion.append("\n\nLetra leída = "+configuracion.getPalabra().charAt(i));            
            for(int j=0;j<alfabeto.getSimbolos().size();j++){
                if(configuracion.getPalabra().charAt(i)==alfabeto.getSimbolos().get(j).charAt(0)){
                    pos=j;
                    break;                
                }                    
            }  
            VentanaPrincipal.textSimulacion.append("\nEstado Actual = q"+configuracion.getPosicionCabezal());                       
            configuracion.setPosicionCabezal(proximoEstado(configuracion.getPosicionCabezal(),pos));
            VentanaPrincipal.textSimulacion.append("\nSe transiciona al estado q"+configuracion.getPosicionCabezal());                       
        }
        VentanaPrincipal.textSimulacion.append("\n\nFin del análisis de la palabra...\nSe terminó en el estado q"+configuracion.getPosicionCabezal());        
        if(aceptarPalabra(configuracion.getPosicionCabezal())){
            VentanaPrincipal.textSimulacion.append("\nCadena Aceptada\n\n");
            JOptionPane.showMessageDialog(null, "Cadena aceptada por el Autómata Finito Determinista", "Fin del Análisis", JOptionPane.INFORMATION_MESSAGE);                    
        }            
        else{
            VentanaPrincipal.textSimulacion.append("\nCadena Rechazada\n\n");
            JOptionPane.showMessageDialog(null, "Cadena rechazada por el Autómata Finito Determinista", "Fin del análisis", JOptionPane.INFORMATION_MESSAGE);
        }            
    }
    
    public int proximoEstado(int c,int p){
        int proximoQ=0;
        for(Transicion t:getTransiciones()){
            if(t.getEstadoActual()==c && t.getSimbolo()==getAlfabeto().getSimbolos().get(p)){
                proximoQ=t.getProximoEstado();
            }                
        }
        return proximoQ;
    }
    
    public boolean aceptarPalabra(int posicioneCabezal){
        boolean resultado=false;
        for(Integer e:estadosFinales){
            if(e==posicioneCabezal){
                resultado=true;
                break;
            }
        }            
        return resultado;
    }  
    
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Integer> estados) {
        this.estados = estados;
    }

    public ArrayList<Integer> getEstadosFinales() {
        return estadosFinales;
    }

    public void setEstadosFinales(ArrayList<Integer> estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

    public Integer getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Integer estadoInicial) {
        this.estadoInicial = estadoInicial;
    }   

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }   

    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(ArrayList<Transicion> transiciones) {
        this.transiciones = transiciones;
    }
}
