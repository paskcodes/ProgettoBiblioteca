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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    
   private ObservableList<Utente> archivioUtenti = FXCollections.observableArrayList();
    
    /**
     * @brief Inizializza il controller della vista utenti.
     * @param url URL di riferimento.
     * @param rb ResourceBundle di riferimento.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filtroRicercaUtenti.getItems().addAll("Cognome", "Matricola");
        filtroRicercaUtenti.setValue("Cognome");
        colonnaNomeTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getNome()));
        colonnaCognomeTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getCognome()));
        colonnaMailTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getMail()));
        colonnaMatricolaTabellaUtenti.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getMatricola()));
        colonnaCopiePrestitiTabellaUtente.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getLibriInPrestito().toString()));
        colonnaNomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaCognomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaMailTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        tabellaUtenti.setItems(archivioUtenti);
    }

    /**
     * @brief Aggiorna il nome dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaNomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        try{
            event.getRowValue().setNome(event.getNewValue());
        }catch(UtenteNomeCognomeException ex){
            ControlloreHome.mostraFinestraEccezione(ex);
        }
    }

    /**
     * @brief Aggiorna il cognome dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaCognomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        try{
            event.getRowValue().setCognome(event.getNewValue());
        }catch(UtenteNomeCognomeException ex){
            ControlloreHome.mostraFinestraEccezione(ex);
        }
    }

    /**
     * @brief Aggiorna la mail dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaMailUtenti(TableColumn.CellEditEvent<Utente, String> event) {
        try{
            event.getRowValue().setMail(event.getNewValue());
        }catch(UtenteMailException ex){
            ControlloreHome.mostraFinestraEccezione(ex);
        }
    }
    
    /**
     * @brief Rimuove l'utente selezionato dalla tabella/archivio.
     * @param event Evento di azione generato dal comando di rimozione.
     */
    @FXML
    private void rimuoviUtente(ActionEvent event) throws UtenteInvalidoException{
        Utente daEliminare = tabellaUtenti.getSelectionModel().getSelectedItem();
        if(cvp.inPrestitoAttivoUtente(daEliminare)) throw new UtentePrestitoAttivoException();
        archivioUtenti.remove(daEliminare);
    }    
    
    /**
     * @brief Esegue la ricerca degli utenti in base al filtro selezionato.
     * @param event Evento di tastiera generato dal campo di ricerca.
     */
    @FXML
    private void ricercaUtenti(KeyEvent event) {
    }
    
    /**
     * @brief Gestisce la selezione di un utente nella tabella.
     * @param event Evento di click del mouse sulla tabella.
     */
    @FXML
    private void selezionaUtente(MouseEvent event) {
        crp.setUtentePrePrestito(tabellaUtenti.getSelectionModel().getSelectedItem());
    }

    @Override
    public void inserisciNuovoElemento(Utente nuovoElemento) throws UtenteDuplicatoException {
        if(isElementoPresente(nuovoElemento) == true) throw new UtenteDuplicatoException();
        archivioUtenti.add(nuovoElemento);
        FXCollections.sort(archivioUtenti, new ComparatoreCognomeNomeUtente());
        System.out.println("AGGIUNTO");
    }

    @Override
    public boolean isElementoPresente(Utente daCercare) {
        return archivioUtenti.stream().anyMatch(u -> u.getMatricola().equals(daCercare.getMatricola()));
    }

    @Override
    public ObservableList<Utente> getListaElementi() {
        return this.archivioUtenti;
    }
    
    public void registraCopiaPrestata(Utente noleggiatore, Libro prestato){
        for(Utente u : archivioUtenti){
            if(u.equals(u)){
                u.setNumPrestitiAttivi((u.getNumPrestitiAttivi())+1);
                u.prendiCopia(prestato);
            }
        }
    }
    
    public void registraCopiaRestituita(Utente noleggiatore, Libro prestato){
        for(Utente u : archivioUtenti){
            if(u.equals(u)){
                u.setNumPrestitiAttivi((u.getNumPrestitiAttivi())-1);
                u.restituisciCopia(prestato);
            }
        }
    }
    
    public void setControlloreRegistrazionePrestiti(ControlloreRegPrestito crp){
        this.crp = crp;
    }
    
    
    public void setControlloreVisualizzazionePrestiti(ControlloreVisPrestiti cvp){
        this.cvp = cvp;
    }

}
