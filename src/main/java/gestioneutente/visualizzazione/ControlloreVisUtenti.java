/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.visualizzazione;

import gestionearchivio.Archiviabile;
import appbibliotecauniversitaria.ControlloreHome;
import gestioneutente.Utente;
import gestionelibro.Libro;
import gestioneprestito.registrazione.ControlloreRegPrestito;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.ComparatoreCognomeNomeUtente;
import gestioneutente.eccezioni.UtenteDuplicatoException;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.eccezioni.UtenteMailException;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
import gestioneutente.eccezioni.UtentePrestitoAttivoException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

/**
 * @class ControlloreVisUtenti
 * @brief Controller FXML per la visualizzazione e gestione degli utenti.
 * @details Gestisce tabella, filtri di ricerca e operazioni di modifica/rimozione utenti.
 * @author Antonio Franco
 */
public class ControlloreVisUtenti implements Initializable, Archiviabile<Utente, UtenteInvalidoException>{

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
   
   private final SortedList<Utente> archivioUtentiOrdinato = new SortedList<>(archivioUtenti, new ComparatoreCognomeNomeUtente());
   
   private final FilteredList<Utente> archivioUtentiFiltrato = new FilteredList<>(archivioUtentiOrdinato);
    
    /**
     * @brief Inizializza il controller della vista utenti.
     * @param url URL di riferimento.
     * @param rb ResourceBundle di riferimento.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //aggiunge i filtri possibili
        filtroRicercaUtenti.getItems().addAll("Cognome", "Matricola");
        
        //imposta un filtro di default
        filtroRicercaUtenti.setValue("Cognome");
        
        //permette di visualizzare il valore di ogni campo dell'utente nella rispettiva colonna
        colonnaNomeTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getNome()));
        colonnaCognomeTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getCognome()));
        colonnaMailTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getMail()));
        colonnaMatricolaTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getMatricola()));
        colonnaCopiePrestitiTabellaUtente.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getLibriInPrestito().toString()));
        
        //permette di modificare il valore della cella nella tabella
        colonnaNomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaCognomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaMailTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaCopiePrestitiTabellaUtente.setCellFactory(cell ->{
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

                        // Imposta il nodo grafico
                        setGraphic(nodoTesto);
                    }
                }
            };
        });
        
        
        //imposta l'archivioUtentiFiltrato come lista osservabile da cui prendere i dati
        tabellaUtenti.setItems(archivioUtentiFiltrato);
    }

    /**
     * @brief Aggiorna il nome dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaNomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        //modifica il campo nome dell'elemento all'interno dell'archivioUtenti, corrispondente a quella riga nella tabella, con il testo inserito a mano per la modifica
        try{
            event.getRowValue().setNome(event.getNewValue());
        }catch(UtenteNomeCognomeException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna il cognome dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaCognomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        //modifica il campo cognome dell'elemento all'interno dell'archivioUtenti, corrispondente a quella riga nella tabella, con il testo inserito a mano per la modifica
        try{
            event.getRowValue().setCognome(event.getNewValue());
        }catch(UtenteNomeCognomeException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
    }

    /**
     * @brief Aggiorna la mail dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaMailUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        //modifica il campo mail dell'elemento all'interno dell'archivioUtenti, corrispondente a quella riga nella tabella, con il testo inserito a mano per la modifica
        try{
            event.getRowValue().setMail(event.getNewValue());
        }catch(UtenteMailException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
        
        //aggiorna la visualizzazione della tabella nella pagina
        aggiornaStatoVisualizzazione();
    }
    
    /**
     * @brief Rimuove l'utente selezionato dalla tabella/archivio.
     * @param event Evento di azione generato dal comando di rimozione.
     */
    @FXML
    private void rimuoviUtente(ActionEvent event) {
        //mantiene il riferimento all'utente selezionato
        Utente daEliminare = tabellaUtenti.getSelectionModel().getSelectedItem();
        
        //verifica che non abbia prestiti attivi e rimuove l'utente, altrimenti cattura un eccezione
        try{
            cvp.inPrestitoAttivoUtente(daEliminare);
            archivioUtenti.remove(daEliminare);
        }catch(UtenteInvalidoException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }

        //aggiorna il valore di utentePrePrestito
        crp.resetUtentePrePrestito();
    }    
    
    /**
     * @brief Esegue la ricerca degli utenti in base al filtro selezionato.
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
                    return u.getCognome().toLowerCase().contains(filtro.toLowerCase());  //si usa contains perche' deve verificare che il filtro sia presente nell'elemento discriminante
                } else if (tipo.equals("Matricola")) {
                    return u.getMatricola().contains(filtro);
                }
                return false;
            });
        }
        //archivioUtenti.sort(new ComparatoreCognomeNomeUtente());
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

    @Override
    public void inserisciNuovoElemento(Utente nuovoElemento) throws UtenteDuplicatoException {
        //se l'utente è già presente allora lancia un'eccezione
        if(isElementoPresente(nuovoElemento)) throw new UtenteDuplicatoException();
        archivioUtenti.add(nuovoElemento);
        
        //altrimenti aggiunge l'elemento all'archivioUtenti
        //FXCollections.sort(archivioUtenti, new ComparatoreCognomeNomeUtente()); ////////////////////////////////////// forse va tolto
    }

    @Override
    public boolean isElementoPresente(Utente daCercare) {
        //verifica che in archivioUtenti ci sia l'utente daCercare
        return archivioUtenti.stream().anyMatch(u -> u.getMatricola().equals(daCercare.getMatricola()));
    }

    @Override
    public ObservableList<Utente> getListaElementi() {
        //ritorna l'archivioUtenti
        return this.archivioUtenti;
    }
    
    public void registraCopiaPrestata(Utente noleggiatore, Libro prestato){
        for(Utente u : archivioUtenti){
            if(u.equals(noleggiatore)){
                u.prendiCopia(prestato);
            }
        }
    }
    
    public void registraCopiaRestituita(Utente noleggiatore, Libro prestato){
        for(Utente u : archivioUtenti){
            if(u.equals(noleggiatore)){
                u.restituisciCopia(prestato);
            }
        }
    }
    
    public void aggiornaStatoVisualizzazione(){
        tabellaUtenti.refresh();
    }
    
    public void setControlloreRegistrazionePrestiti(ControlloreRegPrestito crp){
        this.crp = crp;
    }
    
    
    public void setControlloreVisualizzazionePrestiti(ControlloreVisPrestiti cvp){
        this.cvp = cvp;
    }

}
