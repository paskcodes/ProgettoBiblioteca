package gestioneutente.eccezioni;

/**
 * @class UtenteInvalidoException
 * @brief Eccezione lanciata quando un utente non risulta valido
 */
public class UtenteInvalidoException extends Exception{

    /**
     * @brief Costruttore di default
     */
    public UtenteInvalidoException() {
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public UtenteInvalidoException(String msg) {
        super(msg);
    }
}
