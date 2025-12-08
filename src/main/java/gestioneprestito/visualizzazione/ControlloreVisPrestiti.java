/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito.visualizzazione;

import gestioneprestito.Prestito;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Franco
 */
public class ControlloreVisPrestiti implements Initializable {

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
    @FXML
    private TextField testoRicercaPrestiti;
    @FXML
    private ChoiceBox<String> filtroRicercaPrestiti;
    
    private ObservableList<Prestito> listaPrestiti; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void estinguiPrestito(ActionEvent event) {
    }
    
    
    public void inserisciNuovoPrestito(Prestito prestito){
    }
    
    public boolean isPrestitoEsistente(Prestito prestito){
        return true;
    }
    
}
