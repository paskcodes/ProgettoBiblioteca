package gestionelibro.visualizzazione;

import gestionearchivio.Archiviabile;
import appbibliotecauniversitaria.ControlloreHome;
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
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.TextFieldTableCell;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

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
    
    private final SortedList<Libro> archivioLibriOrdinato = new SortedList<>(archivioLibri, new ComparatoreTitoloLibro());
   
    private final FilteredList<Libro> archivioLibriFiltrato = new FilteredList<>(archivioLibriOrdinato);

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
        filtroRicercaLibri.getItems().addAll("Titolo", "ISBN");

        // imposta un filtro di default
        filtroRicercaLibri.setValue("Titolo");

        // permette di visualizzare il valore di ogni campo del libro nella rispettiva colonna
        colonnaTitoloTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getTitolo()));
        colonnaAutoriTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getAutori()));
        colonnaDataPubblicazioneTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getDataPubblicazione().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        colonnaISBNTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getISBN()));
        colonnaNumCopieTabellaLibri.setCellValueFactory(r -> new SimpleStringProperty(String.valueOf(r.getValue().getCopie())));

        // permette di modificare il valore della cella nella tabella (tranne ISBN che è l'identificativo)
        colonnaTitoloTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaAutoriTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaDataPubblicazioneTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaNumCopieTabellaLibri.setCellFactory(TextFieldTableCell.forTableColumn());

        //imposta l'archivioUtentiFiltrato come lista osservabile da cui prendere i dati
        tabellaLibri.setItems(archivioLibriFiltrato);
    }

    /**
     * @brief Rimuove un libro dalla tabella.
     * @param event Evento di azione generato dal pulsante di aggiunta.
     */
    @FXML
    private void rimuoviLibro(ActionEvent event) {
        //mantiene il riferimento al libro selezionato
        Libro daEliminare = tabellaLibri.getSelectionModel().getSelectedItem();
        
        //verifica che non sia in prestiti attivi e rimuove il libro, altrimenti cattura un eccezione
        try{
            cvp.inPrestitoAttivoLibro(daEliminare);
            archivioLibri.remove(daEliminare);
        }catch(LibroInvalidoException ex){
        ///////////////////////////////////////////////////////
        }
        
        crp.resetLibroPrePrestito();
    }

    /**
     * @brief Aggiorna il titolo di un libro selezionato dalla tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaTitoloLibri(TableColumn.CellEditEvent<Libro, String> event) {
        try{
        event.getRowValue().setTitolo(event.getNewValue());
        }catch(LibroCampoVuotoException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna gli autori di un libro selezionato dalla tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaAutoriLibri(TableColumn.CellEditEvent<Libro, String> event) {
        try{
        event.getRowValue().setAutori(event.getNewValue());
        }catch(LibroCampoVuotoException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna la data di pubblicazione di un libro selezionato dalla
     *        tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaDataPubblicazioneLibri(TableColumn.CellEditEvent<Libro, LocalDate> event) {
        //modifica il campo titolo dell'elemento all'interno dell'archivioLibri, corrispondente a quella riga nella tabella, con il testo inserito a mano per la modifica
        try{
            event.getRowValue().setDataPubblicazione(LocalDate.parse(event.getNewValue().toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }catch(LibroDataPubblicazioneException |DateTimeParseException  ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
        
    }

    /**
     * @brief Aggiorna il numero di copie di un libro selezionato dalla tabella.
     * @param event Evento di azione generato dal pulsante di rimozione.
     */
    @FXML
    private void aggiornaNumCopieLibri(TableColumn.CellEditEvent<Libro, Integer> event) {
        //modifica il campo titolo dell'elemento all'interno dell'archivioLibri, corrispondente a quella riga nella tabella, con il testo inserito a mano per la modifica
        try{
            event.getRowValue().setCopie(Integer.parseInt(event.getNewValue().toString()));
        }catch(LibroNumeroCopieException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Gestisce la ricerca dei libri filtrando i risultati.
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
                    return u.getTitolo().toLowerCase().contains(filtro.toLowerCase()); //si usa contains perche' deve verificare che il filtro sia presente nell'elemento discriminante
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
            Alert a = new Alert(Alert.AlertType.WARNING, "Seleziona un libro se presente!", ButtonType.CLOSE);
            a.showAndWait();
        }
    }

    @Override
    public void inserisciNuovoElemento(Libro nuovoElemento) throws LibroInvalidoException {
        //se l'utente è già presente allora lancia un'eccezione
        if(isElementoPresente(nuovoElemento)) throw new LibroDuplicatoException();
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
    
    public void registraCopiaPrestata(Libro prestato){
        for(Libro l : archivioLibri){
            if(l.equals(l)){
                l.prendiCopia();
            }
        }
    }
    
    public void registraCopiaRestituita(Libro prestato){
        for(Libro l : archivioLibri){
            if(l.equals(l)){
                l.restituisciCopia();
            }
        }
    }
    
    public void aggiornaStatoVisualizzazione(){
        tabellaLibri.refresh();
    }

    public void setControlloreRegistrazionePrestiti(ControlloreRegPrestito crp) {
        this.crp = crp;
    }

    public void setControlloreVisualizzazionePrestiti(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }

}
