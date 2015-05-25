/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.controller;

import jafd.core.DeterministicFiniteAutomaton;
import jafd.core.Machine;
import jafd.core.Transition;
import java.util.List;
import jafd.exceptions.MachineException;

public class JAfdController {
    private static final JAfdController INSTANCE = new JAfdController();
    private Machine machine;

    private JAfdController() {}  
    
    public static JAfdController getInstance() {
        return INSTANCE;
    }
    
    public void newDFA(){
        this.machine = new DeterministicFiniteAutomaton();
    }
    
    public void enterAlphabet(String[] alphabet) throws MachineException {
        this.machine.createAlphabet(alphabet);
    }
    
    public void enterStates(int numberOfStates) {
        this.machine.addStates(numberOfStates);
    }
    
    public void enterFinalStates(String[] finalStates) throws MachineException{
        this.machine.addFinalStates(finalStates);       
    }
    
    public void newTransition(int currentState, String currentSymbol, int nextState) throws MachineException {
        this.machine.newTransition(currentState, currentSymbol, nextState);
    }
    
    public String simulate(String word) throws MachineException {
        return machine.simulate(word);
    }

    public Machine getCurrentMachine() {
        return machine;
    }
    
    public String getAlphabet() {
        return machine.getAlphabet().toString();
    }
    
    public String getStates() {
        return machine.getStates().toString();
    }
    
    public String getFinalStates() {
        return machine.getFinalStates().toString();
    }
    
    public List<Transition> getTransitions() {
        return machine.getTransitions();
    }
    
    public int getNumberOfStates() {
        return machine.getStates().size();
    }
    
    public Object[] getSymbols() {
        return machine.getAlphabet().getSymbols().values().toArray();
    }
}
