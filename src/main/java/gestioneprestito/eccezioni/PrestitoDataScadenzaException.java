package gestioneprestito.eccezioni;

/**
 * @class PrestitoDataScadenzaException
 * @brief Eccezione lanciata quando la data di scadenza di un prestito non è
 *        valida
 */
public class PrestitoDataScadenzaException extends PrestitoInvalidoException {

    /**
     * @brief Costruttore di default
     */
    public PrestitoDataScadenzaException() {
        super("La data di scadenza deve essere inserita e non passata rispetto a oggi!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public PrestitoDataScadenzaException(String msg) {
        super(msg);
    }
}
