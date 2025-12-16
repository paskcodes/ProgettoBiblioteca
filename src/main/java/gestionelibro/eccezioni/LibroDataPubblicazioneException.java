package gestionelibro.eccezioni;

/**
 * @class LibroDataPubblicazioneException
 * @brief Eccezione lanciata quando la data di pubblicazione di un libro non è
 *        valida.
 */
public class LibroDataPubblicazioneException extends LibroInvalidoException {

    /**
     * @brief Costruttore di default.
     */
    public LibroDataPubblicazioneException() {
        super("La data di pubblicazione deve essere inserita e non futura rispetto a oggi!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public LibroDataPubblicazioneException(String msg) {
        super(msg);
    }
}
