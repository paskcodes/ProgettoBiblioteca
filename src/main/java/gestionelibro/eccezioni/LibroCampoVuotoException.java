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
public class LibroCampoVuotoException extends LibroInvalidoException{

    /**
     * Creates a new instance of <code>LibroCampoVuotoException</code> without
     * detail message.
     */
    public LibroCampoVuotoException() {
        super("I campi non possono essere lasciati vuoti!");
    }

    /**
     * Constructs an instance of <code>LibroCampoVuotoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroCampoVuotoException(String msg) {
        super(msg);
    }
}
