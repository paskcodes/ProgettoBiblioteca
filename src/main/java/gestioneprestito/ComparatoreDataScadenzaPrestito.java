package gestioneprestito;

import java.util.Comparator;

/**
 *
 * @author Antonio Franco
 */
public class ComparatoreDataScadenzaPrestito implements Comparator<Prestito>{

    @Override
    public int compare(Prestito o1, Prestito o2) {
        return o1.getDataScadenza().compareTo(o2.getDataScadenza());
    }
    
}
