package gestioneutente;


import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroInvalidoException;
import gestioneutente.eccezioni.UtenteInvalidoException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setNome("");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setNome("123");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setNome("mario gerardo");
            assertTrue(u1.getNome().equals("mario gerardo"));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setNome(" ");
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
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setCognome("");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setCognome("123");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setCognome("lionti lorito");
            assertTrue(u1.getCognome().equals("lionti lorito"));
        } catch (UtenteInvalidoException ex) {
        }

        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setCognome(" ");
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
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setMail("");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setMail(" ");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            u1.setMail("123@studenti.unisa.it");
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
            List<Libro> lista = new ArrayList<>();
            lista.add(l1);
            u1.prendiCopia(l1);
            assertTrue(u1.getLibriInPrestito().equals(lista));
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
        
        try{
            Utente u1 = new Utente("antonio", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.getNome().equals("antonio"));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u1 = new Utente("123", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u1 = new Utente("mario gerardo", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.getNome().equals("mario gerardo"));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente(" ", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
    }
    
    @Test
    public void testIsMailValida() {
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi1@studenti.unisa.it", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", " ", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "123@studenti.unisa.it", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "@studenti.unisa.it", "123456");
        } catch (UtenteInvalidoException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    private void testIsMatricolaValida(String daValidare) {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.getMatricola(), "123456");
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", " ");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "dfewdfs][?><,.");
        }catch(UtenteInvalidoException ex){
            assertTrue(true);
        }
        
    }

    @Test
    public void testIsLimitePrestitiRaggiunto() {
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            u1.prendiCopia(l1);
            u1.prendiCopia(l1);
            u1.prendiCopia(l1);
            assertTrue(u1.isLimitePrestitiRaggiunto());
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
        
        try {
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            u1.prendiCopia(l1);
            assertFalse(u1.isLimitePrestitiRaggiunto());
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
    }
    
    @Test
    public void testPrendiCopia() {

        try {
        Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
        Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
        u1.prendiCopia(l1);
        assertTrue(u1.getLibriInPrestito().contains(l1));
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
        
        try {
         Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
         Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
         u1.prendiCopia(l1);
         u1.prendiCopia(l1);
         u1.prendiCopia(l1);
         assertEquals(u1.getLibriInPrestito().size(), 3);
         assertTrue(u1.isLimitePrestitiRaggiunto());
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
        
    }

    @Test
    public void testRestituisciCopia() {
        //libriInPrestito.remove(copia);
        //prestitiAttivi--;
        
        try {
        Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
        Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
        u1.prendiCopia(l1);
        u1.restituisciCopia(l1);
        assertFalse(u1.getLibriInPrestito().contains(l1));
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
        
        try {
         Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
         Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
         u1.prendiCopia(l1);
         u1.prendiCopia(l1);
         u1.prendiCopia(l1);
         u1.restituisciCopia(l1);
         assertEquals(u1.getLibriInPrestito().size(), 2);
         assertFalse(u1.isLimitePrestitiRaggiunto());
        } catch (UtenteInvalidoException | LibroInvalidoException ex) {
        }
        
    }

    @Test
    public void testEquals() {
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertFalse(u1.equals(null));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            assertFalse(u1.equals(l1));
        }catch(UtenteInvalidoException | LibroInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.equals(u1));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Lorenzo", "Malesani", "cabrizio@studenti.unisa.it", "123456");
            assertTrue(u1.equals(u2));
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "789456");
            assertFalse(u1.equals(u2));
        }catch(UtenteInvalidoException ex){
        }


    }

    @Test
    public void testHashCode() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.equals(u2));
            assertEquals(u1.hashCode(), u2.hashCode());
        }catch(UtenteInvalidoException ex){
        }

        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Luigi", "Bianchi", "luigi.bianchi@studenti.unisa.it", "654321");
            assertFalse(u1.equals(u2));
            assertTrue(u1.hashCode() != u2.hashCode());
        }catch(UtenteInvalidoException ex){
        }
    }

    @Test
    public void testCompareTo() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            assertEquals(u1.compareTo(u2), 0);
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "asd@studenti.unisa.it", "3453452");
            Utente u2 = new Utente("Mario", "Rossi", "fre@studenti.unisa.it", "2363464");
            assertEquals(u1.compareTo(u2), 0);
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Mario", "Rossini", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u2.compareTo(u1) > 0);
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Mario", "Sossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u2.compareTo(u1) > 0);
        }catch(UtenteInvalidoException ex){
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Mario", "Sossi", "mario.rossi@studenti.unisa.it", "123456");
            assertTrue(u1.compareTo(u2) < 0);
        }catch(UtenteInvalidoException ex){
        }
        
    }

    @Test
    public void testToString() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            String matricola1 = "123456";
            String matricola2 = u1.toString();
            assertTrue(matricola1.equals(matricola2));
        }catch(UtenteInvalidoException ex){
        }
    }
}
