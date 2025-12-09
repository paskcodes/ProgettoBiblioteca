package gestioneutente;

import gestionelibro.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;

/**
 * @class Utente
 * @brief Classe che modella un utente del sistema di gestione biblioteca.
 * @details Rappresenta un utente con attributi come nome, cognome, mail, matricola e i libri in prestito.
 */
public class Utente implements Comparable<Utente>, Serializable{
    private String nome;        ///< R2.2
    private String cognome;  ///< R2.2
    private String mail;          ///< R2.3
    private String matricola; ///< R2.4
    private ObservableList<Libro> libriInPrestito;
    private int prestiti = 0;
    
    
    
    /**
     * @brief Costruttore della classe Utente.
     * @param nome Nome dell'utente.
     * @param cognome Cognome dell'utente.
     * @param mail Indirizzo email dell'utente.
     * @param matricola Matricola dell'utente.
     */
    public Utente(String nome, String cognome, String mail, String matricola){
    }
    
    
    
    
    /**
     * @brief Imposta il nome dell'utente.
     * @param nome Nome da impostare.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Imposta il cognome dell'utente.
     * @param cognome Cognome da impostare.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief Imposta l'indirizzo email dell'utente.
     * @param mail Email da impostare.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @brief Imposta la matricola dell'utente.
     * @param matricola Matricola da impostare.
     */
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * @brief Imposta il numero di prestiti dell'utente.
     * @param prestiti Numero di prestiti da impostare.
     */
    public void setPrestiti(int prestiti) {
        this.prestiti = prestiti;
    }
    
    
    
    
    
    
    /**
     * @brief Restituisce il nome dell'utente.
     * @return Nome dell'utente.
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * @brief Restituisce il cognome dell'utente.
     * @return Cognome dell'utente.
     */
    public String getCognome(){
        return this.nome;
    }
    
    /**
     * @brief Restituisce l'indirizzo email dell'utente.
     * @return Email dell'utente.
     */
    public String getMail(){
        return this.nome;
    }

    /**
     * @brief Restituisce la matricola dell'utente.
     * @return Matricola dell'utente.
     */
    public String getMatricola(){
        return this.nome;
    }
    
    /**
     * @brief Restituisce il numero di prestiti dell'utente.
     * @return Numero di prestiti dell'utente.
     */
    public int getNumPrestiti(){
        return this.prestiti;
    }

    
    //statiche per rendere le verifiche utilizzabili ovunque
    
    /**
     * @brief Verifica se il nome o cognome sono validi.
     * @param daValidare Stringa da validare.
     * @return true se validi, false altrimenti.
     */
    public static boolean isNomeCognomeValido(String daValidare){
        return true;
    }
    
    /**
     * @brief Verifica se l'email è valida.
     * @param daValidare Email da validare.
     * @return true se valida, false altrimenti.
     */
    public static boolean isMailValida(String daValidare){
        return true;
    }
    
    /**
     * @brief Verifica se la matricola è valida.
     * @param daValidare Matricola da validare.
     * @return true se valida, false altrimenti.
     */
    public static boolean isMatricolaValida(String daValidare){
        return true;
    }
    
    
    
    /**
     * @brief Verifica se l'utente ha raggiunto il limite di prestiti.
     * @return true se ha raggiunto il limite, false altrimenti.
     */
    public boolean isLimitePrestitiRaggiunto(){
        return true;
    }
    
    
    
    
    
    /**
     * @brief  Verifica se due utenti sono uguali.
     * @param o Oggetto da confrontare.
     * @return true se uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o){
        return true;
    }
    
    /**
     * @brief Restituisce il codice hash dell'utente.
     * @return Codice hash.
     */
    @Override
    public int hashCode(){
        return 0;
    }
    
    /**
     * @brief Confronta due utenti per il cognome.
     * @param o Utente da confrontare.
     * @return Valore di confronto.
     */
    @Override
    public int compareTo(Utente o) {
        if(cognome.compareTo(o.cognome) == 0) return nome.compareTo(o.nome);
        return cognome.compareTo(o.cognome);
    }
    
    /**
     * @brief Restituisce una rappresentazione testuale dell'utente.
     * @return Rappresentazione testuale.
     */
    @Override
    public String toString(){
        return "UTENTE";
    }
    
    
}
