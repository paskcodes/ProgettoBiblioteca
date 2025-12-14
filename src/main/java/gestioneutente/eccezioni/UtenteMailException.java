package gestioneutente.eccezioni;



/**
 * @class UtenteMailException
 * @brief Eccezione lanciata quando la mail di un utente non rispetta il formato stabilito.
 */
public class UtenteMailException extends UtenteInvalidoException{

    /**
     * @brief Costruttore di default.
     */
    public UtenteMailException() {
        super("Mail vuota o non valida!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public UtenteMailException(String msg) {
        super(msg);
    }
}
