/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente;

import java.util.Comparator;

/**
 * @class ComparatoreCognomeNomeUtente
 * @brief Confronta utenti per cognome e, a parità, per nome.
 * @details Implementa Comparator per ordinare alfabeticamente gli utenti in
 *          base a cognome e nome.
 */
public class ComparatoreCognomeNomeUtente implements Comparator<Utente> {

    /**
     * @brief Confronta due utenti in base a cognome e nome.
     * @param u1 Primo utente da confrontare.
     * @param u2 Secondo utente da confrontare.
     * @return Valore negativo, zero o positivo secondo l'ordine alfabetico prima
     *         del cognome e poi del nome.
     */
    @Override
    public int compare(Utente u1, Utente u2) {

        if (u1.getCognome().equals(u2.getCognome()))
            return u1.getNome().compareTo(u2.getNome());
        return u1.getCognome().compareTo(u2.getCognome());

    }

}
