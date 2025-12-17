/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecauniversitaria;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Antonio Franco
 */
public class FinestraEccezione {

    public FinestraEccezione(String messaggio) {
        Alert a = new Alert(Alert.AlertType.WARNING, messaggio, ButtonType.CLOSE);
        a.showAndWait();
    }
    
}
