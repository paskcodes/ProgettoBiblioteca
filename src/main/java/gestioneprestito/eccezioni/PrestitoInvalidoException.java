package gestioneprestito.eccezioni;

/**
 * @class PrestitoInvalidoException
 * @brief Eccezione lanciata quando si tenta di creare un prestito non valido
 */
public class PrestitoInvalidoException extends Exception {

    /**
     * @brief Costruttore di default
     */
    public PrestitoInvalidoException() {
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public PrestitoInvalidoException(String msg) {
        super(msg);
    }
}
