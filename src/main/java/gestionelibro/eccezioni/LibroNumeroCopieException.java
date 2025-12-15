package gestionelibro.eccezioni;

/**
 * @class LibroNumeroCopieException
 * @brief Eccezione lanciata quando il numero di copie di un libro non risulta
 *        valido (minore di 0).
 */
public class LibroNumeroCopieException extends LibroInvalidoException {

    /**
     * @brief Costruttore di default.
     */
    public LibroNumeroCopieException() {
        super("Il numero delle copie deve essere inserito e maggiore di 1!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public LibroNumeroCopieException(String msg) {
        super(msg);
    }
}
