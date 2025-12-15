/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.eccezioni;

/**
 * @class UtenteMatricolaException
 * @brief Eccezione lanciata quando la matricola di un utente non rispetta il formato
 */
public class UtenteMatricolaException extends UtenteInvalidoException {

    /**
     * @brief Costruttore di default.
     */
    public UtenteMatricolaException() {
        super("La matricola deve essere inserita e può contenere solo numeri!");
    }

    /**
     * @brief Costruttore con messaggio personalizzato.
     * @param msg Messaggio di errore.
     */
    public UtenteMatricolaException(String msg) {
        super(msg);
    }
}
