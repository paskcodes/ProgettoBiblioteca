package gestionelibro.registrazione;

import gestionelibro.visualizzazione.ControlloreVisLibri;
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
 * @class ControlloreRegLibro
 * @brief Classe controller per la registrazione di un nuovo libro.
 * 
 */
public class ControlloreRegLibro implements Initializable {
    /**
     * \cond Doxygen_Skip
     */
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
     * \endcond
     */
    
    private ControlloreVisLibri cvl;
    
    /**
     * @brief Inizializza il controller della scena di registrazione del libro.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo libro.
     * @param event L'evento generato dal click sul bottone di registrazione.
     */
    @FXML
    private void registraLibro(ActionEvent event) {
    }
    
    public void setControlloreVisualizzazione(ControlloreVisLibri cvl){
        this.cvl = cvl;
    }
    
}
