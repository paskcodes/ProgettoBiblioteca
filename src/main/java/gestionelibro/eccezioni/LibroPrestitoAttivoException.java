package gestionelibro.eccezioni;

/**
 * @class LibroPrestitoAttivoException
 * @brief Eccezione lanciata quando si tenta di eliminare un libro che ha
 *        prestiti attivi.
 */
public class LibroPrestitoAttivoException extends LibroInvalidoException {

    /**
     * @brief Costruttore di default.
     */
    public LibroPrestitoAttivoException() {
        super("Il libro è ancora in prestito a degli utenti!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public LibroPrestitoAttivoException(String msg) {
        super(msg);
    }
}
