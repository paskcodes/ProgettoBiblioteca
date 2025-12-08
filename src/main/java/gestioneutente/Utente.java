/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente;

import gestionelibro.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Franco
 * 
 */
public class Utente implements Comparable<Utente>, Serializable{
    private String nome;        ///< R2.2
    private String cognome;  ///< R2.2
    private String mail;          ///< R2.3
    private String matricola; ///< R2.4
    private ObservableList<Libro> libriInPrestito;
    private int prestiti = 0;
    
    
    
    
    public Utente(String nome, String cognome, String mail, String matricola){
    }
    
    
    
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setPrestiti(int prestiti) {
        this.prestiti = prestiti;
    }
    
    
    
    
    
    
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.nome;
    }
    
    public String getMail(){
        return this.nome;
    }
    
    public String getMatricola(){
        return this.nome;
    }
    
    public int getNumPrestiti(){
        return this.prestiti;
    }

    
    //statiche per rendere le verifiche utilizzabili ovunque
    
    public static boolean isNomeCognomeValido(String daValidare){
        return true;
    }
    
    public static boolean isMailValida(String daValidare){
        return true;
    }
    
    public static boolean isMatricolaValida(String daValidare){
        return true;
    }
    
    
    
    
    public boolean isLimitePrestitiRaggiunto(){
        return true;
    }
    
    
    
    
    

    @Override
    public boolean equals(Object o){
        return true;
    }
    
    @Override
    public int hashCode(){
        return 0;
    }
    
    @Override
    public int compareTo(Utente o) {
        if(cognome.compareTo(o.cognome) == 0) return nome.compareTo(o.nome);
        return cognome.compareTo(o.cognome);
    }
    
    @Override
    public String toString(){
        return "UTENTE";
    }
    
    
}
