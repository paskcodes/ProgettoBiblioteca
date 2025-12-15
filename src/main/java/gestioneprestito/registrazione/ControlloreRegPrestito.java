package gestioneprestito.registrazione;

import gestionelibro.Libro;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.Utente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import gestioneprestito.Prestito;
import gestioneprestito.eccezioni.PrestitoInvalidoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

    private ControlloreVisPrestiti cvp;

    private Utente utentePrePrestito;

    private Libro libroPrePrestito;

    /**
     * @brief Inizializza il controller della schermata di registrazione di un
     *        prestito
     * @param url L'URL della risorsa
     * @param rb  Il ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * @brief Gestisce l'evento di registrazione di un prestito
     * @param event L'evento generato dal click sul bottone di registrazione
     */
    @FXML
    private void registraPrestito(ActionEvent event) {
        try{
            Prestito u = new Prestito(utentePrePrestito, libroPrePrestito, LocalDate.parse(testoRegistraDataScadenzaPrestito.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cvp.inserisciNuovoElemento(u);
        }catch(PrestitoInvalidoException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
    }

    public void setUtentePrePrestito(Utente utenteDelPrestito) {
        // aggiorna l'utentePrePrestito con l'utente passato come paramentro e
        // visualizza il suo nome
        utentePrePrestito = utenteDelPrestito;
        selezioneRegistraUtentePrestito.setText(utenteDelPrestito.getMatricola());
    }

    public void setLibroPrePrestito(Libro libroDelPrestito) {
        // aggiorna il libroPrePrestito con il libro passato come paramentro e
        // visualizza il suo nome
        libroPrePrestito = libroDelPrestito;
        selezioneRegistraLibroPrestito.setText(libroDelPrestito.getISBN());
    }
    
    public void resetUtentePrePrestito() {
        // resetta il valore di utentePrePrestito
        utentePrePrestito = null;
    }
    
    public void resetLibroPrePrestito() {
        // resetta il valore di libroPrePrestito
        libroPrePrestito = null;
    }

    public void setControlloreVisualizzazione(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }

}
