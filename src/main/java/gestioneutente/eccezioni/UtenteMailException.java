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
public class UtenteMailException extends UtenteInvalidoException{

    /**
     * Creates a new instance of <code>UtenteMailException</code> without detail
     * message.
     */
    public UtenteMailException() {
    }

    /**
     * Constructs an instance of <code>UtenteMailException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UtenteMailException(String msg) {
        super(msg);
    }
}
