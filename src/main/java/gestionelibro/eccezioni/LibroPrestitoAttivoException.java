package gestionelibro.eccezioni;

/**
 * @class LibroPrestitoAttivoException
 * @brief Eccezione lanciata quando si tenta di eliminare un libro che ha prestiti attivi.
 */
public class LibroPrestitoAttivoException extends Exception{

    /**
     * @brief Costruttore di default.
     */
    public LibroPrestitoAttivoException() {
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public LibroPrestitoAttivoException(String msg) {
        super(msg);
    }
}
