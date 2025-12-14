/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.eccezioni;

/**
 *
 * @author Antonio Franco
 */
public class UtenteMatricolaException extends UtenteInvalidoException{

    /**
     * Creates a new instance of <code>UtenteMatricolaException</code> without
     * detail message.
     */
    public UtenteMatricolaException() {
        super("Matricola vuota o non valida!");
    }

    /**
     * Constructs an instance of <code>UtenteMatricolaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UtenteMatricolaException(String msg) {
        super(msg);
    }
}
