/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro;

import gestionelibro.eccezioni.LibroDataPubblicazioneException;
import gestionelibro.eccezioni.LibroNumeroCopieException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @class Libro
 * @brief Implementa un libro con i suoi attributi principali
 * @details La classe Libro implementa un libro con i suoi attributi principali come titolo, autori, data di pubblicazione, ISBN e numero di copie disponibili.
 *          Fornisce metodi per accedere e modificare questi attributi, confrontare libri e per verificare la disponibilità delle copie.
 */
public class Libro implements Comparable<Libro>, Serializable{
    private String titolo;
    private String autori;
    private LocalDate dataPubblicazione;
    private final String ISBN;
    private int copie;
    private int prestitiAttivi = 0;
    
    /**
     * @brief Costruttore della classe Libro
     * @param titolo Il titolo del libro
     * @param autori Gli autori del libro
     * @param dataPubblicazione La data di pubblicazione del libro
     * @param ISBN L'ISBN del libro
     * @param copie Il numero di copie disponibili del libro
     */
    public Libro(String titolo, String autori, LocalDate dataPubblicazione, String ISBN, int copie){
        this.titolo = titolo;
        this.autori = autori;
        this.dataPubblicazione = dataPubblicazione;
        this.ISBN = ISBN;
        this.copie = copie;
    }

    /**
     * @brief Imposta il titolo del libro
     * @param titolo Il nuovo titolo del libro
     */
    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    /**
     * @brief Imposta gli autori del libro
     * @param autori I nuovi autori del libro
     */
    public void setAutori(String autori) {
        this.autori = autori;
    }

    /**
     * @brief Imposta la data di pubblicazione del libro
     * @param dataPubblicazione La nuova data di pubblicazione del libro
     */
    public void setDataPubblicazione(LocalDate dataPubblicazione) throws LibroDataPubblicazioneException{
        this.dataPubblicazione = dataPubblicazione;
    }

    /**
     * @brief Imposta il numero di copie disponibili del libro
     * @param copie Il nuovo numero di copie disponibili del libro
     */
    public void setCopie(int copie) throws LibroNumeroCopieException{
        this.copie = copie;
    }
    
    public void setNumPrestitiAttivi(int prestitiAttivi){
        
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
    
    public int getNumPrestitiAttivi(){
        return 1;
    }
    
    
    //statiche per rendere le verifiche utilizzabili ovunque
    
    /**
     * @brief Verifica se una data è valida
     * @param daValidare La data da verificare
     * @return true se la data è valida, false altrimenti
     */
    public static boolean isDataPubblicazioneValida(LocalDate daValidare){
        return true;
    }
    
    /**
     * @brief Verifica se un numero di copie è valido
     * @param daValidare Il numero di copie da verificare
     * @return true se il numero di copie è valido, false altrimenti
     */
    public static boolean isNumCopieValido(int daValidare){
            return true;
    }
    
    /**
     * @brief Verifica se una copia del libro è disponibile
     * @return true se una copia è disponibile, false altrimenti
     */
    public boolean isCopiaDisponibile(){
        return true;
    }

    /**
     * @brief Confronta due oggetti Libro
     * @param o L'oggetto da confrontare
     * @return true se i due oggetti sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object o){
        return true;
    }
    
    /**
     * @brief Restituisce l'hash code dell'oggetto Libro
     * @return L'hash code dell'oggetto Libro
     */
    @Override
    public int hashCode(){
        return 0;
    }
    
    /**
     * @brief Confronta due oggetti per l'ordinamento
     * @param o L'oggetto da confrontare
     */
    @Override
    public int compareTo(Libro o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @brief Restituisce una rappresentazione in stringa dell'oggetto Libro
     * @return Una stringa che rappresenta l'oggetto Libro
     */
    @Override
    public String toString(){
        return "LIBRO";
    }

    
    
}
