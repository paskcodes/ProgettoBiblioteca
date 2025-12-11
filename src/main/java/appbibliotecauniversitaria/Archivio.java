/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecauniversitaria;

import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroDuplicatoException;
import gestionelibro.eccezioni.LibroInvalidoException;
import gestionelibro.eccezioni.LibroPrestitoAttivoException;
import gestioneprestito.Prestito;
import gestioneprestito.eccezioni.PrestitoDuplicatoException;
import gestioneprestito.eccezioni.PrestitoInvalidoException;
import gestioneutente.ComparatoreCognomeNomeUtente;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteDuplicatoException;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
import gestioneutente.eccezioni.UtentePrestitoAttivoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

/**
 * @class Archivio
 * * @brief Archivio dei dati dell'applicazione.
 * * Gestisce l'interazione con l'archivio della biblioteca.
 * * @details La classe Archivio conserva i dati di ogni possibile elemento della Biblioteca in delle 
 * * apposite liste osservabili e permette l'inserimento di nuovi dati attraverso metodi di verifica della presenza di
 * * duplicati e controlli pre-inserimento
 */
public class Archivio {
    private static ObservableList<Utente> listaUtenti = FXCollections.observableArrayList();
    private static ObservableList<Libro> listaLibri = FXCollections.observableArrayList();
    private static ObservableList<Prestito> listaPrestiti = FXCollections.observableArrayList();
    /**
     * @brief Inserisce un nuovo utente nell'archivio.
     * @param nuovoUtente Utente da inserire.
     * @throws UtenteDuplicatoException se l'utente esiste già.
     * @throws UtenteInvalidoException se i dati dell'utente non sono validi.
     */
    public static void inserisciNuovoUtente(Utente nuovoUtente) throws UtenteDuplicatoException, UtenteInvalidoException{
        
        if(isUtentePresente(nuovoUtente) == true) throw new UtenteDuplicatoException();
        
        
        listaUtenti.add(nuovoUtente);
        FXCollections.sort(listaUtenti, new ComparatoreCognomeNomeUtente());
        System.out.println("AGGIUNTO");
        //FXCollections.sort(listaUtenti);
    }
    
    /**
     * @brief Inserisce un nuovo libro nell'archivio.
     * @param nuovoLibro Libro da inserire.
     * @throws LibroDuplicatoException se il libro è già presente.
     * @throws LibroInvalidoException se i dati del libro non sono validi.
     */
    public static void inserisciNuovoLibro(Libro nuovoLibro) throws LibroDuplicatoException, LibroInvalidoException{
    }
    
    /**
     * @brief Inserisce un nuovo prestito.
     * @param nuovoPrestito Prestito da inserire.
     * @throws PrestitoDuplicatoException se il prestito è già presente.
     * @throws PrestitoInvalidoException se i dati del prestito non sono validi.
     */
    public static void inserisciNuovoPrestito(Prestito nuovoPrestito) throws PrestitoDuplicatoException, PrestitoInvalidoException{
    }
    
    /**
     * @brief Rimuove un utente dall'archivio.
     * @param daEliminare Utente da eliminare.
     * @throws UtentePrestitoAttivoException se l'utente ha prestiti attivi.
     */
    public static void estraiUtente(Utente daEliminare) throws UtentePrestitoAttivoException{
        if(inPrestitoAttivoUtente(daEliminare)) throw new UtentePrestitoAttivoException();
        listaPrestiti.remove(daEliminare);
    }
    
    /**
     * @brief Rimuove un libro dall'archivio.
     * @param daEliminare Libro da eliminare.
     * @throws LibroPrestitoAttivoException se il libro è in prestito attivo.
     */
    public static void estraiLibro(Libro daEliminare) throws LibroPrestitoAttivoException{
    }
    
    /**
     * @brief Estingue un prestito dall'archivio.
     * @param daEstinguere Prestito da estinguere.
     */
    public static void estraiPrestito(Prestito daEstinguere){
    }
    
    /**
     * @brief Verifica se un utente ha prestiti attivi.
     * @param indagato Utente da controllare.
     * @return true se l'utente ha prestiti attivi, false altrimenti.
     */
    public static boolean inPrestitoAttivoUtente(Utente indagato){
        return listaPrestiti.stream().anyMatch(p -> p.getUtente().equals(indagato));
    }
    
    /**
     * @brief Verifica se un libro è in prestito attivo.
     * @param indagato Libro da controllare.
     * @return true se il libro è in prestito attivo, false altrimenti.
     */
    public static boolean inPrestitoAttivoLibro(Libro indagato){
        return false;
    }
    
    /**
     * @brief Verifica se un utente è già presente.
     * @param nuovoUtente Utente da verificare.
     * @return true se presente, false altrimenti.
     */
    public static boolean isUtentePresente(Utente nuovoUtente){
        return listaUtenti.stream().anyMatch(u -> u.getNome().equals(nuovoUtente.getNome())); // Trova il primo che corrisponde
    }
    
    /**
     * @brief Verifica se un libro è presente nella tabella.
     * @param[in] nuovoLibro Il libro da verificare.
     * @return true se il libro è presente, false altrimenti.
     */
    public static boolean isLibroPresente(Libro nuovoLibro){
        return false;
    }
    
    /**
     * @brief Controlla se un prestito esiste.
     * @param nuovoPrestito Prestito da controllare.
     * @return true se il prestito esiste, false altrimenti.
     */
    public static boolean isPrestitoPresente(Prestito nuovoPrestito){
        return false;
    }
    
    /**
     * @brief Restituisce la lista degli utenti.
     * @return Lista osservabile di utenti.
     */
    public static ObservableList<Utente> getListaUtenti(){
        return listaUtenti;
    }
    
    /**
     * @brief Restituisce la lista dei libri.
     * @return Lista osservabile di libri.
     */
    public static ObservableList<Libro> getListaLibri(){
        return listaLibri;
    }
    
    /**
     * @brief Restituisce la lista dei prestiti.
     * @return Lista osservabile di prestiti.
     */
    public static ObservableList<Prestito> getListaPrestiti(){
        return listaPrestiti;
    }
   
}
