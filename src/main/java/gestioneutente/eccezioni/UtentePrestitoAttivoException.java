package gestioneutente.eccezioni;

/**
 * @class UtentePrestitoAttivoException
 * @brief Eccezione lanciata quando si tenta di eliminare un utente che ha prestiti attivi.
 */
public class UtentePrestitoAttivoException extends UtenteInvalidoException{

    /**
     * @brief Costruttore di default
     */
    public UtentePrestitoAttivoException() {
        super("L'utente ha ancora in prestito dei libri!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public UtentePrestitoAttivoException(String msg) {
        super(msg);
    }
}
