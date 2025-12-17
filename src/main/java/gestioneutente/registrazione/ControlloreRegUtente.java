package gestioneutente.registrazione;

import appbibliotecauniversitaria.FinestraEccezione;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtenteInvalidoException;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @class ControlloreRegUtente
 * @brief Classe controller per la registrazione di un nuovo utente
 */
public class ControlloreRegUtente {

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

    private ControlloreVisUtenti cvu;

    /**
     * \endcond
     */

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo utente
     * @param event L'evento generato dal click sul bottone di registrazione
     * @throws UtenteInvalidoException Se i dati dell'utente non sono validi
     */
    @FXML
    private void registraUtente(ActionEvent event) {
        try {
            Utente u = new Utente(testoRegistraNomeUtente.getText(), testoRegistraCognomeUtente.getText(),
                    testoRegistraMailUtente.getText(), testoRegistraMatricolaUtente.getText());
            cvu.inserisciNuovoElemento(u);

            testoRegistraNomeUtente.clear();
            testoRegistraCognomeUtente.clear();
            testoRegistraMailUtente.clear();
            testoRegistraMatricolaUtente.clear();
        }catch(UtenteInvalidoException ex){
            FinestraEccezione fc = new FinestraEccezione(ex.getMessage());
        }
        
    }

    /**
     * @brief Imposta il controller di visualizzazione utenti
     * @param cvu Il controller di visualizzazione utenti
     */
    public void setControlloreVisualizzazione(ControlloreVisUtenti cvu) {
        this.cvu = cvu;
    }

}
