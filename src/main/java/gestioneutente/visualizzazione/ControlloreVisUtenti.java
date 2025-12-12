/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.visualizzazione;

import appbibliotecauniversitaria.Archivio;
import appbibliotecauniversitaria.ControlloreHome;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteNomeCognomeException;
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
public class ControlloreVisUtenti implements Initializable {

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
    private TableColumn<Utente, ObservableList<String>> colonnaCopiePrestitiTabellaUtente;
    @FXML
    private TextField testoRicercaUtenti;
    @FXML
    private ChoiceBox<String> filtroRicercaUtenti;
    

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
        //colonnaNomeTabellaUtenti.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colonnaNomeTabellaUtenti.setCellFactory(TextFieldTableCell.forTableColumn());
        tabellaUtenti.setItems(Archivio.getListaUtenti());
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
    }

    /**
     * @brief Aggiorna la mail dell'utente selezionato.
     * @param event Evento di modifica cella con il nuovo valore.
     */
    @FXML
    private void aggiornaMailUtenti(TableColumn.CellEditEvent<Utente, String> event) {
    }
    
    /**
     * @brief Rimuove l'utente selezionato dalla tabella/archivio.
     * @param event Evento di azione generato dal comando di rimozione.
     */
    @FXML
    private void rimuoviUtente(ActionEvent event) {
        
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
    }

    
}
