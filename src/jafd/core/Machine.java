/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jafd.core;

import java.util.List;
import java.util.Set;
import jafd.exceptions.MachineException;

public abstract class Machine {
    protected Alphabet alphabet;
    protected Configuration configuration;    
    protected List<Integer> states;
    protected Set<Integer> finalStates;
    protected List<Transition> transitions;

    public void createAlphabet(String[] symbols) throws MachineException {
        this.alphabet = new Alphabet();
        this.alphabet.addSymbols(symbols);
    }

    public void addStates(int numberOfStates) {
        for (int i = 0; i < numberOfStates; i++) {
            states.add(i);
        }
    }

    public void addFinalStates(String[] finalStates) throws MachineException {
        for (String finalState : finalStates) {
            int finalStateNumber = Integer.parseInt(finalState);
            
            if (finalStateNumber > 0 && finalStateNumber < getStates().size()) {
                if (belongsToStatesCollection(finalStateNumber)) {
                    this.finalStates.add(finalStateNumber);
                } else {
                    throw new MachineException("The state " + finalStateNumber + "doesn't belong to States's collection.");
                }
            } else {
                throw new MachineException("The state " + finalStateNumber + " is not a valid states.");
            }
        }
    }

    public void newTransition(int currentState, String symbol, int nextState) throws MachineException {
        if (belongsToStatesCollection(nextState)) {
            this.transitions.add(new Transition(currentState, symbol, nextState));
        } else {
            throw new MachineException("The state " + nextState + "doesn't belong to States's collection.");
        }
    }

    protected boolean belongsToStatesCollection(int state) {
        return states.contains(state);
    }

    protected int nextState(int currentPosition, String symbol) {        
        for (Transition transition : transitions) {
            if (transition.getCurrentState() == currentPosition && transition.getSymbol().equals(symbol)) {
                return transition.getNextState();
            }
        }
        return 0;
    }
    
    protected boolean acceptWord(int headPosition) {
        return finalStates.contains(headPosition);
    }
    
    public abstract String simulate(String palabra) throws MachineException;
    
    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    
    public Alphabet getAlphabet() {
        return alphabet;
    }
    
    public Configuration getConfiguration() {
        return configuration;
    }

    public List<Integer> getStates() {
        return states;
    }

    public Set<Integer> getFinalStates() {
        return finalStates;
    }

    public String getSymbol(int index) {        
        return alphabet.getSymbols().get(index);
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
