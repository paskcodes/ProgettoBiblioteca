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
public class UtentePrestitoAttivoException extends Exception{

    /**
     * Creates a new instance of <code>UtentePrestitoAttivoException</code>
     * without detail message.
     */
    public UtentePrestitoAttivoException() {
    }

    /**
     * Constructs an instance of <code>UtentePrestitoAttivoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public UtentePrestitoAttivoException(String msg) {
        super(msg);
    }
}
