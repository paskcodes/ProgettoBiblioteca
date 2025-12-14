package appbibliotecauniversitaria;

import gestionelibro.registrazione.ControlloreRegLibro;
import gestionelibro.visualizzazione.ControlloreVisLibri;
import gestioneprestito.registrazione.ControlloreRegPrestito;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.registrazione.ControlloreRegUtente;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * @class ControlloreHome
 * @brief Controller per la schermata principale dell'applicazione della biblioteca universitaria.
 * Gestisce la visualizzazione e l'interazione con i pannelli di registrazione e visualizzazione
 * di utenti, libri e prestiti.
 */
public class ControlloreHome implements Initializable {

    /** 
     * \cond DOXY_SKIP 
     */   
    @FXML
    private AnchorPane pannelloRegistrazioneUtente;
    @FXML
    private AnchorPane pannelloVisualizzazioneUtenti;
    @FXML
    private AnchorPane pannelloRegistrazioneLibro;
    @FXML
    private AnchorPane pannelloVisualizzazioneLibri;
    @FXML
    private AnchorPane pannelloRegistrazionePrestito;
    @FXML
    private AnchorPane pannelloVisualizzazionePrestiti;
    @FXML
    private StackPane pannelliRegistrazione;
    @FXML
    private StackPane pannelliVisualizzazione;
    
    @FXML 
    private ControlloreRegUtente pannelloRegistrazioneUtenteController;
    
    @FXML 
    private ControlloreVisUtenti pannelloVisualizzazioneUtentiController;
    
    @FXML 
    private ControlloreRegLibro pannelloRegistrazioneLibroController;
    
    @FXML 
    private ControlloreVisLibri pannelloVisualizzazioneLibriController;
    
    @FXML 
    private ControlloreRegPrestito pannelloRegistrazionePrestitoController;
    
    @FXML 
    private ControlloreVisPrestiti pannelloVisualizzazionePrestitiController;

    /** \endcond */
    
    /**
     * @brief Inizializza il controller della schermata principale.
     * Imposta la visibilità iniziale dei pannelli.
     * @param url L'URL di riferimento.
     * @param rb Il ResourceBundle di riferimento.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //stabilisce i collegamenti tra i controllori
        pannelloRegistrazioneUtenteController.setControlloreVisualizzazione(pannelloVisualizzazioneUtentiController);
        pannelloRegistrazioneLibroController.setControlloreVisualizzazione(pannelloVisualizzazioneLibriController);
        pannelloRegistrazionePrestitoController.setControlloreVisualizzazione(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazioneUtentiController.setControlloreRegistrazionePrestiti(pannelloRegistrazionePrestitoController);
        pannelloVisualizzazioneLibriController.setControlloreRegistrazionePrestiti(pannelloRegistrazionePrestitoController);
        pannelloVisualizzazioneUtentiController.setControlloreVisualizzazionePrestiti(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazioneLibriController.setControlloreVisualizzazionePrestiti(pannelloVisualizzazionePrestitiController);
        
        //mostra le schermate di registrazione utente e visualizzazione utenti di default
        mostraPannello(pannelloRegistrazioneUtente, pannelliRegistrazione.getChildren());
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());
    }    

    /**
     * @brief Salva l'archivio dei dati.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void salvaArchivio(ActionEvent event) {
    }

    /**
     * @brief Visualizza il pannello di registrazione utente.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaRegistrazioneUtente(ActionEvent event) {
        //mostra il pannello registrazione utente e nasconde gli altri pannelli registrazione
        mostraPannello(pannelloRegistrazioneUtente, pannelliRegistrazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di registrazione libro.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaRegistrazioneLibro(ActionEvent event) {
        //mostra il pannello registrazione libro e nasconde gli altri pannelli registrazione
        mostraPannello(pannelloRegistrazioneLibro, pannelliRegistrazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di registrazione prestito.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaRegistrazionePrestito(ActionEvent event) {
        //mostra il pannello registrazione prestito e nasconde gli altri pannelli registrazione
        mostraPannello(pannelloRegistrazionePrestito, pannelliRegistrazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di visualizzazione utenti.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaListaUtenti(ActionEvent event) {
        //mostra il pannello visualizzazione utenti e nasconde gli altri pannelli registrazione
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di visualizzazione libri.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaListaLibri(ActionEvent event) {
        //mostra il pannello visualizzazione libri e nasconde gli altri pannelli registrazione
        mostraPannello(pannelloVisualizzazioneLibri, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di visualizzazione prestiti.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaListaPrestiti(ActionEvent event) {
        //mostra il pannello visualizzazione prestiti e nasconde gli altri pannelli registrazione
        mostraPannello(pannelloVisualizzazionePrestiti, pannelliVisualizzazione.getChildren());
    }
    
    /**
     * @brief Mostra una finestra di eccezione con il messaggio dell'eccezione.
     * @param ex L'eccezione da mostrare.
     */
    public static void mostraFinestraEccezione(Exception ex){
    }
    
    /**
     * @brief Mostra un pannello e nasconde gli altri pannelli specificati.
     * @param pannelloDaMostrare Il pannello da mostrare.
     * @param pannelliDaNascondere La lista dei pannelli da nascondere.
     */
    private void mostraPannello(AnchorPane pannelloDaMostrare, List<Node> pannelliDaNascondere){
        //nasconde tutti i pannelli
        for(Node p : pannelliDaNascondere){
            p.setVisible(false);
        }
        
        //mostra l'unico da visualizzare
        pannelloDaMostrare.setVisible(true);
    }

    
}
