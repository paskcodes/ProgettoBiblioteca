package gestioneprestito.eccezioni;

/**
 * @class PrestitoCopieEsauriteException
 * @brief Eccezione per tentativi di prestito senza copie disponibili.
 * @details Lanciata quando si richiede un prestito ma tutte le copie del libro
 *          risultano esaurite.
 */
public class PrestitoCopieEsauriteException extends PrestitoInvalidoException {

    /**
     * @brief Crea una nuova eccezione con messaggio di default.
     */
    public PrestitoCopieEsauriteException() {
        super("Il libro non ha più nessuna copia disponibile per un prestito!");
    }

    /**
     * @brief Crea una nuova eccezione con messaggio di dettaglio.
     * @param msg Messaggio descrittivo dell'errore.
     */
    public PrestitoCopieEsauriteException(String msg) {
        super(msg);
    }
}
