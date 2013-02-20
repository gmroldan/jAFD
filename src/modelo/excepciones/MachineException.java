/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.excepciones;

/**
 *
 * @author gerardo
 */
public class MachineException extends Exception {

    /**
     * Creates a new instance of
     * <code>MachineException</code> without detail message.
     */
    public MachineException() {
    }

    /**
     * Constructs an instance of
     * <code>MachineException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MachineException(String msg) {
        super(msg);
    }
}
