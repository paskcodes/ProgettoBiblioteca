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

/*
public class UtenteTest {
    
    Utente instance1;
    
    @BeforeAll
    public static void setUpClass() {
        try{
            Utente instance1 = new Utente("Mario", "Rossi", "mario.rossi@studenti.unisa.it", "123456");
        }catch(UtenteInvalidoException ex){
            System.out.println("SONO QUI");
        }
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
    public void testSetNome() {
        System.out.println("setNome");
        
        // Test 1: Nome valido - solo lettere
        String nomeValido1 = "1";
        //assertThrows(Exception.class, () -> instance1.setNome(nomeValido1));
        try{
            
        }catch(){
            
        }
        
        //assertEquals(nomeValido1, instance1.getNome(), "Il nome valido con solo lettere dovrebbe essere impostato correttamente");
        
        
        // Test 2: Nome valido - lettere e spazi
        Utente instance2 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeValido2 = "Maria Anna";
        instance2.setNome(nomeValido2);
        assertEquals(nomeValido2, instance2.getNome(), "Il nome valido con lettere e spazi dovrebbe essere impostato correttamente");
        
        // Test 3: Nome valido - con accenti
        Utente instance3 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeValido3 = "José";
        instance3.setNome(nomeValido3);
        assertEquals(nomeValido3, instance3.getNome(), "Il nome valido con accenti dovrebbe essere impostato correttamente");
        
        // Test 4: Nome nullo - dovrebbe lanciare UtenteNomeCognomeException
        Utente instance4 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeNullo = null;
        assertThrows(UtenteNomeCognomeException.class, () -> {
            instance4.setNome(nomeNullo);
        }, "Il nome nullo dovrebbe lanciare UtenteNomeCognomeException");
        
        // Test 5: Nome vuoto - dovrebbe lanciare UtenteNomeCognomeException
        Utente instance5 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeVuoto = "";
        assertThrows(UtenteNomeCognomeException.class, () -> {
            instance5.setNome(nomeVuoto);
        }, "Il nome vuoto dovrebbe lanciare UtenteNomeCognomeException");
        
        // Test 6: Nome con solo spazi - dovrebbe lanciare UtenteNomeCognomeException
        Utente instance6 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeSoloSpazi = "   ";
        assertThrows(UtenteNomeCognomeException.class, () -> {
            instance6.setNome(nomeSoloSpazi);
        }, "Il nome con solo spazi dovrebbe lanciare UtenteNomeCognomeException");
        
        // Test 7: Nome con numeri - dovrebbe lanciare UtenteNomeCognomeException
        Utente instance7 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeConNumeri = "Mario123";
        assertThrows(UtenteNomeCognomeException.class, () -> {
            instance7.setNome(nomeConNumeri);
        }, "Il nome con numeri dovrebbe lanciare UtenteNomeCognomeException");
        
        // Test 8: Nome con caratteri speciali - dovrebbe lanciare UtenteNomeCognomeException
        Utente instance8 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeConCaratteriSpeciali = "Mario@Rossi";
        assertThrows(UtenteNomeCognomeException.class, () -> {
            instance8.setNome(nomeConCaratteriSpeciali);
        }, "Il nome con caratteri speciali dovrebbe lanciare UtenteNomeCognomeException");
        
        // Test 9: Nome con punteggiatura - dovrebbe lanciare UtenteNomeCognomeException
        Utente instance9 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeConPunteggiatura = "Mario.Rossi";
        assertThrows(UtenteNomeCognomeException.class, () -> {
            instance9.setNome(nomeConPunteggiatura);
        }, "Il nome con punteggiatura dovrebbe lanciare UtenteNomeCognomeException");
        
        // Test 10: Nome valido con maiuscole e minuscole
        Utente instance10 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeMisto = "MarIO";
        instance10.setNome(nomeMisto);
        assertEquals(nomeMisto, instance10.getNome(), "Il nome con maiuscole e minuscole dovrebbe essere impostato correttamente");
        
        // Test 11: Nome valido molto lungo
        Utente instance11 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeLungo = "Maria Giovanna";
        instance11.setNome(nomeLungo);
        assertEquals(nomeLungo, instance11.getNome(), "Il nome lungo valido dovrebbe essere impostato correttamente");
        
        // Test 12: Verifica che il nome originale non venga modificato se viene lanciata un'eccezione
        Utente instance12 = new Utente("Mario", "Rossi", "mario.rossi@email.com", "123456");
        String nomeOriginale = instance12.getNome();
        String nomeInvalido = "Mario123";
        try {
            instance12.setNome(nomeInvalido);
            fail("Avrebbe dovuto lanciare un'eccezione per nome invalido");
        } catch (UtenteNomeCognomeException e) {
            assertEquals(nomeOriginale, instance12.getNome(), "Il nome originale non dovrebbe essere modificato se viene lanciata un'eccezione");
        }
        
    }
    */
    /**
     * Test of setCognome method, of class Utente.
     */
    
    /*
    @Test
    public void testSetCognome() throws Exception {
        System.out.println("setCognome");
        String cognome = "";
        Utente instance = null;
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testSetMail() throws Exception {
        System.out.println("setMail");
        String mail = "";
        Utente instance = null;
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLibriInPrestito() {
        System.out.println("setLibriInPrestito");
        ArrayList<Libro> libriInPrestito = null;
        Utente instance = null;
        instance.setLibriInPrestito(libriInPrestito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNumPrestitiAttivi() {
        System.out.println("setNumPrestitiAttivi");
        int prestitiAttivi = 0;
        Utente instance = null;
        instance.setNumPrestitiAttivi(prestitiAttivi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Utente instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Utente instance = null;
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMail() {
        System.out.println("getMail");
        Utente instance = null;
        String expResult = "";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMatricola() {
        System.out.println("getMatricola");
        Utente instance = null;
        String expResult = "";
        String result = instance.getMatricola();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLibriInPrestito() {
        System.out.println("getLibriInPrestito");
        Utente instance = null;
        List<Libro> expResult = null;
        List<Libro> result = instance.getLibriInPrestito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNumPrestitiAttivi() {
        System.out.println("getNumPrestitiAttivi");
        Utente instance = null;
        int expResult = 0;
        int result = instance.getNumPrestitiAttivi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsNomeCognomeValido() {
        System.out.println("isNomeCognomeValido");
        String daValidare = "";
        Utente instance = null;
        boolean expResult = false;
        boolean result = instance.isNomeCognomeValido(daValidare);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testIsMailValida() {
        System.out.println("isMailValida");
        String daValidare = "";
        Utente instance = null;
        boolean expResult = false;
        boolean result = instance.isMailValida(daValidare);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsMatricolaValida() {
        System.out.println("isMatricolaValida");
        String daValidare = "";
        Utente instance = null;
        boolean expResult = false;
        boolean result = instance.isMatricolaValida(daValidare);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testIsLimitePrestitiRaggiunto() {
        System.out.println("isLimitePrestitiRaggiunto");
        Utente instance = null;
        boolean expResult = false;
        boolean result = instance.isLimitePrestitiRaggiunto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testPrendiCopia() {
        System.out.println("prendiCopia");
        Libro copia = null;
        Utente instance = null;
        instance.prendiCopia(copia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRestituisciCopia() {
        System.out.println("restituisciCopia");
        Libro copia = null;
        Utente instance = null;
        instance.restituisciCopia(copia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Utente instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Utente instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Utente o = null;
        Utente instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Utente instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        */
/*
    }
    
}
*/
