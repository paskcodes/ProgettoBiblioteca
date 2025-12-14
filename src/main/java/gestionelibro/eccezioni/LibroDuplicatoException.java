package gestionelibro.eccezioni;

/**
 * @class LibroDuplicatoException
 * @brief Eccezione lanciata quando si tenta di aggiungere un libro che gia' esiste nella collezione.
 */
public class LibroDuplicatoException extends LibroInvalidoException{

    /**
     * @brief Costruttore di default.
     */
    public LibroDuplicatoException() {
        super("Libro già presente in archivio!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public LibroDuplicatoException(String msg) {
        super(msg);
    }
}
