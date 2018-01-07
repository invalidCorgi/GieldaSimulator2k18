/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wojtekreg
 */
public class IndeksNajwiekszychSpolek extends Indeks implements Serializable{
    private int iloscSpolek;

    /**
     * Konstruktor, jesli ilosc spolek jest wieksza niz maksymalna to jest obcinana do maksimum
     *
     * @param gielda gielda notowania
     * @param iloscSpolek ilosc najwiekszych spolek do uwzglednienia
     */

    public IndeksNajwiekszychSpolek(GieldaPapierowWartosciowych gielda, int iloscSpolek){
        super(gielda,"Top "+iloscSpolek+" "+gielda);
        if (iloscSpolek > gielda.getListaSpolek().size()) {
            iloscSpolek = gielda.getListaSpolek().size();
            setNazwa("Top " + iloscSpolek + " " + gielda);
        }
        this.iloscSpolek = iloscSpolek;
        updateListaSpolek();
        updateLacznaWartosc();
    }

    /**
     * Znalezienie okreslonej liczby najwiekszych spolek
     */

    private void updateListaSpolek(){
        getListaSpolek().clear();
        ArrayList<Spolka> spolki = new ArrayList<>();
        spolki.addAll(getGielda().getListaSpolek());
        for (int i=0; i<iloscSpolek; i++){
            double max = 0;
            Spolka tempSpolka = null;
            for (int j=0; j<spolki.size(); j++){
                if (spolki.get(j).getKursAktualny()>max){
                    max = spolki.get(j).getKursAktualny();
                    tempSpolka = spolki.get(j);
                }
            }
            getListaSpolek().add(tempSpolka);
            spolki.remove(tempSpolka);
            tempSpolka.getListaIndeksow().add(this);
        }
    }

    /**
     * Gets iloscSpolek
     *
     * @return iloscSpolek
     */
    public int getIloscSpolek() {
        return iloscSpolek;
    }

}
