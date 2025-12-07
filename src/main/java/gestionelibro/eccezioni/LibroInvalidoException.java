/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro.eccezioni;

/**
 *
 * @author Antonio Franco
 * 
 */
public class LibroInvalidoException extends Exception{

    /**
     * Creates a new instance of <code>LibroInvalidoException</code> without
     * detail message.
     */
    public LibroInvalidoException() {
    }

    /**
     * Constructs an instance of <code>LibroInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroInvalidoException(String msg) {
        super(msg);
    }
}
