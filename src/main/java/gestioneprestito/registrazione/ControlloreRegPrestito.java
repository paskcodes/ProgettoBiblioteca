package gestioneprestito.registrazione;

import gestionelibro.Libro;
import gestioneprestito.visualizzazione.ControlloreVisPrestiti;
import gestioneutente.Utente;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import gestionelibro.visualizzazione.ControlloreVisLibri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import gestioneprestito.Prestito;
import gestioneprestito.eccezioni.PrestitoInvalidoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

/**
 * @class ControlloreRegPrestito
 * @brief Controller della schermata di registrazione di un prestito
 */
public class ControlloreRegPrestito {
    /**
     * \cond DOXY_SKIP
     */
    @FXML
    private AnchorPane pannelloRegPrestito;
    @FXML
    private ComboBox<Utente> comboRegistraUtentePrestito;
    @FXML
    private ComboBox<Libro> comboRegistraLibroPrestito;
    @FXML
    private TextField testoRegistraDataScadenzaPrestito;
    @FXML
    private Button bottoneAggiungiPrestito;

    private ControlloreVisPrestiti cvp;
    private ControlloreVisUtenti cvu;
    private ControlloreVisLibri cvl;

    /**
     * \endcond
     */

    /**
     * @brief Gestisce l'evento di registrazione di un prestito
     * @details Crea un nuovo prestito con l'utente, il libro e la data di scadenza
     *          inseriti.
     * @param event L'evento generato dal click sul bottone di registrazione
     * @throws PrestitoInvalidoException Se i dati del prestito non sono validi
     * @throws DateTimeParseException Se il formato della data non è valido
     */
    @FXML
    private void registraPrestito(ActionEvent event) {
        try {
            Utente utente = comboRegistraUtentePrestito.getValue();
            Libro libro = comboRegistraLibroPrestito.getValue();
            if (utente == null || libro == null) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Seleziona un utente e un libro", ButtonType.CLOSE);
                a.showAndWait();
                return;
            }
            Prestito p = new Prestito(utente, libro, LocalDate
                    .parse(testoRegistraDataScadenzaPrestito.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cvp.inserisciNuovoElemento(p);
        } catch (PrestitoInvalidoException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
        } catch (DateTimeParseException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Il formato della data non è valido!", ButtonType.CLOSE);
            a.showAndWait();
        }
    }

    /**
     * @brief Aggiorna i ComboBox con gli utenti e libri disponibili
     * @details Imposta i converter per visualizzare matricola e ISBN
     * 
     */
    private void aggiornaComboBox() {
        if (cvu != null) {
            comboRegistraUtentePrestito.getItems().clear();
            comboRegistraUtentePrestito.getItems().addAll(cvu.getListaElementi());
            comboRegistraUtentePrestito.setConverter(new StringConverter<Utente>() {
                @Override
                public String toString(Utente utente) {
                    return utente != null ? utente.getMatricola() : "";
                }

                @Override
                public Utente fromString(String string) {
                    return null; 
                }
            });
        }
        if (cvl != null) {
            comboRegistraLibroPrestito.getItems().clear();
            comboRegistraLibroPrestito.getItems().addAll(cvl.getListaElementi());
            comboRegistraLibroPrestito.setConverter(new StringConverter<Libro>() {
                @Override
                public String toString(Libro libro) {
                    return libro != null ? libro.getISBN() : "";
                }

                @Override
                public Libro fromString(String string) {
                    return null; // Non necessario per selezione
                }
            });
        }
    }

    /**
     * @brief Imposta il controller di visualizzazione prestiti
     * @param cvp Controller di visualizzazione prestiti.
     */
    public void setControlloreVisualizzazione(ControlloreVisPrestiti cvp) {
        this.cvp = cvp;
    }

    /**
     * @brief Imposta il controller di visualizzazione utenti
     * @param cvu Controller di visualizzazione utenti.
     */
    public void setControlloreVisUtenti(ControlloreVisUtenti cvu) {
        this.cvu = cvu;
        aggiornaComboBox();
    }

    /**
     * @brief Imposta il controller di visualizzazione libri
     * @param cvl Controller di visualizzazione libri.
     */
    public void setControlloreVisLibri(ControlloreVisLibri cvl) {
        this.cvl = cvl;
        aggiornaComboBox();
    }

    /**
     * @brief Gestisce la pressione del tasto Invio per registrare il prestito
     * @param event L'evento di pressione tasto
     */
    @FXML
    private void aggiungiSuInvio(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            registraPrestito(null);
        }
    }

}
