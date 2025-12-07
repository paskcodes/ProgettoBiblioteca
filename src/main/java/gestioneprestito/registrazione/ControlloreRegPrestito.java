/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprestito.registrazione;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Franco
 */
public class ControlloreRegPrestito implements Initializable {

    @FXML
    private AnchorPane pannelloRegPrestito;
    @FXML
    private Label selezioneRegistraUtentePrestito;
    @FXML
    private Label selezioneRegistraLibroPrestito;
    @FXML
    private TextField testoRegistraDataScadenzaPrestito;
    @FXML
    private Button bottoneAggiungiPrestito;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registraPrestito(ActionEvent event) {
    }
    
}
