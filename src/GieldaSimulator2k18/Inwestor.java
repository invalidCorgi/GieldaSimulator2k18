/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.Random;

import static java.lang.Thread.enumerate;
import static java.lang.Thread.sleep;

/**
 *
 * @author wojtekreg
 */
public class Inwestor extends PodmiotInwestujacy implements Serializable{
    private String pesel;
    private double budzet;
    private static int peselLength = 11;

    /**
     * Konstruktor
     *
     * @param random instancja Random
     * @param swiat swiat symulacji
     * @throws Exception
     */

    public Inwestor(Random random, Swiat swiat) throws Exception {
        super(random, swiat);
        pesel="";
        for (int i=0;i<peselLength;i++){
            pesel += random.nextInt(10);
        }
        budzet = random.nextDouble()*100;
    }

    /**
     * Gets pesel
     *
     * @return pesel
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * Gets budzet
     *
     * @return budzet
     */
    public double getBudzet() {
        return budzet;
    }

    /**
     * Sets budzet
     *
     * @param budzet budzet to set
     */
    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    /**
     * Metoda wątku, losowo zwieksza budzet, oprocz dzialania funduszu inwestecyjnego moze jeszcze odkupowac aktywa od funduszy
     */

    @Override
    public void run() {
        while (true){
            if (getThread().isInterrupted()){
                break;
            }
            logNazwa();
            if (getRandom().nextInt(5)==0)
                budzet+=5;
            if (getRandom().nextInt(2)==0) {
                if (getSwiat().getListaFunduszyInwestycyjnych().size() > 0 && getRandom().nextInt(2) == 0) {
                    FunduszInwestycyjny funduszInwestycyjny = getSwiat().getListaFunduszyInwestycyjnych().get(getRandom().nextInt(getSwiat().getListaFunduszyInwestycyjnych().size()));
                    if (funduszInwestycyjny.getAktywaList().size() > 0) {
                        Aktywa aktywa = funduszInwestycyjny.getAktywaList().get(getRandom().nextInt(funduszInwestycyjny.getAktywaList().size()));
                        if (aktywa.getKursAktualny() < budzet) {
                            budzet -= aktywa.getKursAktualny();
                            funduszInwestycyjny.getAktywaList().remove(aktywa);
                            this.getAktywaList().add(aktywa);
                        } else continue;
                    } else continue;
                } else {
                    Aktywa aktywa = znajdzAktywaDoKupienia();
                    if (aktywa == null)
                        continue;
                    if (!aktywa.kupAktywa(this))
                        continue;
                }
            }
            else if (getAktywaList().size() > 0){
                getAktywaList().get(getRandom().nextInt(getAktywaList().size())).sprzedajAktywa(this);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
