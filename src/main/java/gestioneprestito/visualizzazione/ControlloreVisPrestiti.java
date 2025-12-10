package gestioneprestito.visualizzazione;

import gestioneprestito.Prestito;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @class ControlloreVisPrestiti
 * @brief Controller della schermata di visualizzazione dei prestiti.
 * @details Gestisce tabella, filtri e azioni di estinzione prestiti nella UI.
 */
public class ControlloreVisPrestiti implements Initializable {

    /**
     * \cond DOXYGEN_SKIP
     */
    @FXML
    private AnchorPane pannelloVisPrestiti;
    @FXML
    private TableView<Prestito> tabellaPrestiti;
    @FXML
    private TableColumn<Prestito, String> colonnaUtenteTabellaPrestiti;
    @FXML
    private TableColumn<Prestito, String> colonnaLibroTabellaPrestiti;
    @FXML
    private TableColumn<Prestito, LocalDate> colonnaDataScadenzaTabellaPrestiti;


    
    /**
     * \endcond
     */

    /**
     * @brief Inizializza il controller della schermata di visualizzazione dei prestiti
     * @param url L'URL di riferimento
     * @param rb Il ResourceBundle di riferimento
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @brief Gestisce l'estinzione del prestito
     * @param event L'evento di ricerca
     */
    @FXML
    private void estinguiPrestito(ActionEvent event) {
    }
    
    /**
     * @brief Esegue la ricerca e il filtraggio dei prestiti nella tabella.
     * @param event Evento di tastiera generato dall'input di ricerca.
     */
    @FXML
    private void ricercaPrestiti(KeyEvent event) {
    }
    
}
