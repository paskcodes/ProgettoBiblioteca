/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito.eccezioni;

/**
 * @class PrestitoCopieEsauriteException
 * @brief Eccezione per tentativi di prestito senza copie disponibili.
 * @details Lanciata quando si richiede un prestito ma tutte le copie del libro risultano esaurite.
 * @author Antonio Franco
 */
public class PrestitoCopieEsauriteException extends PrestitoInvalidoException{

    /**
     * @brief Crea una nuova eccezione senza messaggio di dettaglio.
     */
    public PrestitoCopieEsauriteException() {
        super("Il libro non ha più nessuna copia disponibile per un prestito!");
    }

    /**
     * @brief Crea una nuova eccezione con messaggio di dettaglio.
     * @param msg Messaggio descrittivo dell'errore.
     */
    public PrestitoCopieEsauriteException(String msg) {
        super(msg);
    }
}
