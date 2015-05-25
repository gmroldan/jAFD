/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.core;

public class Transition {
    /*
     * Atributos
     */
    private int currentState;
    private int nextState;
    private String symbol;
    
    /**
     * Class constructor.
     */
    public Transition() {}
    
    /**
     * Class constructor.
     * 
     * @param currentState
     * @param symbol
     * @param nextState 
     */
    public Transition(int currentState, String symbol, int nextState){
        this.currentState = currentState;
        this.symbol = symbol;
        this.nextState = nextState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getNextState() {
        return nextState;
    }

    public String getSymbol() {
        return symbol;
    }    
}
