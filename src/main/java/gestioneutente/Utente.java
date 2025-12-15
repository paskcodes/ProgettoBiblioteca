package gestioneutente;

import gestionelibro.Libro;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.eccezioni.UtenteMailException;
import gestioneutente.eccezioni.UtenteMatricolaException;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;

/**
 * @class Utente
 * @brief Classe che modella un utente del sistema di gestione biblioteca.
 * @details Rappresenta un utente con attributi come nome, cognome, mail,
 *          matricola e i libri in prestito.
 */
public class Utente implements Comparable<Utente>, Serializable {
    private String nome; /// < R2.2
    private String cognome; /// < R2.2
    private String mail; /// < R2.3
    private String matricola; /// < R2.4
    private List<Libro> libriInPrestito = new ArrayList<>();
    private int prestitiAttivi = 0;

    /**
     * @brief Costruttore della classe Utente.
     * @param nome      Nome dell'utente.
     * @param cognome   Cognome dell'utente.
     * @param mail      Indirizzo email dell'utente.
     * @param matricola Matricola dell'utente.
     */
    public Utente(String nome, String cognome, String mail, String matricola) throws UtenteNomeCognomeException, UtenteMailException , UtenteMatricolaException{
        if(!isNomeCognomeValido(nome)) throw  new UtenteNomeCognomeException();
            this.nome = nome;
        if(!isNomeCognomeValido(cognome)) throw  new UtenteNomeCognomeException("Cognome vuoto o non valido!");
            this.cognome = cognome;
        if(!isMailValida(mail)) throw  new UtenteMailException();
            this.mail = mail;
        if(!isMatricolaValida(matricola)) throw new UtenteMatricolaException();
            this.matricola = matricola;

    }

    /**
     * @brief Imposta il nome dell'utente.
     * @param nome Nome da impostare.
     */
    public void setNome(String nome) throws UtenteNomeCognomeException{
        if (!isNomeCognomeValido(nome)) {
            throw new UtenteNomeCognomeException();
        }
        this.nome = nome;
    }

    /**
     * @brief Imposta il cognome dell'utente.
     * @param cognome Cognome da impostare.
     */
    public void setCognome(String cognome) throws UtenteNomeCognomeException{
        if (!isNomeCognomeValido(cognome)) {
            throw new UtenteNomeCognomeException("Cognome vuoto o non valido!");
        }
        this.cognome = cognome;
    }

    /**
     * @brief Imposta l'indirizzo email dell'utente.
     * @param mail Email da impostare.
     */
    public void setMail(String mail) throws UtenteMailException{
        if (!isMailValida(mail)) {
            throw new UtenteMailException();
        }
        this.mail = mail;
    }

    public void setLibriInPrestito(ArrayList<Libro> libriInPrestito) {
        this.libriInPrestito = libriInPrestito;
    }

    public void setNumPrestitiAttivi(int prestitiAttivi) {
        this.prestitiAttivi = prestitiAttivi;
    }

    /**
     * @brief Restituisce il nome dell'utente.
     * @return Nome dell'utente.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @brief Restituisce il cognome dell'utente.
     * @return Cognome dell'utente.
     */
    public String getCognome() {
        return this.cognome;
    }

    /**
     * @brief Restituisce l'indirizzo email dell'utente.
     * @return Email dell'utente.
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * @brief Restituisce la matricola dell'utente.
     * @return Matricola dell'utente.
     */
    public String getMatricola() {
        return this.matricola;
    }

    /**
     * @brief Restituisce dei libri in prestito dell'utente.
     * @return Libri in prestito dell'utente.
     */
    public List<Libro> getLibriInPrestito() {
        return this.libriInPrestito;
    }

    /**
     * @brief Restituisce il numero di prestiti dell'utente.
     * @return Numero di prestiti dell'utente.
     */
    public int getNumPrestitiAttivi() {
        return this.prestitiAttivi;
    }

    // statiche per rendere le verifiche utilizzabili ovunque

    /**
     * @brief Verifica se il nome o cognome sono validi.
     * @param daValidare Stringa da validare.
     * @return true se validi, false altrimenti.
     */
    public boolean isNomeCognomeValido(String daValidare) {
        return (daValidare != null && Pattern.matches("^[a-zA-Z][a-zA-Z\\s]*$", daValidare));
    }

    /**
     * @brief Verifica se l'email è valida.
     * @param daValidare Email da validare.
     * @return true se valida, false altrimenti.
     */
    public boolean isMailValida(String daValidare) {
        return (daValidare != null && Pattern.matches("^[a-zA-Z0-9.]+@studenti\\.unisa\\.it$", daValidare));
    }

    /**
     * @brief Verifica se la matricola è valida.
     * @param daValidare Matricola da validare.
     * @return true se valida, false altrimenti.
     */
    public boolean isMatricolaValida(String daValidare) {
        return (daValidare != null && Pattern.matches("[0-9]+", daValidare));
    }

    /**
     * @brief Verifica se l'utente ha raggiunto il limite di prestiti.
     * @return true se ha raggiunto il limite, false altrimenti.
     */
    public boolean isLimitePrestitiRaggiunto() {
        return prestitiAttivi == 3;
    }

    public void prendiCopia(Libro copia) {
        libriInPrestito.add(copia);
        prestitiAttivi++;
    }

    public void restituisciCopia(Libro copia) {
        libriInPrestito.remove(copia);
        prestitiAttivi--;
    }

    /**
     * @brief Verifica se due utenti sono uguali.
     * @param o Oggetto da confrontare.
     * @return true se uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null && this.getClass() != o.getClass()) return false;
        if (this == o) return true;
        Utente utente = (Utente) o;
        return this.matricola.equals(utente.matricola);
    }

    /**
     * @brief Restituisce il codice hash dell'utente.
     * @return Codice hash.
     */
    @Override
    public int hashCode() {
        return matricola.hashCode();
    }

    /**
     * @brief Confronta due utenti per il cognome.
     * @param o Utente da confrontare.
     * @return Valore di confronto.
     */
    @Override
    public int compareTo(Utente o) {
        if (this.cognome.equals(o.cognome)) return nome.compareTo(o.nome);
        return cognome.compareTo(o.cognome);
    }

    /**
     * @brief Restituisce una rappresentazione testuale dell'utente.
     * @return Rappresentazione testuale.
     */
    @Override
    public String toString() {
        return this.nome.toString() + this.cognome.toString() + "/n" + this.matricola.toString();
    }

}
