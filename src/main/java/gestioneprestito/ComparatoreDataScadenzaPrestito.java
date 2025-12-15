package gestioneprestito;

import java.util.Comparator;

/**
 * @class ComparatoreDataScadenzaPrestito
 * @brief Classe che implementa un comparatore per confrontare due prestiti in
 *        base alla loro data di scadenza.
 */
public class ComparatoreDataScadenzaPrestito implements Comparator<Prestito> {

    @Override
    public int compare(Prestito o1, Prestito o2) {
        return o1.getDataScadenza().compareTo(o2.getDataScadenza());
    }

}
