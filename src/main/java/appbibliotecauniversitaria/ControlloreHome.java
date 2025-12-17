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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 * @brief Controller per la schermata principale dell'applicazione della
 *        biblioteca universitaria.
 * @details Gestisce la visualizzazione e l'interazione con i pannelli di
 *          registrazione e visualizzazione
 *          di utenti, libri e prestiti.
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
     *        Imposta la visibilità iniziale dei pannelli.
     * @details Collega i controller dei pannelli di registrazione e
     *          visualizzazione tra loro per consentire l'interazione.
     * @param url L'URL di riferimento.
     * @param rb  Il ResourceBundle di riferimento.
     * @throws IOException Se si verifica un errore durante l'inizializzazione.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pannelloRegistrazioneUtenteController.setControlloreVisualizzazione(pannelloVisualizzazioneUtentiController);
        pannelloRegistrazioneLibroController.setControlloreVisualizzazione(pannelloVisualizzazioneLibriController);
        pannelloRegistrazionePrestitoController.setControlloreVisualizzazione(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazioneUtentiController.setControlloreRegistrazionePrestiti(pannelloRegistrazionePrestitoController);
        pannelloVisualizzazioneLibriController.setControlloreRegistrazionePrestiti(pannelloRegistrazionePrestitoController);
        pannelloVisualizzazioneUtentiController.setControlloreVisualizzazionePrestiti(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazioneLibriController.setControlloreVisualizzazionePrestiti(pannelloVisualizzazionePrestitiController);
        pannelloVisualizzazionePrestitiController.setControlloreVisUtenti(pannelloVisualizzazioneUtentiController);
        pannelloVisualizzazionePrestitiController.setControlloreVisLibri(pannelloVisualizzazioneLibriController);

        caricaUtenti();
        caricaLibri();
        caricaPrestiti();

        mostraPannello(pannelloRegistrazioneUtente, pannelliRegistrazione.getChildren());
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Salva l'archivio dei dati.
     * @param event L'evento di azione generato dal click sul menu.
     * @throws IOException Se si verifica un errore durante il salvataggio.
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
        mostraPannello(pannelloRegistrazioneUtente, pannelliRegistrazione.getChildren());
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di registrazione libro.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaRegistrazioneLibro(ActionEvent event) {
        mostraPannello(pannelloRegistrazioneLibro, pannelliRegistrazione.getChildren());
        mostraPannello(pannelloVisualizzazioneLibri, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di registrazione prestito.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaRegistrazionePrestito(ActionEvent event) {
        mostraPannello(pannelloRegistrazionePrestito, pannelliRegistrazione.getChildren());
        mostraPannello(pannelloVisualizzazionePrestiti, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di visualizzazione utenti.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaListaUtenti(ActionEvent event) {
        mostraPannello(pannelloVisualizzazioneUtenti, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di visualizzazione libri.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaListaLibri(ActionEvent event) {
        mostraPannello(pannelloVisualizzazioneLibri, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Visualizza il pannello di visualizzazione prestiti.
     * @param event L'evento di azione generato dal click sul menu.
     */
    @FXML
    private void visualizzaListaPrestiti(ActionEvent event) {
        mostraPannello(pannelloVisualizzazionePrestiti, pannelliVisualizzazione.getChildren());
    }

    /**
     * @brief Salva gli utenti su file CSV
     * @throws IOException Se si verifica un errore durante la scrittura del file.
     */
    private void salvaUtenti() throws IOException {
        FileWriter writer = new FileWriter("utenti.csv");
        writer.write("Nome;Cognome;Matricola;Email;Libri in Prestito\n");

        for (Utente u : pannelloVisualizzazioneUtentiController.getListaElementi()) {
            writer.write(u.getNome() + ";" + u.getCognome() + ";" +
                    u.getMatricola() + ";" + u.getMail() + ";" + u.getLibriInPrestito() + "\n");
        }
        writer.close();
    }

    /**
     * @brief Salva i libri su file CSV
     * @throws IOException Se si verifica un errore durante la scrittura del file.
     */
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

    /**
     * @brief Salva i prestiti su file CSV
     * @throws IOException Se si verifica un errore durante la scrittura del file.
     */
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
     * @param pannelloDaMostrare   Il pannello da mostrare.
     * @param pannelliDaNascondere La lista dei pannelli da nascondere.
     */
    private void mostraPannello(AnchorPane pannelloDaMostrare, List<Node> pannelliDaNascondere) {
        for (Node p : pannelliDaNascondere) {
            p.setVisible(false);
        }

        pannelloDaMostrare.setVisible(true);
    }

    /**
     * @brief Carica gli utenti da file CSV
     * @details Ignora righe con errori di validazione o duplicati.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     */
    private void caricaUtenti() {
        try (BufferedReader reader = new BufferedReader(new FileReader("utenti.csv"))) {
            String line = reader.readLine(); // Salta header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String nome = parts[0];
                    String cognome = parts[1];
                    String matricola = parts[2];
                    String email = parts[3];
                    try {
                        Utente utente = new Utente(nome, cognome, email, matricola);
                        pannelloVisualizzazioneUtentiController.inserisciNuovoElemento(utente);
                    } catch (Exception e) {
                        System.out.println("Utente non inserito: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Errore lettura utenti.csv: " + e.getMessage());
        }
    }

    /**
     * @brief Carica i libri da file CSV
     * @details Ignora righe con errori di validazione o duplicati.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     */
    private void caricaLibri() {
        try (BufferedReader reader = new BufferedReader(new FileReader("libri.csv"))) {
            String line = reader.readLine(); // Salta header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String titolo = parts[0];
                    String autori = parts[1];
                    LocalDate dataPubblicazione = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String isbn = parts[3];
                    int copie = Integer.parseInt(parts[4]);
                    try {
                        Libro libro = new Libro(titolo, autori, dataPubblicazione, isbn, copie);
                        pannelloVisualizzazioneLibriController.inserisciNuovoElemento(libro);
                    } catch (Exception e) {
                        System.out.println("Libro non inserito: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Errore lettura libri.csv: " + e.getMessage());
        }
    }

    /**
     * @brief Carica i prestiti da file CSV
     * @details Ignora righe con errori di validazione o riferimenti non trovati.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     */
    private void caricaPrestiti() {
        try (BufferedReader reader = new BufferedReader(new FileReader("prestiti.csv"))) {
            String line = reader.readLine(); // Salta header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String matricola = parts[0];
                    String isbn = parts[1];
                    LocalDate dataScadenza = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    // Stato ignorato per ora
                    Utente utente = pannelloVisualizzazioneUtentiController.getListaElementi().stream()
                            .filter(u -> u.getMatricola().equals(matricola))
                            .findFirst().orElse(null);
                    Libro libro = pannelloVisualizzazioneLibriController.getListaElementi().stream()
                            .filter(l -> l.getISBN().equals(isbn))
                            .findFirst().orElse(null);
                    if (utente != null && libro != null) {
                        try {
                            Prestito prestito = new Prestito(utente, libro, dataScadenza);
                            pannelloVisualizzazionePrestitiController.inserisciNuovoElemento(prestito);
                        } catch (Exception e) {
                            System.out.println("Prestito non inserito: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Errore lettura prestiti.csv: " + e.getMessage());
        }
    }

}
