package gestioneutente;


import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroInvalidoException;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package gestioneutente;

import gestionelibro.Libro;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Antonio Franco
 */


public class UtenteTest {
    
    Utente instance1;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testUtente(){
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.getNome(), "Mario");
            assertEquals(u1.getCognome(), "Rossi");
            assertEquals(u1.getMail(), "mario.rossi@studenti.unisa.it");
            assertEquals(u1.getMatricola(), "123456");
        }catch(UtenteInvalidoException ex){
            
        }
        
    }
    
    
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setNome("antonio");
            assertTrue(u1.getNome().equals("antonio"));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u2 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u2.setNome("");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u3 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u3.setNome("123");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u4 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u4.setNome("mario gerardo");
            assertTrue(u4.getNome().equals("mario gerardo"));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u5 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u5.setNome(" ");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
    }
        
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setCognome("franco");
            assertTrue(u1.getCognome().equals("franco"));
        } catch (UtenteInvalidoException ex) {
        }

        try {
            Utente u2 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u2.setCognome("");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Utente u3 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u3.setCognome("123");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Utente u4 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u4.setCognome("lionti lorito");
            assertTrue(u4.getCognome().equals("lionti lorito"));
        } catch (UtenteInvalidoException ex) {
        }

        try {
            Utente u5 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u5.setCognome(" ");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }

    }
    
    @Test
    public void testSetMail(){
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setMail("mario.rossi1@studenti.unisa.it");
            assertFalse(u1.getCognome().equals("mario.rossi@studenti.unisa.it"));
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u2 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u2.setMail("");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u3 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u3.setMail(" ");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u4 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u4.setMail("123@studenti.unisa.it");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
    
    }
    
     @Test
    public void testGetNome() {
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.getNome(), "Mario");
        } catch (UtenteInvalidoException ex) {
        }
        
    }
    
    @Test
    public void testGetCognome() {
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.getCognome(), "Rossi");
        } catch (UtenteInvalidoException ex) {
        }
        
    }
    
    @Test
    public void testGetMatricola() {
  
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.getMatricola(), "123456");
        } catch (UtenteInvalidoException ex) {
        }
    }
        
    @Test
    public void testGetLibriInPrestito(){
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            u1.prendiCopia(l1);
            assertTrue(u1.getLibriInPrestito().contains(l1));
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
    }
    
    @Test
    public void getNumPrestitiAttivi(){
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.getNumPrestitiAttivi(), 0);
        } catch (UtenteInvalidoException ex) {
        }
        
    }
    
    @Test
    public void testIsNomeCognomeValido(){
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.isNomeCognomeValido("Mario"));
            assertFalse(u1.isNomeCognomeValido("2342342342523"));
            assertFalse(u1.isNomeCognomeValido("}{{}][][][]"));
        } catch (UtenteInvalidoException ex) {
            
        }
        
    }
    
    @Test
    public void testIsMailValida() {
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.isMailValida("mario.rossi@studenti.unisa.it"));
        } catch (UtenteInvalidoException ex) {
        }
        
        try {
            Utente u2 = new Utente("Mario", "Rossi", "[][]]][@studenti.unisa.it", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u3 = new Utente("Mario", "Rossi", "123@studenti.unisa.it", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
    }
    /**
     * Test of setCognome method, of class Utente.
     */

}
