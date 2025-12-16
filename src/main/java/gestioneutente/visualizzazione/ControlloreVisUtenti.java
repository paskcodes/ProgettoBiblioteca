/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.visualizzazione;

import gestionearchivio.Archiviabile;
import gestioneutente.Utente;
import gestionelibro.Libro;
import gestioneprestito.registrazione.ControlloreRegPrestito;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.ComparatoreCognomeNomeUtente;
import gestioneutente.eccezioni.UtenteDuplicatoException;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.eccezioni.UtenteMailException;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @class ControlloreVisUtenti
 * @brief Controller FXML per la visualizzazione e gestione degli utenti.
 * @details Gestisce tabella, filtri di ricerca e operazioni di
 *          modifica/rimozione utenti.
 */
public class ControlloreVisUtenti implements Initializable, Archiviabile<Utente, UtenteInvalidoException> {

    /**
     * \cond DOXY_SKIP
     */
    @FXML
    private TableView<Utente> tabellaUtenti;
    @FXML
    private TableColumn<Utente, String> colonnaNomeTabellaUtenti;
    @FXML
    private TableColumn<Utente, String> colonnaCognomeTabellaUtenti;
    @FXML
    private TableColumn<Utente, String> colonnaMailTabellaUtenti;
    @FXML
    private TableColumn<Utente, String> colonnaMatricolaTabellaUtenti;
    @FXML
    private TableColumn<Utente, String> colonnaCopiePrestitiTabellaUtente;
    @FXML
    private TextField testoRicercaUtenti;
    @FXML
    private ChoiceBox<String> filtroRicercaUtenti;

    private ControlloreRegPrestito crp;

    private ControlloreVisPrestiti cvp;

    private final ObservableList<Utente> archivioUtenti = FXCollections.observableArrayList();

    private final SortedList<Utente> archivioUtentiOrdinato = new SortedList<>(archivioUtenti,
            new ComparatoreCognomeNomeUtente());

    private final FilteredList<Utente> archivioUtentiFiltrato = new FilteredList<>(archivioUtentiOrdinato);

    /**
     * \endcond
     */

