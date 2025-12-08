/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Antonio Franco
 * 
 */
public class Libro implements Comparable, Serializable{
    private String titolo;
    private String autori;
    private LocalDate dataPubblicazione;
    private final String ISBN;
    private int copie;
    
    
    
    
    
    public Libro(String titolo, String autori, LocalDate dataPubblicazione, String ISBN, int copie){
        this.titolo = titolo;
        this.autori = autori;
        this.dataPubblicazione = dataPubblicazione;
        this.ISBN = ISBN;
        this.copie = copie;
    }

    
    
    
    
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public void setCopie(int copie) {
        this.copie = copie;
    }

    
    
    
    public String getTitolo() {
        return this.titolo;
    }

    public String getAutori() {
        return this.autori;
    }

    public LocalDate getDataPubblicazione() {
        return this.dataPubblicazione;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public int getCopie() {
        return this.copie;
    }
    
    
    //statiche per rendere le verifiche utilizzabili ovunque
    
    public static boolean isDataValida(LocalDate daValidare){
        return true;
    }
    
    public static boolean isNumCopieValido(int daValidare){
            return true;
    }
    
    
   
    

    
    
    
    
    public boolean isCopiaDisponibile(){
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
        public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return "LIBRO";
    }

    
    
}
