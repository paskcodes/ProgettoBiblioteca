/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionearchivio;

import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Franco
 */
public interface Archiviabile <T, E extends Exception>{
    public void inserisciNuovoElemento(T nuovoElemento) throws E;
    
    public boolean isElementoPresente(T daCercare);
    
    public ObservableList<T> getListaElementi();
}
