package gestionelibro.registrazione;

import gestionelibro.visualizzazione.ControlloreVisLibri;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.scene.control.Alert;
import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroDuplicatoException;
import gestionelibro.eccezioni.LibroInvalidoException;
import javafx.scene.control.ButtonType;

/**
 * @class ControlloreRegLibro
 * @brief Classe controller per la registrazione di un nuovo libro.
 * 
 */
public class ControlloreRegLibro implements Initializable {
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
    /**
     * \endcond
     */

    private ControlloreVisLibri cvl;

    /**
     * @brief Inizializza il controller della scena di registrazione del libro.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo libro.
     * @param event L'evento generato dal click sul bottone di registrazione.
     */
    @FXML
    private void registraLibro(ActionEvent event) {
        try{
            // Recupera i dati nelle celle di testo
            String titolo = testoRegistraLibroTitolo.getText();
            String autori = testoRegistraAutoriLibro.getText();
            LocalDate dataScadenza = LocalDate.parse(testoRegistraDataPubblicazioneLibro.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String isbn = testoRegistraISBNLibro.getText();
            int copie = Integer.parseInt(testoRegistraNumCopieLibro.getText());
            Libro l = new Libro(titolo, autori, dataScadenza, isbn, copie);
            cvl.inserisciNuovoElemento(l);
        }catch(LibroInvalidoException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }catch(DateTimeParseException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, "Il formato della data non è valido!", ButtonType.CLOSE);
            a.showAndWait();
        }catch(NumberFormatException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, "Il numero di copie non è valido!", ButtonType.CLOSE);
            a.showAndWait();
        }
        
        testoRegistraLibroTitolo.clear();
        testoRegistraAutoriLibro.clear();
        testoRegistraDataPubblicazioneLibro.clear();
        testoRegistraISBNLibro.clear();
        testoRegistraNumCopieLibro.clear();
    }

    public void setControlloreVisualizzazione(ControlloreVisLibri cvl) {
        this.cvl = cvl;
    }
}
