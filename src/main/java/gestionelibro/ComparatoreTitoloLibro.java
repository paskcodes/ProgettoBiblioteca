/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro;

import java.util.Comparator;

/**
 * @class ComparatoreTitoloLibro
 * @brief Confronta due libri in base al titolo.
 * @details Implementa Comparator per ordinare oggetti Libro alfabeticamente sul titolo.
 * @author Antonio Franco
 */
public class ComparatoreTitoloLibro implements Comparator<Libro>{

    
    /**
     * @brief Confronta due libri secondo il loro titolo.
     * @param l1 Primo libro da confrontare.
     * @param l2 Secondo libro da confrontare.
     * @return Valore negativo, zero o positivo se il titolo di l1 è rispettivamente
     *         precedente, uguale o successivo al titolo di l2.
     */
    @Override
    public int compare(Libro l1, Libro l2) {
        return l1.getTitolo().compareTo(l2.getTitolo());
    }

  
    
}
