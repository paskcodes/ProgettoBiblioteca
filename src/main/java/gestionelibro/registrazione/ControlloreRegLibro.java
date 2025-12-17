package gestionelibro.registrazione;

import appbibliotecauniversitaria.FinestraEccezione;
import gestionelibro.visualizzazione.ControlloreVisLibri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroInvalidoException;

/**
 * @class ControlloreRegLibro
 * @brief Classe controller per la registrazione di un nuovo libro.
 * @details Gestisce l'interazione con l'utente per la registrazione di un
 *          nuovo libro, inclusa la validazione dei dati inseriti e la
 *          comunicazione con il controller di visualizzazione dei libri.
 */
public class ControlloreRegLibro {
    /**
     * \cond Doxygen_Skip
     */
    @FXML
    private AnchorPane pannelloRegLibro;
    @FXML
    private TextField testoRegistraLibroTitolo;
    @FXML
    private TextField testoRegistraAutoriLibro;
    @FXML
    private TextField testoRegistraDataPubblicazioneLibro;
    @FXML
    private TextField testoRegistraISBNLibro;
    @FXML
    private TextField testoRegistraNumCopieLibro;
    @FXML
    private Button bottoneAggiungiLibro;

    private ControlloreVisLibri cvl;

    /**
     * \endcond
     */

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo libro.
     * @details Verifica che tutti i campi siano validi e crea un nuovo libro.
     * @param event L'evento generato dal click sul bottone di registrazione.
     * @throws LibroInvalidoException Se i dati del libro non sono validi.
     * @throws DateTimeParseException Se la data di pubblicazione non è nel formato
     *                                corretto.
     * @throws NumberFormatException  Se il numero di copie non è un intero valido.
     */
    @FXML
    private void registraLibro(ActionEvent event) {
        try {
            // Recupera i dati nelle celle di testo
            String titolo = testoRegistraLibroTitolo.getText();
            String autori = testoRegistraAutoriLibro.getText();
            LocalDate dataScadenza = LocalDate.parse(testoRegistraDataPubblicazioneLibro.getText(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String isbn = testoRegistraISBNLibro.getText();
            int copie = Integer.parseInt(testoRegistraNumCopieLibro.getText());
            Libro l = new Libro(titolo, autori, dataScadenza, isbn, copie);
            cvl.inserisciNuovoElemento(l);

            testoRegistraLibroTitolo.clear();
            testoRegistraAutoriLibro.clear();
            testoRegistraDataPubblicazioneLibro.clear();
            testoRegistraISBNLibro.clear();
            testoRegistraNumCopieLibro.clear();
        }catch(LibroInvalidoException ex){
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        } catch (DateTimeParseException ex) {
            FinestraEccezione fc = new FinestraEccezione("Il formato della data non è valido!");
        } catch (NumberFormatException ex) {
            FinestraEccezione fc = new FinestraEccezione("Il numero di copie non è valido!");
        }

    }

    /**
     * @brief Imposta il controller di visualizzazione libri.
     * @param cvl Il controller di visualizzazione libri.
     */
    public void setControlloreVisualizzazione(ControlloreVisLibri cvl) {
        this.cvl = cvl;
    }

    /**
     * @brief Gestisce la pressione del tasto Invio per registrare il libro
     * @param event L'evento di pressione tasto
     */

}
