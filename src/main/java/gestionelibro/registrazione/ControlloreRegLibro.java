package gestionelibro.registrazione;

import gestionelibro.visualizzazione.ControlloreVisLibri;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;

/**
 * @class ControlloreRegLibro
 * @brief Classe controller per la registrazione di un nuovo libro.
 * 
 */
public class ControlloreRegLibro implements Initializable {
    /**
     * \cond Doxygen_Skip
     */
    @FXML
    private AnchorPane pannelloRegLibro;
    @FXML
    private TextField testoRegistraLibroTitolo;
    @FXML
    private TextField testoRegistraAutoriLibro;
    @FXML
    private TextField testoRegistraDataPubblicazioneLibro;
    @FXML
    private TextField testoRegistraISBNLibro;
    @FXML
    private TextField testoRegistraNumCopieLibro;
    @FXML
    private Button bottoneAggiungiLibro;
    /**
     * \endcond
     */
    
    private ControlloreVisLibri cvl;
    
    /**
     * @brief Inizializza il controller della scena di registrazione del libro.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @brief Gestisce l'evento di registrazione di un nuovo libro.
     * @param event L'evento generato dal click sul bottone di registrazione.
     */
    @FXML
   private void registraLibro(ActionEvent event) {
        try {
            // Recupera i dati nelle celle di testo
            String titolo = testoRegistraLibroTitolo.getText().trim();
            String autori = testoRegistraAutoriLibro.getText().trim();
            String dataStr = testoRegistraDataPubblicazioneLibro.getText().trim();
            String isbn = testoRegistraISBNLibro.getText().trim();
            String copieStr = testoRegistraNumCopieLibro.getText().trim();
            
            // Controlla che i campi non siano vuoti
            if(titolo.isEmpty() || autori.isEmpty() || dataStr.isEmpty() || 
               isbn.isEmpty() || copieStr.isEmpty()) {
                mostraErrore("Errore", "Tutti i campi devono essere compilati");
                return;
            }
            
            // Converti la data
            LocalDate dataPubblicazione = parseData(dataStr);
            if(dataPubblicazione == null) {
                mostraErrore("Errore Data", "Formato data non valido. Usa gg/MM/yyyy (es: 15/03/2023)");
                return;
            }
            
            //  Controllo che la data viene inserita correttamente nel suo formato
            if(!Libro.isDataPubblicazioneValida(dataPubblicazione)) {
                mostraErrore("Errore Data", "La data di pubblicazione non può essere futura");
                return;
            }
            
            // Numeri di copie inserite 
            int copie;
            try {
                copie = Integer.parseInt(copieStr);
            } catch(NumberFormatException e) {
                mostraErrore("Errore Copie", "Il numero di copie deve essere un numero valido");
                return;
            }
            
            // Controlla validità copie
            if(!Libro.isNumCopieValido(copie)) {
                mostraErrore("Errore Copie", "Il numero di copie deve essere almeno 1");
                return;
            }
            
            // Crea il libro
            Libro nuovoLibro = new Libro(titolo, autori, dataPubblicazione, isbn, copie);
            
            // lo inserisce nell'archivio
            cvl.inserisciNuovoElemento(nuovoLibro);
            
            // Campi Compilitati correttamente e pulisce tutto
            pulisciCampi();
            mostraSuccesso("Libro Registrato", "Il libro è stato registrato con successo!");
            
        } catch(LibroDuplicatoException e) {
            mostraErrore("Libro Duplicato", "Esiste già un libro con questo ISBN");
        } catch(Exception e) {
            mostraErrore("Errore", "Errore durante la registrazione: " + e.getMessage());
        }
    }
    
    /**
     * Converte una stringa in LocalDate (formato gg/MM/yyyy)
     */
    private LocalDate parseData(String dataStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataStr, formatter);
        } catch(DateTimeParseException e) {
            return null;
        }
    }
    
    /**
     * Mostra la finstra di errore
     */
    private void mostraErrore(String titolo, String messaggio) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
    
    /**
     * Mostra una finestra di successo
     */
    private void mostraSuccesso(String titolo, String messaggio) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
    
    /**
     * Pulisce tutti i campi di testo
     */
    private void pulisciCampi() {
        testoRegistraLibroTitolo.clear();
        testoRegistraAutoriLibro.clear();
        testoRegistraDataPubblicazioneLibro.clear();
        testoRegistraISBNLibro.clear();
        testoRegistraNumCopieLibro.clear();
    }
    
    public void setControlloreVisualizzazione(ControlloreVisLibri cvl){
        this.cvl = cvl;
    }
}

