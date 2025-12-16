package gestionelibro;


import gestionelibro.eccezioni.LibroInvalidoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class LibroTest {

    @Test
    public void testSetTitolo() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l1.setTitolo("");
        } catch (LibroInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Libro l2 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l2.setTitolo("Titolo con (àèé-ìòù)");
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testSetAutori() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l1.setAutori("");
        } catch (LibroInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Libro l2 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l2.setAutori("Josè Conceição");
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testSetDataPubblicazione() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l1.setDataPubblicazione(null);
        } catch (LibroInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Libro l2 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l2.setDataPubblicazione(LocalDate.now().plusDays(1));
        } catch (LibroInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Libro l3 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l3.setDataPubblicazione(LocalDate.of(2000, 1, 1));
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testSetCopie() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l1.setCopie(0);
        } catch (LibroInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Libro l2 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l2.setCopie(-5);
        } catch (LibroInvalidoException ex) {
            assertTrue(true);
        }

        try {
            Libro l3 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            l3.setCopie(10);
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testCostruttoreValido() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            assertEquals("1984", l1.getTitolo());
            assertEquals("Mario Rossi", l1.getAutori());
            assertEquals("978-0-452-28423-4", l1.getISBN());
            assertEquals(3, l1.getCopie());
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testIsCopiaDisponibile() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 2);

            assertTrue(l1.isCopiaDisponibile());

            l1.prendiCopia();
            assertTrue(l1.isCopiaDisponibile());

            l1.prendiCopia();
            assertFalse(l1.isCopiaDisponibile());
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testEquals() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            Libro l2 = new Libro("Titolo Diverso", "Autore Diverso",
                    LocalDate.of(2000, 1, 1), "978-0-452-28423-4", 10);
            Libro l3 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-5", 3);

            assertTrue(l1.equals(l1));
            assertTrue(l1.equals(l2));
            assertFalse(l1.equals(l3));
            assertFalse(l1.equals(null));
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testHashCode() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);
            Libro l2 = new Libro("Titolo Diverso", "Autore Diverso",
                    LocalDate.of(2000, 1, 1), "978-0-452-28423-4", 10);
            Libro l3 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-5", 3);

            assertEquals(l1.hashCode(), l2.hashCode());
            assertNotEquals(l1.hashCode(), l3.hashCode());
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testCompareTo() {
        try {
            Libro l1 = new Libro("Aaaaa", "Mario Rossi", LocalDate.of(2000, 1, 1), "111", 1);
            Libro l2 = new Libro("Bbbbb", "Mario Rossi", LocalDate.of(2000, 1, 1), "222", 1);
            Libro l3 = new Libro("Aaaaa", "Mario Rossi", LocalDate.of(2000, 1, 1), "333", 1);

            assertTrue(l1.compareTo(l2) < 0);
            assertTrue(l2.compareTo(l1) > 0);
            assertEquals(0, l1.compareTo(l3));
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testToString() {
        try {
            Libro l1 = new Libro("1984", "Mario Rossi",
                    LocalDate.of(1975, 6, 8), "978-0-452-28423-4", 3);

            assertEquals("978-0-452-28423-4", l1.toString());
        } catch (LibroInvalidoException ex) {
            assertTrue(false);
        }
    }
}
