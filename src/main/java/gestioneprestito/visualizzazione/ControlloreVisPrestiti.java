package gestioneprestito.visualizzazione;

import gestionearchivio.Archiviabile;
import gestionelibro.Libro;
import gestionelibro.eccezioni.LibroPrestitoAttivoException;
import gestionelibro.visualizzazione.ControlloreVisLibri;
import gestioneprestito.Prestito;
import gestioneprestito.eccezioni.PrestitoDuplicatoException;
import gestioneprestito.eccezioni.PrestitoInvalidoException;
import gestioneutente.Utente;
import gestioneutente.eccezioni.UtentePrestitoAttivoException;
import gestioneutente.visualizzazione.ControlloreVisUtenti;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @class ControlloreVisPrestiti
 * @brief Controller della schermata di visualizzazione dei prestiti.
 * @details Gestisce tabella, filtri e azioni di estinzione prestiti nella UI.
 */
public class ControlloreVisPrestiti implements Initializable, Archiviabile<Prestito, PrestitoInvalidoException> {

    /**
     * \cond DOXYGEN_SKIP
     */
    @FXML
    private AnchorPane pannelloVisPrestiti;
    @FXML
    private TableView<Prestito> tabellaPrestiti;
    @FXML
    private TableColumn<Prestito, String> colonnaUtenteTabellaPrestiti;
    @FXML
    private TableColumn<Prestito, String> colonnaLibroTabellaPrestiti;
    @FXML
    private TableColumn<Prestito, LocalDate> colonnaDataScadenzaTabellaPrestiti;

    private ControlloreVisUtenti cvu;
    
    private ControlloreVisLibri cvl;
    
    private ObservableList<Prestito> archivioPrestiti = FXCollections.observableArrayList();
    /**
     * \endcond
     */

    /**
     * @brief Inizializza il controller della schermata di visualizzazione dei prestiti
     * @param url L'URL di riferimento
     * @param rb Il ResourceBundle di riferimento
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @brief Gestisce l'estinzione del prestito
     * @param event L'evento di ricerca
     */
    @FXML
    private void estinguiPrestito(ActionEvent event) {
    }
    
    /**
     * @brief Esegue la ricerca e il filtraggio dei prestiti nella tabella.
     * @param event Evento di tastiera generato dall'input di ricerca.
     */
    @FXML
    private void ricercaPrestiti(KeyEvent event) {
    }

    @Override
    public void inserisciNuovoElemento(Prestito nuovoElemento) throws PrestitoDuplicatoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isElementoPresente(Prestito daCercare) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList getListaElementi() {
        return this.archivioPrestiti;
    }
    
    public boolean inPrestitoAttivoUtente(Utente indagato) throws UtentePrestitoAttivoException{

        if(archivioPrestiti.stream().anyMatch(p -> p.getUtente().getMatricola().equals(indagato.getMatricola()) &&  p.getUtente().getNumPrestitiAttivi() > 0)){
            throw new UtentePrestitoAttivoException();
        }

        return false;
    }
    
    public boolean inPrestitoAttivoLibro(Libro indagato) throws LibroPrestitoAttivoException{
        if(archivioPrestiti.stream().anyMatch(p -> p.getLibro().getISBN().equals(indagato.getISBN()) &&  p.getLibro().getNumPrestitiAttivi() > 0)){
            throw new LibroPrestitoAttivoException();
        }
        
        return false;
    }
    
}
