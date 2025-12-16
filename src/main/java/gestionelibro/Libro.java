package gestionelibro;

import gestionelibro.eccezioni.LibroCampoVuotoException;
import gestionelibro.eccezioni.LibroDataPubblicazioneException;
import gestionelibro.eccezioni.LibroNumeroCopieException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @class Libro
 * @brief Implementa un libro con i suoi attributi principali
 * @details La classe Libro implementa un libro con i suoi attributi principali
 *          come titolo, autori, data di pubblicazione, ISBN e numero di copie
 *          disponibili.
 *          Fornisce metodi per accedere e modificare questi attributi,
 *          confrontare libri e per verificare la disponibilità delle copie.
 */
public class Libro implements Comparable<Libro>, Serializable {
    private String titolo;
    private String autori;
    private LocalDate dataPubblicazione;
    private final String ISBN;
    private int copie;

    /**
     * @brief Costruttore della classe Libro
     * @details Crea un nuovo libro con i parametri forniti, verificando la validità
     *          di ciascun attributo.
     * @param titolo            Il titolo del libro
     * @param autori            Gli autori del libro
     * @param dataPubblicazione La data di pubblicazione del libro
     * @param ISBN              L'ISBN del libro
     * @param copie             Il numero di copie disponibili del libro
     */
    public Libro(String titolo, String autori, LocalDate dataPubblicazione, String ISBN, int copie)
            throws LibroDataPubblicazioneException, LibroNumeroCopieException, LibroCampoVuotoException {
        if (titolo == null || titolo.equals(""))
            throw new LibroCampoVuotoException();
        this.titolo = titolo;
        if (autori == null || autori.equals(""))
            throw new LibroCampoVuotoException();
        this.autori = autori;
        if (!isDataPubblicazioneValida(dataPubblicazione))
            throw new LibroDataPubblicazioneException();
        this.dataPubblicazione = dataPubblicazione;
        if (ISBN == null || ISBN.equals(""))
            throw new LibroCampoVuotoException();
        this.ISBN = ISBN;
        if (!isNumCopieValido(copie))
            throw new LibroNumeroCopieException();
        this.copie = copie;
    }

    /**
     * @brief Imposta il titolo del libro
     * @details Verifica che il titolo non sia vuoto prima di impostarlo.
     * @param titolo Il nuovo titolo del libro
     * @throws LibroCampoVuotoException Se il titolo è vuoto
     */
    public void setTitolo(String titolo) throws LibroCampoVuotoException {
        if (titolo == null || titolo.equals(""))
            throw new LibroCampoVuotoException();
        this.titolo = titolo;
    }

    /**
     * @brief Imposta gli autori del libro
     * @details Verifica che gli autori non siano vuoti prima di impostarli.
     * @param autori I nuovi autori del libro
     * @throws LibroCampoVuotoException Se gli autori sono vuoti
     */
    public void setAutori(String autori) throws LibroCampoVuotoException {
        if (autori == null || autori.equals(""))
            throw new LibroCampoVuotoException();
        this.autori = autori;
    }

    /**
     * @brief Imposta la data di pubblicazione del libro
     * @details Verifica che la data di pubblicazione sia valida prima di
     *          impostarla.
     * @param dataPubblicazione La nuova data di pubblicazione del libro
     * @throws LibroDataPubblicazioneException Se la data di pubblicazione non è
     *                                         valida
     */
    public void setDataPubblicazione(LocalDate dataPubblicazione) throws LibroDataPubblicazioneException {
        if (!isDataPubblicazioneValida(dataPubblicazione))
            throw new LibroDataPubblicazioneException();
        this.dataPubblicazione = dataPubblicazione;
    }

    /**
     * @brief Imposta il numero di copie disponibili del libro
     * @details Verifica che il numero di copie sia valido prima di impostarlo.
     * @param copie Il nuovo numero di copie disponibili del libro
     * @throws LibroNumeroCopieException Se il numero di copie non è valido
     */
    public void setCopie(int copie) throws LibroNumeroCopieException {
        if (!isNumCopieValido(copie))
            throw new LibroNumeroCopieException();
        this.copie = copie;
    }

    /**
     * @brief Restituisce il titolo del libro
     * @return Il titolo del libro
     */
    public String getTitolo() {
        return this.titolo;
    }

    /**
     * @brief Restituisce gli autori del libro
     * @return Gli autori del libro
     */
    public String getAutori() {
        return this.autori;
    }

    /**
     * @brief Restituisce la data di pubblicazione del libro
     * @return La data di pubblicazione del libro
     */
    public LocalDate getDataPubblicazione() {
        return this.dataPubblicazione;
    }

    /**
     * @brief Restituisce l'ISBN del libro
     * @return L'ISBN del libro
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * @brief Restituisce il numero di copie disponibili del libro
     * @return Il numero di copie disponibili del libro
     */
    public int getCopie() {
        return this.copie;
    }

    /**
     * @brief Verifica se una data è valida
     * @param daValidare La data da verificare
     * @return true se la data è valida, false altrimenti
     */
    public boolean isDataPubblicazioneValida(LocalDate daValidare) {
        return daValidare != null && !daValidare.isAfter(LocalDate.now());
    }

    /**
     * @brief Verifica se un numero di copie è valido
     * @param daValidare Il numero di copie da verificare
     * @return true se il numero di copie è valido, false altrimenti
     */
    public boolean isNumCopieValido(int daValidare) {
        return daValidare >= 1;
    }

    /**
     * @brief Verifica se una copia del libro è disponibile
     * @return true se una copia è disponibile, false altrimenti
     */
    public boolean isCopiaDisponibile() {
        return this.copie >= 1;
    }

    /**
     * @brief Riduce il numero di copie disponibili del libro di una unità
     */
    public void prendiCopia() {
        copie--;
    }

    /**
     * @brief Aumenta il numero di copie disponibili del libro di una unità
     */
    public void restituisciCopia() {
        copie++;
    }

    /**
     * @brief Confronta due oggetti Libro
     * @param o L'oggetto da confrontare
     * @return true se i due oggetti sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        if (this == o)
            return true;
        Libro libro = (Libro) o;
        return this.ISBN.equals(libro.ISBN);
    }

    /**
     * @brief Restituisce l'hash code dell'oggetto Libro
     * @return L'hash code dell'oggetto Libro
     */
    @Override
    public int hashCode() {
        return this.ISBN.hashCode();
    }

    /**
     * @brief Confronta due oggetti per l'ordinamento
     * @param o L'oggetto da confrontare
     */
    @Override
    public int compareTo(Libro o) {
        return this.titolo.compareTo(o.titolo);
    }

    /**
     * @brief Restituisce una rappresentazione in stringa dell'oggetto Libro
     * @return Una stringa che rappresenta l'oggetto Libro
     */
    @Override
    public String toString() {
        return this.ISBN;
    }

}
