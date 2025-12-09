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
import javafx.scene.layout.AnchorPane;

/**
 * @class ControlloreVisPrestiti
 * @brief Classe controller della schermata di visualizzazione dei prestiti
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
    @FXML
    private TextField testoRicercaPrestiti;
    @FXML
    private ChoiceBox<String> filtroRicercaPrestiti;
    
    private ObservableList<Prestito> listaPrestiti;
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
     * @brief Inserisce un nuovo prestito
     * @param prestito Il prestito da inserire
     */
    public void inserisciNuovoPrestito(Prestito prestito){
    }

    /**
     * @brief Controlla se un prestito esiste
     * @param prestito Il prestito da controllare
     * @return true se il prestito esiste, false altrimenti
     */
    public boolean isPrestitoEsistente(Prestito prestito){
        return true;
    }
    
}
