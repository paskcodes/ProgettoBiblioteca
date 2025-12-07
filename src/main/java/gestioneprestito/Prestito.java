/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito;

import java.io.Serializable;
import gestionelibro.Libro;
import gestioneutente.Utente;
import java.time.LocalDate;

/**
 *
 * @author Antonio Franco
 * 
 */
public class Prestito implements Comparable, Serializable{
    private String utente;
    private String libro;
    private LocalDate dataScadenza;
    private Stato stato;
    
    public Prestito(String utente, String libro, LocalDate dataScadenza){
        this.utente = utente;
        this.libro = libro;
        this.dataScadenza = dataScadenza;
    }

    
    
    public void setUtente(String utente) {
        this.utente = utente;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    
    
    
    
    
    public String getUtente() {
        return this.utente;
    }

    public String getLibro() {
        return this.libro;
    }

    public LocalDate getDataScadenza() {
        return this.dataScadenza;
    }
    
    public Stato getStato(){
        return this.stato;
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
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return "PRESTITO";
    }
    

    
}
