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
    //permette di inserire un nuovo elemento in archivio
    public void inserisciNuovoElemento(T nuovoElemento) throws E;
    
    //verifica la presenza dell'elemento in archivio
    public boolean isElementoPresente(T daCercare);
    
    //restituisce la lista degli elementi dell'archivio
    public ObservableList<T> getListaElementi();
}
