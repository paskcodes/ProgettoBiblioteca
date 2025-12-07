/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito.eccezioni;

/**
 *
 * @author Antonio Franco
 * 
 */
public class PrestitoInvalidoException extends Exception{

    /**
     * Creates a new instance of <code>PrestitoInvalidoException</code> without
     * detail message.
     */
    public PrestitoInvalidoException() {
    }

    /**
     * Constructs an instance of <code>PrestitoInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PrestitoInvalidoException(String msg) {
        super(msg);
    }
}
