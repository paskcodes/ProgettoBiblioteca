/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionelibro.registrazione;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;

/**
 * FXML Controller class
 *
 * @author Antonio Franco
 * 
 */
public class ControlloreRegLibro implements Initializable {

    @FXML
    private AnchorPane pannelloRegLibro;
    @FXML
    private TextField testoRegistraLibroTitolo;
    @FXML
    private TextField testoRegistraAutoriLibro;
    @FXML
    private TextField testoRegistraDataPubblicazioneLibro;
    @FXML
    private TextField testoRegistraISBNLibro;
    @FXML
    private TextField testoRegistraNumCopieLibro;
    @FXML
    private Button bottoneAggiungiLibro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registraLibro(ActionEvent event) {
    }
    
}
