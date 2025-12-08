/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecauniversitaria;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Franco
 * 
 */
public class ControlloreHome implements Initializable {
    
    @FXML
    private AnchorPane pannelloRegistrazioneUtente;
    @FXML
    private AnchorPane pannelloVisualizzazioneUtenti;
    @FXML
    private AnchorPane pannelloRegistrazioneLibro;
    @FXML
    private AnchorPane pannelloVisualizzazioneLibri;
    @FXML
    private AnchorPane pannelloRegistrazionePrestito;
    @FXML
    private AnchorPane pannelloVisualizzazionePrestiti;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pannelloRegistrazioneUtente.setVisible(true);
        pannelloVisualizzazioneUtenti.setVisible(true);
        pannelloRegistrazioneLibro.setVisible(false);
        pannelloVisualizzazioneLibri.setVisible(false);
        pannelloRegistrazionePrestito.setVisible(false);
        pannelloVisualizzazionePrestiti.setVisible(false);
    }    

    @FXML
    private void salvaArchivio(ActionEvent event) {
    }

    @FXML
    private void visualizzaRegistrazioneUtente(ActionEvent event) {
    }

    @FXML
    private void visualizzaRegistrazioneLibro(ActionEvent event) {
    }

    @FXML
    private void visualizzaRegistrazionePrestito(ActionEvent event) {
    }

    @FXML
    private void visualizzaListaUtenti(ActionEvent event) {
    }

    @FXML
    private void visualizzaListaLibri(ActionEvent event) {
    }

    @FXML
    private void visualizzaListaPrestiti(ActionEvent event) {
    }
    
    public void mostraFinestraEccezione(Exception ex){
    }

    
}
