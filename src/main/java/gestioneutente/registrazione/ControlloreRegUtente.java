package gestioneutente.registrazione;

import appbibliotecauniversitaria.ControlloreHome;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteDuplicatoException;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * @class ControlloreRegUtente
 * @brief Classe controller per la registrazione di un nuovo utente
 */
public class ControlloreRegUtente implements Initializable {

    /**
     * \cond DOXY_SKIP
     */
    @FXML
    private TextField testoRegistraNomeUtente;
    @FXML
    private TextField testoRegistraCognomeUtente;
    @FXML
    private TextField testoRegistraMailUtente;
    @FXML
    private TextField testoRegistraMatricolaUtente;
    @FXML
    private Button bottoneAggiungiUtente;
    @FXML
    private AnchorPane pannelloRegUtente;
    /**
     * \endcond
     */
    
    private ControlloreVisUtenti cvu;

    /**
     * @brief Inizializza il controller della scena di registrazione utente
     * @param url L'URL della risorsa
     * @param rb Il ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo utente
     * @param event L'evento generato dal click sul bottone di registrazione
     */
    @FXML
    private void registraUtente(ActionEvent event){
        try{
            Utente u = new Utente(testoRegistraNomeUtente.getText(), testoRegistraCognomeUtente.getText(), testoRegistraMailUtente.getText(), testoRegistraMatricolaUtente.getText());
            cvu.inserisciNuovoElemento(u);
            testoRegistraNomeUtente.clear();
            testoRegistraCognomeUtente.clear();
            testoRegistraMailUtente.clear();
            testoRegistraMatricolaUtente.clear();
        }catch(UtenteInvalidoException ex){
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        }
                
    }
    
    public void setControlloreVisualizzazione(ControlloreVisUtenti cvu){
        this.cvu = cvu;
    }
}
