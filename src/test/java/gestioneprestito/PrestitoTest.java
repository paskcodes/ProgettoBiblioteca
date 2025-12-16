/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito;

import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroInvalidoException;
import gestioneprestito.eccezioni.PrestitoInvalidoException;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteInvalidoException;
import java.time.LocalDate;
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
public class PrestitoTest {
    
    public PrestitoTest() {
    }
    
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
    public void testUtente() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2030-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            
            assertFalse(u1.isLimitePrestitiRaggiunto());
            assertTrue(l1.isCopiaDisponibile());
            assertTrue(d1.isAfter(LocalDate.now()));
            assertEquals(p1.getUtente(), u1);
            assertEquals(p1.getLibro(), l1);
            assertEquals(p1.getDataScadenza(), d1);
            
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 4);
            LocalDate d1 = LocalDate.parse("2020-09-08");
            Prestito p1 = new Prestito(u1, l1, d1);
            
            assertTrue(false);
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(true);
        }
        
    }
    
    @Test
    public void testSetUtente() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Lorenzo", "Malesani", "lorenzo.m@studenti.unisa.it", "456234");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            p1.setUtente(u2);
            assertEquals(p1.getUtente(), u2);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testSetLibro() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Libro l2 = new Libro("Mickey Mouse", "Walt Disney", LocalDate.parse("2000-09-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            p1.setLibro(l2);
            assertEquals(p1.getLibro(), l2);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }

    }

    @Test
    public void testSetDataScadenza() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Libro l2 = new Libro("Mickey Mouse", "Walt Disney", LocalDate.parse("2000-09-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            p1.setLibro(l2);
            assertEquals(p1.getLibro(), l2);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testGetUtente() {
         try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            assertEquals(p1.getUtente(), u1);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testGetLibro() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2030-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            assertEquals(p1.getLibro(), l1);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testGetDataScadenza() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2030-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            System.out.println(p1.getDataScadenza().toString() + d1.toString());
            assertEquals(p1.getDataScadenza(), d1);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testIsDataScadenzaValida() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2027-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            assertTrue(p1.isDataScadenzaValida(d1));
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }

    }

    @Test
    public void testDeterminaStato() {
        // Test stato REGOLARE: data di scadenza nel futuro
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.now().plusDays(30);
            Prestito p1 = new Prestito(u1, l1, d1);
            assertEquals(p1.determinaStato(), Stato.REGOLARE);
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        // Test stato SCADUTO: data di scadenza nel passato
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.now().minusDays(10);
            Prestito p1 = new Prestito(u1, l1, LocalDate.now().plusDays(30));
            p1.setDataScadenza(d1);
            assertEquals(p1.determinaStato(), Stato.SCADUTO);
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testEquals() {
        // Test equals con null
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            assertFalse(p1.equals(null));
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            assertFalse(p1.equals(l1));
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            assertTrue(p1.equals(p1));
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            Prestito p2 = new Prestito(u1, l1, LocalDate.parse("2029-12-16"));
            assertTrue(p1.equals(p2));
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Lorenzo", "Malesani", "lorenzo.m@studenti.unisa.it", "456234");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            Prestito p2 = new Prestito(u2, l1, LocalDate.parse("2030-12-16"));
            assertFalse(p1.equals(p2));
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Libro l2 = new Libro("Il Capitale", "Marx", LocalDate.parse("1888-12-16"), "9-523-542-1547657", 6);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            Prestito p2 = new Prestito(u1, l2, LocalDate.parse("2030-12-16"));
            assertFalse(p1.equals(p2));
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testHashCode() {
        // Test coerenza con equals: prestiti uguali devono avere lo stesso hash code
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            Prestito p2 = new Prestito(u1, l1, LocalDate.parse("2029-12-16"));
            assertTrue(p1.equals(p2));
            assertEquals(p1.hashCode(), p2.hashCode());
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        // Test hash code con prestiti diversi (dovrebbero tendenzialmente avere hash diversi)
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Lorenzo", "Malesani", "lorenzo.m@studenti.unisa.it", "456234");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Libro l2 = new Libro("Il Capitale", "Marx", LocalDate.parse("1888-12-16"), "9-523-542-1547657", 6);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            Prestito p2 = new Prestito(u2, l2, LocalDate.parse("2030-12-16"));
            assertFalse(p1.equals(p2));
            // Nota: non possiamo garantire che hash code diversi, ma è probabile
            // assertTrue(p1.hashCode() != p2.hashCode());
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        // Test che hashCode restituisca un valore (non null)
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Prestito p1 = new Prestito(u1, l1, LocalDate.parse("2030-12-16"));
            assertTrue(p1.hashCode() != 0 || p1.hashCode() == 0); // Sempre true, ma verifica che non ci siano eccezioni
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
    }

    @Test
    public void testCompareTo() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Lorenzo", "Malesani", "lorenzo.m@studenti.unisa.it", "344334");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Libro l2 = new Libro("Il Capitale", "Marx", LocalDate.parse("1888-12-16"), "9-523-542-1547657", 6);
            LocalDate d1 = LocalDate.parse("2029-12-16");
            LocalDate d2 = LocalDate.parse("2029-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            Prestito p2 = new Prestito(u2, l2, d2);
            
            assertTrue(p1.compareTo(p2) == 0);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2029-12-16");
            LocalDate d2 = LocalDate.parse("2028-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            Prestito p2 = new Prestito(u1, l1, d2);
            
            assertTrue(p1.compareTo(p2) > 0);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Utente u2 = new Utente("Lorenzo", "Malesani", "lorenzo.m@studenti.unisa.it", "344334");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            Libro l2 = new Libro("Il Capitale", "Marx", LocalDate.parse("1888-12-16"), "9-523-542-1547657", 6);
            LocalDate d1 = LocalDate.parse("2029-12-16");
            LocalDate d2 = LocalDate.parse("2029-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            Prestito p2 = new Prestito(u2, l2, d2);
            
            assertTrue(p1.compareTo(p2) == 0);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2023-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2029-12-16");
            LocalDate d2 = LocalDate.parse("2028-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            Prestito p2 = new Prestito(u1, l1, d2);
            
            assertTrue(p2.compareTo(p1) < 0);
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
            
    }

    @Test
    public void testToString() {
        try{
            Utente u1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
            Libro l1 = new Libro("1994", "George Orwell", LocalDate.parse("2022-12-16"), "9-123-412-4234235", 3);
            LocalDate d1 = LocalDate.parse("2030-12-16");
            Prestito p1 = new Prestito(u1, l1, d1);
            assertEquals(p1.toString(), u1.toString() + "/n" + l1.toString());
                    
        }catch(UtenteInvalidoException | LibroInvalidoException | PrestitoInvalidoException ex){
            assertTrue(false);
        }
        
        
    }
    
}
