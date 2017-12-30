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

/**
 *
 * @author wojtekreg
 */
public class PodmiotInwestujacy implements Serializable{
    private String imie;
    private String nazwisko;
    private Thread thread;
    private static List<String> imiona = new ArrayList<>(
            Arrays.asList("Obi Wan", "Darek", "Wilczek")
    );
    private static List<String> nazwiska = new ArrayList<>(
            Arrays.asList("Kenobi", "Łolstrit", "Domyśl-Się")
    );

    public PodmiotInwestujacy(Random random) throws Exception {
        if (imiona.size()>0) {
            imie = imiona.get(random.nextInt(imiona.size()));
            imiona.remove(getImie());
        }
        else throw new Exception();
        if (nazwiska.size()>0) {
            nazwisko = nazwiska.get(random.nextInt(nazwiska.size()));
            nazwiska.remove(getImie());
        }
        else throw new Exception();
    }

    /**
     * Gets thread
     *
     * @return thread
     */
    public Thread getThread() {
        return thread;
    }

    /**
     * Gets imie
     *
     * @return imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets imie
     *
     * @param imie imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Gets nazwisko
     *
     * @return nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets nazwisko
     *
     * @param nazwisko nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
