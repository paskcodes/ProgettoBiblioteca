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
 * @class ControlloreRegPrestito
 * @brief Controller della schermata di registrazione di un prestito
 */
public class ControlloreRegPrestito implements Initializable {
    /**
     * \cond DOXY_SKIP
     */
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
     * \endcond
     */

    /**
     * @brief Inizializza il controller della schermata di registrazione di un prestito
     * @param url L'URL della risorsa
     * @param rb Il ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * @brief Gestisce l'evento di registrazione di un prestito
     * @param event L'evento generato dal click sul bottone di registrazione
     */
    @FXML
    private void registraPrestito(ActionEvent event) {
    }
    
}
