
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
public class Prestito implements Comparable, Serializable{
    private String utente;
    private String libro;
    private LocalDate dataScadenza;
    private Stato stato;
    
    /**
     * @brief Costruttore della classe Prestito
     * @param utente L'utente che ha effettuato il prestito
     * @param libro Il libro prestato
     * @param dataScadenza La data di scadenza del prestito
     */
    public Prestito(String utente, String libro, LocalDate dataScadenza){
        this.utente = utente;
        this.libro = libro;
        this.dataScadenza = dataScadenza;
    }

    /**
     * @brief Imposta l'utente che ha effettuato il prestito
     * @param utente L'utente che ha effettuato il prestito
     */
    public void setUtente(String utente) {
        this.utente = utente;
    }

    /**
     * @brief Imposta il libro prestato
     * @param libro Il libro prestato
     */
    public void setLibro(String libro) {
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
     * @brief Restituisce l'utente che ha effettuato il prestito
     * @return L'utente che ha effettuato il prestito
     */
    public String getUtente() {
        return this.utente;
    }

    /**
     * @brief Restituisce il libro prestato
     * @return Il libro prestato
     */
    public String getLibro() {
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
     * @brief Restituisce lo stato del prestito
     * @param stato Lo stato del prestito
     */
    public Stato getStato(){
        return this.stato;
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
     * @brief Compara due prestiti
     * @param o l'oggetto da comparare 
     */
    @Override
    public int compareTo(Object o) {
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
