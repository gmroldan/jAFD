/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.core;

import java.util.ArrayList;
import java.util.HashSet;
import jafd.exceptions.MachineException;

public class DeterministicFiniteAutomaton extends Machine {
        
    /**
     * Class constructor.
     */
    public DeterministicFiniteAutomaton(){
        this.states = new ArrayList<Integer>();
        this.finalStates = new HashSet<Integer>();
        this.transitions = new ArrayList<Transition>();
    }
    
    /*
     * Implementación de métodos abstractos de la SuperClase
     */
    @Override
    public String simulate(String word) throws MachineException {        
        this.configuration = new Configuration(this.alphabet);
        this.configuration.enterWord(word);
        this.configuration.setHeadPosition(0);
        
        String currentSymbol;
        StringBuilder result = new StringBuilder();
        
        result.append("Cadena = ")
                .append(configuration.getWord());
        
        for (int i = 0; i < configuration.getWord().length(); i++) {
            currentSymbol = String.valueOf(configuration.getWord().charAt(i));
            
            result.append("\n\nLetra leída = ")
                    .append(currentSymbol)
                    .append("\nEstado Actual = q")
                    .append(configuration.getHeadPosition());
            
            this.configuration.setHeadPosition(nextState(configuration.getHeadPosition(), currentSymbol));
            
            result.append("\nSe transiciona al estado q")
                    .append(configuration.getHeadPosition());
        }
        
        result.append("\n\nFin del análisis de la palabra...\nSe terminó en el estado q")
                .append(configuration.getHeadPosition());
        
        if (acceptWord(configuration.getHeadPosition())) {            
            result.append("\nCadena Aceptada\n\n");
        } else {
            result.append("\nCadena Rechazada\n\n");
        }
        
        return result.toString();
    }
}
