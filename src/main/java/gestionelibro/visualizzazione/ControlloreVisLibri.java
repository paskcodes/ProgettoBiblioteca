package gestionelibro.visualizzazione;

import appbibliotecauniversitaria.FinestraEccezione;
import gestionearchivio.Archiviabile;
import gestionelibro.ComparatoreTitoloLibro;
import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroCampoVuotoException;
import gestionelibro.eccezioni.LibroDataPubblicazioneException;
import gestionelibro.eccezioni.LibroDuplicatoException;
import gestionelibro.eccezioni.LibroInvalidoException;
import gestionelibro.eccezioni.LibroNumeroCopieException;
import gestioneprestito.registrazione.ControlloreRegPrestito;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import java.net.URL;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.TextFieldTableCell;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    private TableColumn<Libro, String> colonnaDataPubblicazioneTabellaLibri;
    @FXML
    private TableColumn<Libro, String> colonnaISBNTabellaLibri;
    @FXML
    private TableColumn<Libro, String> colonnaNumCopieTabellaLibri;
    @FXML
    private TextField testoRicercaLibri;
    @FXML
    private ChoiceBox<String> filtroRicercaLibri;

    private ControlloreRegPrestito crp;

    private ControlloreVisPrestiti cvp;

    private final ObservableList<Libro> archivioLibri = FXCollections.observableArrayList();

    private final SortedList<Libro> archivioLibriOrdinato = new SortedList<>(archivioLibri,
            new ComparatoreTitoloLibro());

    private final FilteredList<Libro> archivioLibriFiltrato = new FilteredList<>(archivioLibriOrdinato);

    /**
     * \endcond
     */

    /**
     * @brief Inizializza il controller della visualizzazione dei libri.
     * @details Configura le colonne della tabella, il filtro di ricerca e imposta
     *          l'archivio dei libri come fonte dati della tabella.
     * @param url URL della risorsa FXML.
     * @param rb  Bundle delle risorse.
     * @throws NullPointerException Se si verifica un errore durante
     *                              l'inizializzazione.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filtroRicercaLibri.getItems().addAll("Titolo", "ISBN");

        filtroRicercaLibri.setValue("Titolo");

        colonnaTitoloTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getTitolo()));
        colonnaAutoriTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getAutori()));
        colonnaDataPubblicazioneTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(
                r.getValue().getDataPubblicazione().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        colonnaISBNTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getISBN()));
        colonnaNumCopieTabellaLibri
                .setCellValueFactory(r -> new SimpleStringProperty(String.valueOf(r.getValue().getCopie())));

        colonnaTitoloTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaAutoriTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaDataPubblicazioneTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaNumCopieTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());

        tabellaLibri.setItems(archivioLibriFiltrato);
    }

    /**
     * @brief Rimuove un libro dalla tabella.
     * @details Verifica che il libro non sia attualmente in prestito prima di
     *          rimuoverlo dall'archivio.
     * @param event Evento di azione generato dal pulsante di aggiunta.
     * @throws LibroInvalidoException Se il libro è attualmente in prestito.
     */
    @FXML
    private void rimuoviLibro(ActionEvent event) {
        Libro daEliminare = tabellaLibri.getSelectionModel().getSelectedItem();

        try {
            cvp.inPrestitoAttivoLibro(daEliminare);
            archivioLibri.remove(daEliminare);
        } catch (LibroInvalidoException ex) {
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        }

        crp.resetLibroPrePrestito();
    }

    /**
     * @brief Aggiorna il titolo di un libro selezionato dalla tabella.
     * @details Verifica che il nuovo titolo non sia vuoto prima di aggiornarlo.
     * @param event Evento di azione generato dal pulsante di rimozione.
     * @throws LibroCampoVuotoException Se il nuovo titolo è vuoto.
     */
    @FXML
    private void aggiornaTitoloLibri(TableColumn.CellEditEvent<Libro, String> event) {
        try {
            event.getRowValue().setTitolo(event.getNewValue());
        } catch (LibroCampoVuotoException ex) {
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        }

        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna gli autori di un libro selezionato dalla tabella.
     * @details Verifica che il nuovo campo autori non sia vuoto prima di
     *          aggiornarlo.
     * @param event Evento di azione generato dal pulsante di rimozione.
     * @throws LibroCampoVuotoException Se il nuovo campo autori è vuoto.
     */
    @FXML
    private void aggiornaAutoriLibri(TableColumn.CellEditEvent<Libro, String> event) {
        try {
            event.getRowValue().setAutori(event.getNewValue());
        } catch (LibroCampoVuotoException ex) {
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        }
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna la data di pubblicazione di un libro selezionato dalla
     *        tabella.
     * @details Verifica che la nuova data di pubblicazione sia valida prima di
     *          aggiornarla.
     * @param event Evento di azione generato dal pulsante di rimozione.
     * @throws LibroDataPubblicazioneException Se la nuova data di pubblicazione non
     *                                         è valida.
     */
    @FXML
    private void aggiornaDataPubblicazioneLibri(TableColumn.CellEditEvent<Libro, String> event) {
        try {
            event.getRowValue().setDataPubblicazione(
                    LocalDate.parse(event.getNewValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (LibroDataPubblicazioneException ex) {
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        }catch (ClassCastException ex) {
            FinestraEccezione fc = new FinestraEccezione("Campo vuoto o non valido");
        }catch (DateTimeParseException ex) {
            FinestraEccezione fc = new FinestraEccezione("Campo vuoto o non valido!");
        }
        

        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna il numero di copie di un libro selezionato dalla tabella.
     * @details Verifica che il nuovo numero di copie sia valido prima di
     *          aggiornarlo.
     * @param event Evento di azione generato dal pulsante di rimozione.
     * @throws LibroNumeroCopieException Se il nuovo numero di copie non è valido.
     */
    @FXML
    private void aggiornaNumCopieLibri(TableColumn.CellEditEvent<Libro, String> event) {
        try {
            event.getRowValue().setCopie(Integer.parseInt(event.getNewValue()));
        } catch (LibroNumeroCopieException ex) {
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        }catch (ClassCastException ex) {
            FinestraEccezione fc = new FinestraEccezione("I campi non possono essere lasciati vuoti!");
        }catch (NumberFormatException ex) {
            FinestraEccezione fc = new FinestraEccezione("Accetta solo numeri!");
        }

        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Gestisce la ricerca dei libri filtrando i risultati.
     * @details Filtra i libri in base al tipo di ricerca selezionato e al testo
     *          inserito.
     * @param event Evento di tastiera generato dall'input di ricerca.
     */
    @FXML
    private void ricercaLibri(KeyEvent event) {

        String filtro = testoRicercaLibri.getText();
        String tipo = filtroRicercaLibri.getValue();

        if (filtro == null || filtro.length() == 0) {
            archivioLibriFiltrato.setPredicate(u -> true);
        } else {
            archivioLibriFiltrato.setPredicate(u -> {
                if (tipo.equals("Titolo")) {
                    return u.getTitolo().toLowerCase().contains(filtro.toLowerCase());
                } else if (tipo.equals("ISBN")) {
                    return u.getISBN().contains(filtro);
                }
                return false;
            });
        }
    }
    
    /**
     * @brief Gestisce la selezione di un libro nella tabella.
     * @param event Evento di click del mouse sulla tabella.
     */
    @FXML
    private void selezionaLibro(MouseEvent event) {
        //carica il libro selezionato nel libroPrePrestito, altrimenti cattura un'eccezione
        try{
            crp.setLibroPrePrestito(tabellaLibri.getSelectionModel().getSelectedItem());
        }catch(NullPointerException ex){
            FinestraEccezione fc = new FinestraEccezione("Seleziona un libro se presente!");
        }
    }
    
    /**
     * @brief Inserisce un nuovo libro nell'archivio.
     * @details Verifica che il libro non sia già presente nell'archivio prima di
     *          inserirlo.
     * @param nuovoElemento Il libro da inserire.
     * @throws LibroInvalidoException Se il libro è già presente nell'archivio.
     */
    @Override
    public void inserisciNuovoElemento(Libro nuovoElemento) throws LibroInvalidoException {
        if (isElementoPresente(nuovoElemento))
            throw new LibroDuplicatoException();
        archivioLibri.add(nuovoElemento);
    }

    /**
     * @brief Verifica se un libro è già presente nell'archivio.
     * @param daCercare Il libro da cercare.
     */
    @Override
    public boolean isElementoPresente(Libro daCercare) {
        return archivioLibri.stream().anyMatch(l -> l.getISBN().equals(daCercare.getISBN()));
    }

    /**
     * @brief Restituisce la lista dei libri nell'archivio.
     * @return La lista dei libri.
     */
    @Override
    public ObservableList<Libro> getListaElementi() {
        return this.archivioLibri;
    }

    /**
     * @brief Registra una copia prestata di un libro.
     * @param prestato Il libro di cui registrare la copia prestata.
     */
    public void registraCopiaPrestata(Libro prestato) {
        for (Libro l : archivioLibri) {
            if (l.equals(prestato)) {
                l.prendiCopia();
            }
        }
    }

    /**
     * @brief Registra una copia restituita di un libro.
     * @param prestato Il libro di cui registrare la copia restituita.
     */
    public void registraCopiaRestituita(Libro prestato) {
        for (Libro l : archivioLibri) {
            if (l.equals(prestato)) {
                l.restituisciCopia();
            }
        }
    }

    /**
     * @brief Aggiorna lo stato di visualizzazione della tabella dei libri.
     */
    public void aggiornaStatoVisualizzazione() {
        tabellaLibri.refresh();
    }

    /**
     * @brief Imposta il controllore di registrazione prestiti.
     * @param crp Il controllore di registrazione prestiti.
     */
    public void setControlloreRegistrazionePrestiti(ControlloreRegPrestito crp) {
        this.crp = crp;
    }

    /**
     * @brief Imposta il controllore di visualizzazione prestiti.
     * @param cvp Il controllore di visualizzazione prestiti.
     */
    public void setControlloreVisualizzazionePrestiti(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }
}
