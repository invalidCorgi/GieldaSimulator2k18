/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 *
 * @author wojtekreg
 */
public class FunduszInwestycyjny extends PodmiotInwestujacy implements Serializable{
    private String nazwa;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("Kaszlajda&Obiekty", "Bank Vivaldiego", "Jam jest FUNDUSZ")
    );

    /**
     * Konstruktor losujący wszystkie pola
     *
     * @param random instancja Random
     * @param swiat swiat symulacji
     * @throws Exception
     */

    public FunduszInwestycyjny(Random random, Swiat swiat) throws Exception {
        super(random, swiat);
        if (nazwy.size()>0) {
            nazwa = nazwy.get(random.nextInt(nazwy.size()));
            nazwy.remove(getNazwa());
        }
        else throw new Exception();
    }

    /**
     * Gets nazwa
     *
     * @return nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Sets nazwa
     *
     * @param nazwa nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Nieskończona metoda wątku:
     * losuje, czy sprzedaje czy kupuje aktywa
     * jeśli kupuje to szuka możliwego aktywu do kupienia
     * gdy poszuka próbuje go kupić
     * jesli sprzedaje to losuje aktywa do sprzedania z posiadanych
     * jesli cos sie nie uda to powtarza natychmiast petle
     * gdy operacja jest udana nie robi nic przez 2^10 milisekund
     */

    @Override
    public void run() {
        while (true) {
            if (getThread().isInterrupted()) {
                break;
            }
            logNazwa();
            if (getRandom().nextInt(2)==0) {
                Aktywa aktywa = znajdzAktywaDoKupienia();
                if (aktywa == null)
                    continue;
                if (!aktywa.kupAktywa(this))
                    continue;
            }
            else if (getAktywaList().size() > 0){
                getAktywaList().get(getRandom().nextInt(getAktywaList().size())).sprzedajAktywa(this);
            }
            try {
                sleep(1024);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
