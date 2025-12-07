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
public class PrestitoDataScadenzaException extends PrestitoInvalidoException{

    /**
     * Creates a new instance of <code>PrestitoDataScadenzaException</code>
     * without detail message.
     */
    public PrestitoDataScadenzaException() {
    }

    /**
     * Constructs an instance of <code>PrestitoDataScadenzaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PrestitoDataScadenzaException(String msg) {
        super(msg);
    }
}
