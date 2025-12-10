package gestioneutente.registrazione;

import appbibliotecauniversitaria.Archivio;
import appbibliotecauniversitaria.ControlloreHome;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    

    /**
     * @brief Inizializza il controller della scena di registrazione utente
     * @param url L'URL della risorsa
     * @param rb Il ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo utente
     * @param event L'evento generato dal click sul bottone di registrazione
     */
    @FXML
    private void registraUtente(ActionEvent event){
        Utente u = new Utente(testoRegistraNomeUtente.getText(), testoRegistraCognomeUtente.getText(), testoRegistraMailUtente.getText(), testoRegistraMatricolaUtente.getText());
        
        try{
            Archivio.inserisciNuovoUtente(u);
        }catch(UtenteInvalidoException ex){                        //mettere solo la super classe eccezione o specificare ogni tipo di eccezione?
            ControlloreHome.mostraFinestraEccezione(ex);
        }
        
    }
    
}
