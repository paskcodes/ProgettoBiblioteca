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

    ControlloreVisPrestiti cvp;

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
        if (utentePrePrestito == null || libroPrePrestito == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Seleziona Utente e Libro!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        if (libroPrePrestito.getCopie() <= 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Copie libro esaurite!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        if (utentePrePrestito.getNumPrestitiAttivi() >= 3) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Limite prestiti utente raggiunto!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        try {
            String dataStr = testoRegistraDataScadenzaPrestito.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataScadenza = LocalDate.parse(dataStr, formatter);

            if (!Prestito.isDataScadenzaValida(dataScadenza)) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Data scadenza non valida (deve essere futura)!",
                        ButtonType.OK);
                alert.showAndWait();
                return;
            }

            Prestito p = new Prestito(utentePrePrestito, libroPrePrestito, dataScadenza);
            cvp.inserisciNuovoElemento(p);

            if (cvp.getControlloreVisUtenti() != null) {
                cvp.getControlloreVisUtenti().registraCopiaPrestata(utentePrePrestito, libroPrePrestito);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Prestito registrato!", ButtonType.OK);
            alert.showAndWait();

        } catch (DateTimeParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Formato data errato (dd/MM/yyyy)!", ButtonType.OK);
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Errore nella registrazione: " + e.getMessage(),
                    ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void setUtentePrePrestito(Utente utenteDelPrestito) {
        // aggiorna l'utentePrePrestito con l'utente passato come paramentro e
        // visualizza il suo nome
        utentePrePrestito = utenteDelPrestito;
        selezioneRegistraUtentePrestito.setText(utenteDelPrestito.getMatricola());
    }

    public void setLibroPrePrestito(Libro libroDelPrestito) {
        libroPrePrestito = libroDelPrestito;
        selezioneRegistraLibroPrestito.setText(libroDelPrestito.getISBN());
    }

    public void setControlloreVisualizzazione(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }

}
