package gestioneprestito.visualizzazione;

import gestionearchivio.Archiviabile;
import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroPrestitoAttivoException;
import gestionelibro.visualizzazione.ControlloreVisLibri;
import gestioneprestito.Prestito;
import gestioneprestito.eccezioni.PrestitoDuplicatoException;
import gestioneprestito.eccezioni.PrestitoInvalidoException;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtentePrestitoAttivoException;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
public class ControlloreVisPrestiti implements Initializable, Archiviabile<Prestito, PrestitoInvalidoException> {

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

    private ControlloreVisUtenti cvu;

    private ControlloreVisLibri cvl;

    private ObservableList<Prestito> archivioPrestiti = FXCollections.observableArrayList();
    private FilteredList<Prestito> filteredData;

    /**
     * \endcond
     */

    /**
     * @brief Inizializza il controller della schermata di visualizzazione dei
     *        prestiti
     * @param url L'URL di riferimento
     * @param rb  Il ResourceBundle di riferimento
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colonnaUtenteTabellaPrestiti
                .setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUtente().toString()));
        colonnaLibroTabellaPrestiti
                .setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getLibro().toString()));
        colonnaDataScadenzaTabellaPrestiti
                .setCellValueFactory(cell -> new SimpleObjectProperty<LocalDate>(cell.getValue().getDataScadenza()));

        filteredData = new FilteredList<>(archivioPrestiti, p -> true);
        SortedList<Prestito> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tabellaPrestiti.comparatorProperty());
        tabellaPrestiti.setItems(sortedData);
    }

    /**
     * @brief Gestisce l'estinzione del prestito
     * @param event L'evento di ricerca
     */
    @FXML
    private void estinguiPrestito(ActionEvent event) {
        Prestito selezionato = tabellaPrestiti.getSelectionModel().getSelectedItem();
        if (selezionato != null) {
            archivioPrestiti.remove(selezionato);
            if (cvu != null)
                cvu.registraCopiaRestituita(selezionato.getUtente(), selezionato.getLibro());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Seleziona un prestito da estinguere", ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     * @brief Esegue la ricerca e il filtraggio dei prestiti nella tabella.
     * @param event Evento di tastiera generato dall'input di ricerca.
     */
    @FXML
    private void ricercaPrestiti(KeyEvent event) {
    }

    @Override
    public void inserisciNuovoElemento(Prestito nuovoElemento) throws PrestitoDuplicatoException {
        if (isElementoPresente(nuovoElemento))
            throw new PrestitoDuplicatoException();
        archivioPrestiti.add(nuovoElemento);
    }

    @Override
    public boolean isElementoPresente(Prestito daCercare) {
        return archivioPrestiti.contains(daCercare);
    }

    @Override
    public ObservableList<Prestito> getListaElementi() {
        return this.archivioPrestiti;
    }

    public boolean inPrestitoAttivoUtente(Utente indagato) throws UtentePrestitoAttivoException {
        if (archivioPrestiti.stream().anyMatch(p -> p.getUtente().getMatricola().equals(indagato.getMatricola())))
            throw new UtentePrestitoAttivoException();
        return false;
    }

    public boolean inPrestitoAttivoLibro(Libro indagato) throws LibroPrestitoAttivoException {
        if (archivioPrestiti.stream().anyMatch(p -> p.getLibro().getISBN().equals(indagato.getISBN())))
            throw new LibroPrestitoAttivoException();
        return false;
    }

    public void setControlloreVisUtenti(ControlloreVisUtenti cvu) {
        this.cvu = cvu;
    }

    public ControlloreVisUtenti getControlloreVisUtenti() {
        return this.cvu;
    }

}
