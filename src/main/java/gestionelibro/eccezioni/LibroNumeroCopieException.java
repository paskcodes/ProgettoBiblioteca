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
public class LibroNumeroCopieException extends LibroInvalidoException{

    /**
     * Creates a new instance of <code>LibroNumeroCopieException</code> without
     * detail message.
     */
    public LibroNumeroCopieException() {
    }

    /**
     * Constructs an instance of <code>LibroNumeroCopieException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroNumeroCopieException(String msg) {
        super(msg);
    }
}
