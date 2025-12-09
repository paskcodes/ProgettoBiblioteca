package gestioneutente.eccezioni;


/**
 * @class UtenteDuplicatoException
 * @brief Eccezione lanciata quando si tenta di registrare un utente con dati già esistenti.
 */
public class UtenteDuplicatoException extends UtenteInvalidoException{

    /**
     * @brief Costruttore di default
     */
    public UtenteDuplicatoException() {
    }

    /**
     * @brief Costruttore con messaggio personalizzato
     * @param msg Messaggio di errore
     */
    public UtenteDuplicatoException(String msg) {
        super(msg);
    }
}
