package gestionearchivio;

import javafx.collections.ObservableList;

/**
 * @brief Interfaccia che definisce i metodi comuni per la gestione di un archivio.
 * @param <T> Tipo generico dell'elemento da archiviare.
 * @param <E> Tipo generico dell'eccezione che può essere lanciata durante l'operazione.
 */
public interface Archiviabile <T, E extends Exception>{
    public void inserisciNuovoElemento(T nuovoElemento) throws E;
    
    public boolean isElementoPresente(T daCercare);
    
    public ObservableList<T> getListaElementi();
}
