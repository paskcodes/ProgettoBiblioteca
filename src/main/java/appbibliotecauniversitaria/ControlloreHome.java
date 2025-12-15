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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * @class ControlloreHome
 * @brief Controller per la schermata principale dell'applicazione della biblioteca universitaria.
 * Gestisce la visualizzazione e l'interazione con i pannelli di registrazione e visualizzazione
 * di utenti, libri e prestiti.
 */
public class ControlloreHome implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pannelloRegistrazioneUtenteController.setControlloreVisualizzazione(pannelloVisualizzazioneUtentiController);
        pannelloRegistrazioneLibroController.setControlloreVisualizzazione(pannelloVisualizzazioneLibriController);
        pannelloRegistrazionePrestitoController.setControlloreVisualizzazione(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazioneUtentiController.setControlloreRegistrazionePrestiti(pannelloRegistrazionePrestitoController);
        pannelloVisualizzazioneLibriController.setControlloreRegistrazionePrestiti(pannelloRegistrazionePrestitoController);
        pannelloVisualizzazioneUtentiController.setControlloreVisualizzazionePrestiti(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazioneLibriController.setControlloreVisualizzazionePrestiti(pannelloVisualizzazionePrestitiController);

        mostraPannello(pannelloRegistrazioneUtente, pannelliRegistrazione.getChildren());
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());


    }

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

    @FXML
    private void visualizzaRegistrazioneUtente(ActionEvent event) {
        mostraPannello(pannelloRegistrazioneUtente, pannelliRegistrazione.getChildren());
    }

    @FXML
    private void visualizzaRegistrazioneLibro(ActionEvent event) {
        mostraPannello(pannelloRegistrazioneLibro, pannelliRegistrazione.getChildren());
    }

    @FXML
    private void visualizzaRegistrazionePrestito(ActionEvent event) {
        mostraPannello(pannelloRegistrazionePrestito, pannelliRegistrazione.getChildren());
    }

    @FXML
    private void visualizzaListaUtenti(ActionEvent event) {
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());
    }

    @FXML
    private void visualizzaListaLibri(ActionEvent event) {
        mostraPannello(pannelloVisualizzazioneLibri, pannelliVisualizzazione.getChildren());
    }

    @FXML
    private void visualizzaListaPrestiti(ActionEvent event) {
        mostraPannello(pannelloVisualizzazionePrestiti, pannelliVisualizzazione.getChildren());
    }

    public static void mostraFinestraEccezione(Exception ex) {
    }

    private void mostraPannello(AnchorPane pannelloDaMostrare, List<Node> pannelliDaNascondere) {
        for (Node p : pannelliDaNascondere) {
            p.setVisible(false);
        }
        pannelloDaMostrare.setVisible(true);
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

}