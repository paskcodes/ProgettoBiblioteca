package appbibliotecauniversitaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class BiblioManager
 * * @brief Classe principale dell'applicazione BiblioManager.
 * * Questa classe estende Application e gestisce l'avvio dell'applicazione JavaFX.
 * * @details La classe BiblioManager carica il file FXML che definisce l'interfaccia utente
 * * e imposta la scena principale dell'applicazione.
 */

public class BiblioManager extends Application {
    
    @Override
    /**
     * @brief Avvia l'applicazione JavaFX caricando la vista principale.
     * @param stage Stage principale fornito dal runtime JavaFX.
     * @throws Exception se il caricamento della risorsa FXML fallisce.
     */
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VistaFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("BiblioManager");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @brief Metodo main dell'applicazione.
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
