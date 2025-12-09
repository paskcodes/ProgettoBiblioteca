package gestionelibro.eccezioni;

/**
 *  @class LibroNumeroCopieException
 *  @brief Eccezione lanciata quando il numero di copie di un libro non risulta
 *         valido (minore di 0).
 */
public class LibroNumeroCopieException extends LibroInvalidoException{

    /**
     * @brief Costruttore di default.
     */
    public LibroNumeroCopieException() {
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public LibroNumeroCopieException(String msg) {
        super(msg);
    }
}
