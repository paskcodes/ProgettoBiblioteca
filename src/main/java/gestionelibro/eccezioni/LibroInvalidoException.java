package gestionelibro.eccezioni;

/**
 * @class LibroInvalidoException
 * @brief Classe che rappresenta l'eccezione lanciata quando un libro
 *        non rispetta i vincoli imposti.
 */
public class LibroInvalidoException extends Exception{

    /**
     * @brief Costruttore di default della classe LibroInvalidoException.
     */
    public LibroInvalidoException() {
    }

    /**
     * @brief Costruttore della classe LibroInvalidoException che accetta un
     *        messaggio di errore.
     * @param msg Messaggio di errore associato all'eccezione.
     */
    public LibroInvalidoException(String msg) {
        super(msg);
    }
}
