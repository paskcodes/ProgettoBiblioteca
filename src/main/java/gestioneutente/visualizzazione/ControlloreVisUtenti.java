/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente.visualizzazione;

import gestioneutente.Utente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Antonio Franco
 * 
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
    
    private ObservableList<Utente> listaUtenti; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void rimuoviUtente(ActionEvent event) {
    }    

    @FXML
    private void aggiornaNomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
    }

    @FXML
    private void aggiornaCognomeUtenti(TableColumn.CellEditEvent<Utente, String> event) {
    }

    @FXML
    private void aggiornaMailUtenti(TableColumn.CellEditEvent<Utente, String> event) {
    }

    @FXML
    private void aggiornaMatricolaUtenti(TableColumn.CellEditEvent<Utente, String> event) {
    }
    
    public ObservableList<Utente> getListaUtenti(){
        return this.listaUtenti;
    }
    
}
