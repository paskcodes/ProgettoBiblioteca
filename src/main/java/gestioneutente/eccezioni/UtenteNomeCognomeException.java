package gestioneutente.eccezioni;

/**
 * @class UtenteNomeCognomeException
 * @brief Eccezione lanciata quando il nome o il cognome di un utente non sono
 *        validi
 */
public class UtenteNomeCognomeException extends UtenteInvalidoException {

    /**
     * @brief Costruttore di default
     */
    public UtenteNomeCognomeException() {
        super("Il nome deve essere inserito e può contenere solo lettere e spazi!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public UtenteNomeCognomeException(String msg) {
        super(msg);
    }
}
