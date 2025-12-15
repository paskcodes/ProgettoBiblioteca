/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro.eccezioni;

/**
 * @class LibroCampoVuotoException
 * @brief Eccezione lanciata quando un campo obbligatorio di un libro è vuoto.
 */
public class LibroCampoVuotoException extends LibroInvalidoException {

    /**
     * @brief Costruttore della classe LibroCampoVuotoException
     */
    public LibroCampoVuotoException() {
        super("I campi non possono essere lasciati vuoti!");
    }

    /**
     * @brief Costruttore della classe LibroCampoVuotoException con messaggio personalizzato
     * @param msg the detail message.
     */
    public LibroCampoVuotoException(String msg) {
        super(msg);
    }
}
