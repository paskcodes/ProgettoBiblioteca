package gestioneprestito.eccezioni;

/**
 * @class PrestitoDuplicatoException
 * @brief Eccezione lanciata quando si tenta di aggiungere un prestito già
 *        esistente.
 */
public class PrestitoDuplicatoException extends PrestitoInvalidoException {

    /**
     * @brief Costruttore di default
     */
    public PrestitoDuplicatoException() {
        super("Il prestito è già registrato in archivio!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public PrestitoDuplicatoException(String msg) {
        super(msg);
    }
}
