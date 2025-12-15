package gestioneprestito.eccezioni;

/**
 * @class PrestitoLimitePrestitiRaggiuntoException
 * @brief Eccezione per superamento del limite massimo di prestiti consentiti.
 * @details Lanciata quando un utente tenta di creare un nuovo prestito oltre il limite previsto.
 * @author Antonio Franco
 */
public class PrestitoLimitePrestitiRaggiuntoException extends PrestitoInvalidoException{

    /**
     * @brief Crea una nuova eccezione senza messaggio di dettaglio.
     */
    public PrestitoLimitePrestitiRaggiuntoException() {
        super("L'utente ha già 3 prestiti attivi!");
    }

    /**
     * @brief Crea una nuova eccezione con messaggio di dettaglio.
     * @param msg Messaggio descrittivo dell'errore.
     */
    public PrestitoLimitePrestitiRaggiuntoException(String msg) {
        super(msg);
    }
}
