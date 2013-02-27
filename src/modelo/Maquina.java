/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.excepciones.MachineException;

public abstract class Maquina {
    /*
     * Atributos
     */
    protected Alfabeto alfabeto;
    protected Configuracion configuracion;    
    protected ArrayList<Integer> estados;
    protected ArrayList<Integer> estadosFinales;
    protected ArrayList<Transicion> transiciones;

    /*
     * Métodos
     */
    public void ingresarAlfabeto(String[] texto) throws Exception {
        alfabeto = new Alfabeto();
        alfabeto.ingresarSimbolos(texto.length, texto);
    }

    public void ingresarEstados(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            estados.add(i);
        }
    }

    public void ingresarEstadosFinales(String[] texto) throws Exception {
        for (int i = 0; i < texto.length; i++) {
            if (Integer.parseInt(texto[i]) > 0 && Integer.parseInt(texto[i]) < getEstados().size()) {
                if (pertenece(Integer.parseInt(texto[i]))) {
                    if (!perteneceFinales(Integer.parseInt(texto[i]))) {
                        estadosFinales.add(Integer.parseInt(texto[i]));
                    } else {
                        throw new Exception();
                    }
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        }
    }

    public void nuevaTransicion(int estadoActual, String simbolo, int proximoEstado) throws MachineException {
        if (pertenece(proximoEstado)) {
            transiciones.add(new Transicion(estadoActual, simbolo, proximoEstado));
        } else {
            throw new MachineException("El estado ingresado no pertenece al Conjunto de Estados del AFD");
        }
    }

    protected boolean pertenece(int estadoFinal) {
        return estados.contains(estadoFinal);
    }

    protected boolean perteneceFinales(int estado) {
        return estadosFinales.contains(estado);
    }

    protected int proximoEstado(int c, int p) {
        int proximoQ = 0;
        for (Transicion t : transiciones) {
            if (t.getEstadoActual() == c && t.getSimbolo().equals(alfabeto.getSimbolos().get(p))) {
                proximoQ = t.getProximoEstado();
            }
        }
        return proximoQ;
    }
    
    protected boolean aceptarPalabra(int posicioneCabezal) {
        boolean resultado = false;
        for (Integer e : estadosFinales) {
            if (e == posicioneCabezal) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
    
    public abstract String simular(String palabra) throws MachineException;
    
    /*
     * Métodos accesores y mutadores
     */
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }
    
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }
    
    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public ArrayList<Integer> getEstadosFinales() {
        return estadosFinales;
    }

    public String getSimbolo(int index) {
        return alfabeto.getSimbolos().get(index);
    }

    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }
}
