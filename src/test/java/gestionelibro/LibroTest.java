/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro;

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
public class LibroTest {
    
    public LibroTest() {
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
     * Test of setTitolo method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testSetTitolo() throws Exception {
        System.out.println("setTitolo");
        String titolo = "";
        Libro instance = null;
        instance.setTitolo(titolo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutori method, of class Libro.
     */
    @Test
    public void testSetAutori() throws Exception {
        System.out.println("setAutori");
        String autori = "";
        Libro instance = null;
        instance.setAutori(autori);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataPubblicazione method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testSetDataPubblicazione() throws Exception {
        System.out.println("setDataPubblicazione");
        LocalDate dataPubblicazione = null;
        Libro instance = null;
        instance.setDataPubblicazione(dataPubblicazione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopie method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testSetCopie() throws Exception {
        System.out.println("setCopie");
        int copie = 0;
        Libro instance = null;
        instance.setCopie(copie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitolo method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testGetTitolo() {
        System.out.println("getTitolo");
        Libro instance = null;
        String expResult = "";
        String result = instance.getTitolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutori method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testGetAutori() {
        System.out.println("getAutori");
        Libro instance = null;
        String expResult = "";
        String result = instance.getAutori();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataPubblicazione method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testGetDataPubblicazione() {
        System.out.println("getDataPubblicazione");
        Libro instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getDataPubblicazione();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testGetISBN() {
        System.out.println("getISBN");
        Libro instance = null;
        String expResult = "";
        String result = instance.getISBN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopie method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testGetCopie() {
        System.out.println("getCopie");
        Libro instance = null;
        int expResult = 0;
        int result = instance.getCopie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDataPubblicazioneValida method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testIsDataPubblicazioneValida() {
        System.out.println("isDataPubblicazioneValida");
        LocalDate daValidare = null;
        Libro instance = null;
        boolean expResult = false;
        boolean result = instance.isDataPubblicazioneValida(daValidare);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumCopieValido method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testIsNumCopieValido() {
        System.out.println("isNumCopieValido");
        int daValidare = 0;
        Libro instance = null;
        boolean expResult = false;
        boolean result = instance.isNumCopieValido(daValidare);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCopiaDisponibile method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testIsCopiaDisponibile() {
        System.out.println("isCopiaDisponibile");
        Libro instance = null;
        boolean expResult = false;
        boolean result = instance.isCopiaDisponibile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prendiCopia method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testPrendiCopia() {
        System.out.println("prendiCopia");
        Libro instance = null;
        instance.prendiCopia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restituisciCopia method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testRestituisciCopia() {
        System.out.println("restituisciCopia");
        Libro instance = null;
        instance.restituisciCopia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Libro instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Libro instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Libro o = null;
        Libro instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Libro.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        System.out.println("toString");
        Libro instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
