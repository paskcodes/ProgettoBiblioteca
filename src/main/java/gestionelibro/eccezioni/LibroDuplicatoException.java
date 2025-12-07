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
public class LibroDuplicatoException extends LibroInvalidoException{

    /**
     * Creates a new instance of <code>LibroDuplicatoException</code> without
     * detail message.
     */
    public LibroDuplicatoException() {
    }

    /**
     * Constructs an instance of <code>LibroDuplicatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroDuplicatoException(String msg) {
        super(msg);
    }
}
