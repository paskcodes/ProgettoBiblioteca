        
package gestioneprestito;

import java.io.Serializable;
import gestionelibro.Libro;
import gestioneutente.Utente;
import java.time.LocalDate;

/**
 * @class Prestito
 * @brief Classe che gestisce i prestiti dei libri agli utenti
 * @details La classe Prestito contiene le informazioni riguardanti un prestito,
 *          come l'utente che ha effettuato il prestito, il libro prestato,
 *          la data di scadenza del prestito e lo stato del prestito.
 */
public class Prestito implements Comparable<Prestito>, Serializable{
    private Utente utente;
    private Libro libro;
    private LocalDate dataScadenza;
    private Stato stato;
    private static Utente utentePrePrestito;
    private static Libro libroPrePrestito;
    
    /**
     * @brief Costruttore della classe Prestito
     * @param utente L'utente che ha effettuato il prestito
     * @param libro Il libro prestato
     * @param dataScadenza La data di scadenza del prestito
     */
    public Prestito(Utente utente, Libro libro, LocalDate dataScadenza){
        this.utente = utente;
        this.libro = libro;
        this.dataScadenza = dataScadenza;
    }

    /**
     * @brief Imposta l'utente che ha effettuato il prestito
     * @param utente L'utente che ha effettuato il prestito
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    /**
     * @brief Imposta il libro prestato
     * @param libro Il libro prestato
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @brief Imposta la data di scadenza del prestito
     * @param dataScadenza La data di scadenza del prestito
     */
    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
    
    /**
     * @brief Imposta l'utente da utilizzare prima della creazione del prestito.
     * @param utente Utente preselezionato per il prestito.
     */
    public static void setUtentePrePrestito(Utente utente){
    }
    
    /**
     * @brief Imposta il libro da utilizzare prima della creazione del prestito.
     * @param libro Libro preselezionato per il prestito.
     */
    public static void setLibroPrePrestito(Libro libro){
    }

    /**
     * @brief Restituisce l'utente che ha effettuato il prestito
     * @return L'utente che ha effettuato il prestito
     */
    public Utente getUtente() {
        return this.utente;
    }

    /**
     * @brief Restituisce il libro prestato
     * @return Il libro prestato
     */
    public Libro getLibro() {
        return this.libro;
    }

    /**
     * @brief Restituisce la data di scadenza del prestito
     * @return La data di scadenza del prestito
     */
    public LocalDate getDataScadenza() {
        return this.dataScadenza;
    }

    /**
     * @brief Restituisce lo stato del prestito.
     * @return Stato attuale del prestito.
     */
    public Stato getStato(){
        return this.stato;
    }
    
    /**
     * @brief Verifica se la data di scadenza è valida.
     * @param daValidare Data di scadenza da controllare.
     * @return true se la data è valida, false altrimenti.
     */
    public static boolean isDataScadenzaValida(LocalDate daValidare){
        return true;
    }

    /**
     * @brief Verifica se due prestiti sono uguali
     * @param o l'oggetto da comparare 
     * @return true se sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object o){
        return true;
    }
    
    /**
     * @brief Restituisce l'hashcode del prestito
     * @return l'hashcode del prestito
     */
    @Override
    public int hashCode(){
        return 0;
    }
    
    /**
     * @brief Compara due prestiti.
     * @param o l'oggetto da comparare.
     * @return Valore negativo, zero o positivo secondo l'ordinamento definito.
     * @throws UnsupportedOperationException se il confronto non è implementato.
     */
    @Override
    public int compareTo(Prestito o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @brief Restituisce la rappresentazione in stringa del prestito
     * @return la rappresentazione in stringa del prestito
     */
    @Override
    public String toString(){
        return "PRESTITO";
    }
    

    
}
