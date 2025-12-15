
package gestioneprestito;

import java.io.Serializable;
import gestioneutente.Utente;
import gestionelibro.Libro;
import static gestioneprestito.Stato.*;
import gestioneprestito.eccezioni.PrestitoCopieEsauriteException;
import gestioneprestito.eccezioni.PrestitoDataScadenzaException;
import gestioneprestito.eccezioni.PrestitoLimitePrestitiRaggiuntoException;
import java.time.LocalDate;

/**
 * @class Prestito
 * @brief Classe che gestisce i prestiti dei libri agli utenti
 * @details La classe Prestito contiene le informazioni riguardanti un prestito,
 *          come l'utente che ha effettuato il prestito, il libro prestato,
 *          la data di scadenza del prestito e lo stato del prestito.
 */
public class Prestito implements Comparable<Prestito>, Serializable {
    private Utente utente;
    private Libro libro;
    private LocalDate dataScadenza;

    /**
     * @brief Costruttore della classe Prestito
     * @param utente L'utente che ha effettuato il prestito
     * @param libro Il libro prestato
     * @param dataScadenza La data di scadenza del prestito
     */
    public Prestito(Utente utente, Libro libro, LocalDate dataScadenza) throws PrestitoLimitePrestitiRaggiuntoException, PrestitoCopieEsauriteException, PrestitoDataScadenzaException{
         if(utente.isLimitePrestitiRaggiunto()) throw new PrestitoLimitePrestitiRaggiuntoException();
        this.utente = utente;
         if(!libro.isCopiaDisponibile()) throw new PrestitoCopieEsauriteException();
        this.libro = libro;
        if(!isDataScadenzaValida(dataScadenza)) throw new PrestitoDataScadenzaException();
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
    public Stato getStato() {
        if (dataScadenza != null && LocalDate.now().isAfter(dataScadenza)) return Stato.SCADUTO;
        return Stato.REGOLARE;
    }

    /**
     * @brief Verifica se la data di scadenza è valida.
     * @param daValidare Data di scadenza da controllare.
     * @return true se la data è valida, false altrimenti.
     */
    public boolean isDataScadenzaValida(LocalDate daValidare) {
        return daValidare != null && daValidare.isAfter(LocalDate.now());
    }

    /**
     * @brief Verifica se due prestiti sono uguali
     * @param o l'oggetto da comparare
     * @return true se sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object o) {
        if (o == null && this.getClass() != o.getClass()) return false;
        if (this == o) return true;
        Prestito prestito = (Prestito) o;
        return utente.equals(prestito.utente) && libro.equals(prestito.libro);
    }

    /**
     * @brief Restituisce l'hashcode del prestito
     * @return l'hashcode del prestito
     */
    @Override
    public int hashCode() {
        return utente.hashCode() + libro.hashCode();
    }

    /**
     * @brief Compara due prestiti.
     * @param o l'oggetto da comparare.
     * @return Valore negativo, zero o positivo secondo l'ordinamento definito.
     */
    @Override
    public int compareTo(Prestito o) {
        return this.dataScadenza.compareTo(o.dataScadenza);
    }

    /**
     * @brief Restituisce la rappresentazione in stringa del prestito
     * @return la rappresentazione in stringa del prestito
     */
    @Override
    public String toString() {
        return this.utente.toString() + "/n" + this.libro.toString();
    }

}
