/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.eccezioni;


/**
 *
 * @author Antonio Franco
 * 
 */
public class UtenteDuplicatoException extends UtenteInvalidoException{

    /**
     * Creates a new instance of <code>UtenteDuplicatoException</code> without
     * detail message.
     */
    public UtenteDuplicatoException() {
    }

    /**
     * Constructs an instance of <code>UtenteDuplicatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UtenteDuplicatoException(String msg) {
        super(msg);
    }
}
