package appbibliotecauniversitaria;

import gestionelibro.Libro;
import gestionelibro.registrazione.ControlloreRegLibro;
import gestionelibro.visualizzazione.ControlloreVisLibri;
import gestioneprestito.Prestito;
import gestioneprestito.registrazione.ControlloreRegPrestito;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.Utente;
import gestioneutente.registrazione.ControlloreRegUtente;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
        pannelloVisualizzazionePrestitiController.setControlloreVisUtenti(pannelloVisualizzazioneUtentiController);
        pannelloVisualizzazionePrestitiController.setControlloreVisLibri(pannelloVisualizzazioneLibriController);
                
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
        try {
            salvaUtenti();
            salvaLibri();
            salvaPrestiti();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Salvataggio completato");
            alert.setContentText("Archivio salvato con successo!");
            alert.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore Salvataggio");
            alert.setContentText("Errore durante il salvataggio: " + e.getMessage());
            alert.showAndWait();
        }
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
    
    private void salvaUtenti() throws IOException {
        FileWriter writer = new FileWriter("utenti.csv");
        writer.write("Nome;Cognome;Matricola;Email;Libri in Prestito\n");

        for (Utente u : pannelloVisualizzazioneUtentiController.getListaElementi()) {
            writer.write(u.getNome() + ";" + u.getCognome() + ";" +
                    u.getMatricola() + ";" + u.getMail() + ";" + u.getLibriInPrestito() +"\n");
        }
        writer.close();
    }

    private void salvaLibri() throws IOException {
        FileWriter writer = new FileWriter("libri.csv");
        writer.write("Titolo;Autori;DataPubblicazione;ISBN;Copie\n");

        for (Libro l : pannelloVisualizzazioneLibriController.getListaElementi()) {
            writer.write(l.getTitolo() + ";" + l.getAutori() + ";" +
                    l.getDataPubblicazione() + ";" + l.getISBN() + ";" +
                    l.getCopie() + "\n");
        }
        writer.close();
    }

    private void salvaPrestiti() throws IOException {
        FileWriter writer = new FileWriter("prestiti.csv");
        writer.write("UtenteMatricola;LibroISBN;DataScadenza;Stato\n");

        for (Prestito p : pannelloVisualizzazionePrestitiController.getListaElementi()) {
            writer.write(p.getUtente().getMatricola() + ";" +
                    p.getLibro().getISBN() + ";" +
                    p.getDataScadenza() + ";" +
                    p.determinaStato() + "\n");
        }
        writer.close();
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
