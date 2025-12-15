/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito;

import gestionelibro.Libro;
import gestioneutente.Utente;
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

    /**
     * Test of setUtente method, of class Prestito.
     */
    @Test
    public void testSetUtente() {
        System.out.println("setUtente");
        Utente utente = null;
        Prestito instance = null;
        instance.setUtente(utente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLibro method, of class Prestito.
     */
    @Test
    public void testSetLibro() {
        System.out.println("setLibro");
        Libro libro = null;
        Prestito instance = null;
        instance.setLibro(libro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataScadenza method, of class Prestito.
     */
    @Test
    public void testSetDataScadenza() {
        System.out.println("setDataScadenza");
        LocalDate dataScadenza = null;
        Prestito instance = null;
        instance.setDataScadenza(dataScadenza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtente method, of class Prestito.
     */
    @Test
    public void testGetUtente() {
        System.out.println("getUtente");
        Prestito instance = null;
        Utente expResult = null;
        Utente result = instance.getUtente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibro method, of class Prestito.
     */
    @Test
    public void testGetLibro() {
        System.out.println("getLibro");
        Prestito instance = null;
        Libro expResult = null;
        Libro result = instance.getLibro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataScadenza method, of class Prestito.
     */
    @Test
    public void testGetDataScadenza() {
        System.out.println("getDataScadenza");
        Prestito instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getDataScadenza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDataScadenzaValida method, of class Prestito.
     */
    @Test
    public void testIsDataScadenzaValida() {
        System.out.println("isDataScadenzaValida");
        LocalDate daValidare = null;
        Prestito instance = null;
        boolean expResult = false;
        boolean result = instance.isDataScadenzaValida(daValidare);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinaStato method, of class Prestito.
     */
    @Test
    public void testDeterminaStato() {
        System.out.println("determinaStato");
        Prestito instance = null;
        Stato expResult = null;
        Stato result = instance.determinaStato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Prestito.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Prestito instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Prestito.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Prestito instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Prestito.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Prestito o = null;
        Prestito instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Prestito.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Prestito instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
