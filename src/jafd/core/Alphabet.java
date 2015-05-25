/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.core;

import java.util.HashMap;
import java.util.Map;
import jafd.exceptions.MachineException;

public class Alphabet {
    private final Map<String, String> symbols;

    /**
     * Class constructor with no-args
     */
    public Alphabet() {
        this.symbols = new HashMap<String, String>();
    }    

    /**
     * Adds an array of symbols into the Alphabet.
     * 
     * @param symbols Array of symbols that should be added into the Alphabet.
     * @throws MachineException When the length of a symbol is greater than 1.
     */
    public void addSymbols(final String[] symbols) throws MachineException {        
        for (String symbol: symbols) {
            if (symbol.length() == 1) {
                addSymbol(symbol.toLowerCase());
            } else {
                throw new MachineException("The length of a symbol can't be greater than 1.");
            }           
        }
    }
    
    /**
     * Checks if a symbol belongs to the Alphabet.
     * 
     * @param symbol Symbol to be checked.
     * @return Returns True if the symbol belongs to the Alphabet, otherwise returns False.
     */
    public boolean belongs(final char symbol) {
        return symbols.containsKey(String.valueOf(symbol));
    }    
    
    /**
     * Adds a symbol into the Alphabet.
     * 
     * @param symbol Symbol to be added.
     */
    public void addSymbol(String symbol) {
        symbols.put(symbol, symbol);
    }

    public Map<String, String> getSymbols() {
        return symbols;
    }
    
    @Override
    public String toString() {
        return symbols.toString();
    }

}
