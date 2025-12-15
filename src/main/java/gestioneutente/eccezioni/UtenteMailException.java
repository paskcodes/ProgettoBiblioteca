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
        super("La mail deve essere inserita,  deve essere completa e avere il dominio giusto!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public UtenteMailException(String msg) {
        super(msg);
    }
}
