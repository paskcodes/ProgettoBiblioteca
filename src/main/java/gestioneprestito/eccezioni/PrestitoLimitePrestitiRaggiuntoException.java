/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    }

    /**
     * @brief Crea una nuova eccezione con messaggio di dettaglio.
     * @param msg Messaggio descrittivo dell'errore.
     */
    public PrestitoLimitePrestitiRaggiuntoException(String msg) {
        super(msg);
    }
}
