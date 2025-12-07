/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro.eccezioni;

/**
 *
 * @author Antonio Franco
 */
public class LibroPrestitoAttivoException extends Exception{

    /**
     * Creates a new instance of <code>LibroPrestitoAttivoException</code>
     * without detail message.
     */
    public LibroPrestitoAttivoException() {
    }

    /**
     * Constructs an instance of <code>LibroPrestitoAttivoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroPrestitoAttivoException(String msg) {
        super(msg);
    }
}