    /**
     * @brief Inizializza il controller della vista utenti.
     * @details Configura colonne tabella, filtri di ricerca e dati iniziali.
     * @param url URL di riferimento.
     * @param rb  ResourceBundle di riferimento.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // aggiunge i filtri possibili
        filtroRicercaUtenti.getItems().addAll("Cognome", "Matricola");

        // imposta un filtro di default
        filtroRicercaUtenti.setValue("Cognome");

        // permette di visualizzare il valore di ogni campo dell'utente nella rispettiva
        // colonna
        colonnaNomeTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getNome()));
        colonnaCognomeTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getCognome()));
        colonnaMailTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getMail()));
        colonnaMatricolaTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getMatricola()));
        colonnaCopiePrestitiTabellaUtente
                .setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getLibriInPrestito().toString()));

        // permette di modificare il valore della cella nella tabella
        colonnaNomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaCognomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaMailTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaCopiePrestitiTabellaUtente.setCellFactory(cell -> {
            return new TableCell<Utente, String>() {
                private final javafx.scene.text.Text nodoTesto = new javafx.scene.text.Text();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        nodoTesto.setText(item);

                        nodoTesto.wrappingWidthProperty().bind(getTableColumn().widthProperty().subtract(20));

                        setGraphic(nodoTesto);
                    }
                }
            };
        });

        tabellaUtenti.setItems(archivioUtentiFiltrato);
    }

    /**
     * @brief Aggiorna il nome dell'utente selezionato.
     * @details Modifica il nome dell'utente nell'archivio e aggiorna la tabella.
     * @param event Evento di modifica cella con il nuovo valore.
     * @throws UtenteNomeCognomeException Se il nome non è valido.
     */
    @FXML
    private void aggiornaNomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        try {
            event.getRowValue().setNome(event.getNewValue());
        } catch (UtenteNomeCognomeException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna il cognome dell'utente selezionato.
     * @details Modifica il cognome dell'utente nell'archivio e aggiorna la tabella.
     * @param event Evento di modifica cella con il nuovo valore.
     * @throws UtenteNomeCognomeException Se il cognome non è valido.
     */
    @FXML
    private void aggiornaCognomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        try {
            event.getRowValue().setCognome(event.getNewValue());
        } catch (UtenteNomeCognomeException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }

        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna la mail dell'utente selezionato.
     * @details Modifica la mail dell'utente nell'archivio e aggiorna la tabella.
     * @param event Evento di modifica cella con il nuovo valore.
     * @throws UtenteMailException Se la mail non è valida.
     */
    @FXML
    private void aggiornaMailUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        try {
            event.getRowValue().setMail(event.getNewValue());
        } catch (UtenteMailException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }

        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Rimuove l'utente selezionato dalla tabella/archivio.
     * @details Verifica che l'utente non abbia prestiti attivi prima della rimozione.
     * @param event Evento di azione generato dal comando di rimozione.
     * @throws UtenteInvalidoException Se l'utente ha prestiti attivi.
     */
    @FXML
    private void rimuoviUtente(ActionEvent event) {
        Utente daEliminare = tabellaUtenti.getSelectionModel().getSelectedItem();

        try {
            cvp.inPrestitoAttivoUtente(daEliminare);
            archivioUtenti.remove(daEliminare);
        } catch (UtenteInvalidoException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        crp.resetUtentePrePrestito();

    }

    /**
     * @brief Esegue la ricerca degli utenti in base al filtro selezionato.
     * @details Aggiorna la tabella con gli utenti che corrispondono al criterio di ricerca.
     * @param event Evento di tastiera generato dal campo di ricerca.
     */
    @FXML
    private void ricercaUtenti(KeyEvent event) {
        String filtro = testoRicercaUtenti.getText();
        String tipo = filtroRicercaUtenti.getValue();

        if (filtro == null || filtro.length() == 0) {
            archivioUtentiFiltrato.setPredicate(u -> true);
        } else {
            archivioUtentiFiltrato.setPredicate(u -> {
                if (tipo.equals("Cognome")) {
                    return u.getCognome().toLowerCase().contains(filtro.toLowerCase());
                } else if (tipo.equals("Matricola")) {
                    return u.getMatricola().contains(filtro);
                }
                return false;
            });
        }
    }

    
    /**
     * @brief Gestisce la selezione di un utente nella tabella.
     * @param event Evento di click del mouse sulla tabella.    
     */
    @FXML
    private void selezionaUtente(MouseEvent event) {
        //carica l'utente selezionato nell'utentePrePrestito, altrimenti cattura un'eccezione
        try{
            crp.setUtentePrePrestito(tabellaUtenti.getSelectionModel().getSelectedItem());
        }catch(NullPointerException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, "Seleziona un utente se presente!", ButtonType.CLOSE);
            a.showAndWait();
        }
                
    }
    
    
    
    
    
    /**
     * @brief Inserisce un nuovo utente nell'archivio.
     * @details Verifica che l'utente non sia già presente prima di aggiungerlo.
     * @param nuovoElemento Nuovo utente da inserire.
     * @throws UtenteDuplicatoException Se l'utente è già presente nell'archivio.
     */
    @Override
    public void inserisciNuovoElemento(Utente nuovoElemento) throws UtenteDuplicatoException {
        if (isElementoPresente(nuovoElemento))
            throw new UtenteDuplicatoException();
        archivioUtenti.add(nuovoElemento);
    }

    /**
     * @brief Verifica se un utente è già presente nell'archivio.
     * @param daCercare Utente da cercare.
     * @return true se l'utente è presente, false altrimenti.
     * @throws UtenteInvalidoException Se l'utente da cercare non è valido.
     */
    @Override
    public boolean isElementoPresente(Utente daCercare) {
        return archivioUtenti.stream().anyMatch(u -> u.getMatricola().equals(daCercare.getMatricola()));
    }

    /**
     * @brief Restituisce la lista degli utenti nell'archivio.
     * @return Lista osservabile degli utenti.
     */
    @Override
    public ObservableList<Utente> getListaElementi() {
        return this.archivioUtenti;
    }

    /**
     * @brief Registra una copia di un libro come prestata ad un utente.
     * @param noleggiatore Utente che prende in prestito il libro.
     * @param prestato Copia del libro prestata.
     */
    public void registraCopiaPrestata(Utente noleggiatore, Libro prestato) {
        for (Utente u : archivioUtenti) {
            if (u.equals(noleggiatore)) {
                u.prendiCopia(prestato);
            }
        }
    }

    /**
     * @brief Registra una copia di un libro come restituita da un utente.
     * @param noleggiatore Utente che restituisce il libro.
     * @param prestato Copia del libro restituita.
     */
    public void registraCopiaRestituita(Utente noleggiatore, Libro prestato) {
        for (Utente u : archivioUtenti) {
            if (u.equals(noleggiatore)) {
                u.restituisciCopia(prestato);
            }
        }
    }

    /**
     * @brief Aggiorna lo stato di visualizzazione della tabella utenti.
     * @details Ricarica la tabella per riflettere eventuali modifiche ai dati.
     */
    public void aggiornaStatoVisualizzazione() {
        tabellaUtenti.refresh();
    }

    /**
     * @brief Imposta il controller di registrazione prestiti.
     * @param crp Controller di registrazione prestiti.
     */
    public void setControlloreRegistrazionePrestiti(ControlloreRegPrestito crp) {
        this.crp = crp;
    }

    /**
     * @brief Imposta il controller di visualizzazione prestiti.
     * @param cvp Controller di visualizzazione prestiti.
     */
    public void setControlloreVisualizzazionePrestiti(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }

}
