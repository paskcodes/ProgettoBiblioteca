/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro.visualizzazione;

import gestionelibro.Libro;
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

/**
 * FXML Controller class
 *
 * @author Antonio Franco
 * 
 */
public class ControlloreVisLibri implements Initializable {

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
    
    private ObservableList<Libro> listaLibri;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void rimuoviLibro(ActionEvent event) {
    }    

    @FXML
    private void aggiornaTitoloLibri(TableColumn.CellEditEvent<Libro, String> event) {
    }

    @FXML
    private void aggiornaAutoriLibri(TableColumn.CellEditEvent<Libro, String> event) {
    }

    @FXML
    private void aggiornaDataPubblicazioneLibri(TableColumn.CellEditEvent<Libro, LocalDate> event) {
    }

    @FXML
    private void aggiornaISBNLibri(TableColumn.CellEditEvent<Libro, String> event) {
    }

    @FXML
    private void aggiornaNumCopieLibri(TableColumn.CellEditEvent<Libro, Integer> event) {
    }
    
    public ObservableList<Libro> getListaLibri(){
        return this.listaLibri;
    }
    
}
