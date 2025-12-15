package gestionelibro.visualizzazione;

import gestionearchivio.Archiviabile;
import appbibliotecauniversitaria.ControlloreHome;
import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroDuplicatoException;
import gestionelibro.eccezioni.LibroInvalidoException;
import gestioneprestito.registrazione.ControlloreRegPrestito;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import java.net.URL;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.TextFieldTableCell;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @class ControlloreVisLibri
 * @brief Classe controller per la visualizzazione e gestione dei libri.
 *        Gestisce l'interazione con la tabella dei libri, inclusa l'aggiunta,
 *        la rimozione e l'aggiornamento delle informazioni sui libri.
 */
public class ControlloreVisLibri implements Initializable, Archiviabile<Libro, LibroInvalidoException> {

    /**
     * \cond Doxygen_skip
     */
    @FXML
    private TableView<Libro> tabellaLibri;
    @FXML
    private TableColumn<Libro, String> colonnaTitoloTabellaLibri;
    @FXML
    private TableColumn<Libro, String> colonnaAutoriTabellaLibri;
    @FXML
    private TableColumn<Libro, LocalDate> colonnaDataPubblicazioneTabellaLibri;
    @FXML
    private TableColumn<Libro, String> colonnaISBNTabellaLibri;
    @FXML
    private TableColumn<Libro, Integer> colonnaNumCopieTabellaLibri;
    @FXML
    private TextField testoRicercaLibri;
    @FXML
    private ChoiceBox<String> filtroRicercaLibri;

    private ControlloreRegPrestito crp;

    private ControlloreVisPrestiti cvp;

    private ObservableList<Libro> archivioLibri = FXCollections.observableArrayList();

    /**
     * \endcond
     */

    /**
     * @brief Inizializza il controller della visualizzazione dei libri.
     *        Configura le colonne della tabella e carica i dati iniziali.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // aggiunge i filtri possibili
        filtroRicercaLibri.getItems().addAll("Titolo", "Autore", "ISBN");

        // imposta un filtro di default
        filtroRicercaLibri.setValue("Titolo");

        // permette di visualizzare il valore di ogni campo del libro nella rispettiva
        // colonna
        colonnaTitoloTabellaLibri.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitolo()));
        colonnaAutoriTabellaLibri.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAutori()));
        colonnaDataPubblicazioneTabellaLibri.setCellValueFactory(
                cell -> new SimpleObjectProperty<LocalDate>(cell.getValue().getDataPubblicazione()));
        colonnaISBNTabellaLibri.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getISBN()));
        colonnaNumCopieTabellaLibri
                .setCellValueFactory(cell -> new SimpleObjectProperty<Integer>(cell.getValue().getCopie()));

        // permette di modificare il valore della cella nella tabella (tranne ISBN che è
        // identificativo)
        colonnaTitoloTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaAutoriTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        // Per data e copie servirebbero convertitori specifici per TextFieldTableCell,
        // per ora ometto l'editing o uso stringhe

        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Libro> filteredData = new FilteredList<>(archivioLibri, p -> true);

        // Imposta il predicato del filtro quando cambia il testo di ricerca
        testoRicercaLibri.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(libro -> {
                // Se il filtro è vuoto, visualizza tutto
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String tipo = filtroRicercaLibri.getValue();

                if (tipo.equals("Titolo")) {
                    return libro.getTitolo().toLowerCase().contains(lowerCaseFilter);
                } else if (tipo.equals("Autore")) {
                    return libro.getAutori().toLowerCase().contains(lowerCaseFilter);
                } else if (tipo.equals("ISBN")) {
                    return libro.getISBN().toLowerCase().contains(lowerCaseFilter);
                }

                return false; // Does not match.
            });
        });

        // Wrap the FilteredList in a SortedList.
        SortedList<Libro> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tabellaLibri.comparatorProperty());

        // Add sorted (and filtered) data to the table.
        tabellaLibri.setItems(sortedData);
    }

    /**
     * @brief Rimuove un libro dalla tabella.
     * @param event Evento di azione generato dal pulsante di aggiunta.
     */
    @FXML
    private void rimuoviLibro(ActionEvent event) {
        Libro selezionato = tabellaLibri.getSelectionModel().getSelectedItem();
        if (selezionato != null) {
            // Qui bisognerebbe controllare i prestiti attivi prima di rimuovere
            archivioLibri.remove(selezionato);
        } else {
            // Mostra alert se necessario
        }
    }

    /**
     * @brief Aggiorna il titolo di un libro selezionato dalla tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaTitoloLibri(TableColumn.CellEditEvent<Libro, String> event) {
        event.getRowValue().setTitolo(event.getNewValue());
    }

    /**
     * @brief Aggiorna gli autori di un libro selezionato dalla tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaAutoriLibri(TableColumn.CellEditEvent<Libro, String> event) {
        event.getRowValue().setAutori(event.getNewValue());
    }

    /**
     * @brief Aggiorna la data di pubblicazione di un libro selezionato dalla
     *        tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaDataPubblicazioneLibri(TableColumn.CellEditEvent<Libro, LocalDate> event) {
        // Implementazione dipendente dall'editing della cella data
    }

    /**
     * @brief Aggiorna il numero di copie di un libro selezionato dalla tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaNumCopieLibri(TableColumn.CellEditEvent<Libro, Integer> event) {
        // Implementazione dipendente dall'editing della cella intera
    }

    /**
     * @brief Gestisce la ricerca dei libri filtrando i risultati.
     * @param event Evento di tastiera generato dall'input di ricerca.
     */
    @FXML
    private void ricercaLibri(KeyEvent event) {
        // La logica è gestita dal Listener aggiunto in initialize
    }

    /**
     * @brief Gestisce la selezione di un libro nella tabella.
     * @param event Evento di click del mouse sulla tabella.
     */
    @FXML
    private void selezionaLibro(MouseEvent event) {
        crp.setLibroPrePrestito(tabellaLibri.getSelectionModel().getSelectedItem());
    }

    @Override
    public void inserisciNuovoElemento(Libro nuovoElemento) throws LibroInvalidoException {
        if ((isElementoPresente(nuovoElemento)))
            throw new LibroDuplicatoException();
        archivioLibri.add(nuovoElemento);
    }

    @Override
    public boolean isElementoPresente(Libro daCercare) {
        return archivioLibri.stream().anyMatch(l -> l.getISBN().equals(daCercare.getISBN()));
    }

    @Override
    public ObservableList<Libro> getListaElementi() {
        return this.archivioLibri;
    }

    public void setControlloreRegistrazionePrestiti(ControlloreRegPrestito crp) {
        this.crp = crp;
    }

    public void setControlloreVisualizzazionePrestiti(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }

}
