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
public class PrestitoDuplicatoException extends PrestitoInvalidoException{

    /**
     * Creates a new instance of <code>PrestitoDuplicatoException</code> without
     * detail message.
     */
    public PrestitoDuplicatoException() {
    }

    /**
     * Constructs an instance of <code>PrestitoDuplicatoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PrestitoDuplicatoException(String msg) {
        super(msg);
    }
}
