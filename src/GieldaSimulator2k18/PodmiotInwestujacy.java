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
            Arrays.asList("Obi Wan", "Darek", "Wilczek", "Jan", "Marcin", "Kamil", "Tadeusz", "Mistrz", "Yukki", "Natsume", "Hiruka", "Ookami")
    );
    private static List<String> nazwiska = new ArrayList<>(
            Arrays.asList("Kenobi", "Łolstrit", "Domyśl-Się", "Gruszka", "Koszlajda", "Morzy", "Yoda", "Kłoda", "Broda")
    );
    private static List<String> wykorzystywaneImionaNazwiska = new ArrayList<>();

    public PodmiotInwestujacy(Random random) throws Exception {
        if (wykorzystywaneImionaNazwiska.size() == imiona.size()*nazwiska.size())
            throw new Exception();
        do {
            imie = imiona.get(random.nextInt(imiona.size()));
            nazwisko = nazwiska.get(random.nextInt(imiona.size()));
        }while (wykorzystywaneImionaNazwiska.contains(imie + " " + nazwisko));
        wykorzystywaneImionaNazwiska.add(imie + " " + nazwisko);
    }

    /**
     * Gets wykorzystywaneImionaNazwiska
     *
     * @return wykorzystywaneImionaNazwiska
     */
    public static List<String> getWykorzystywaneImionaNazwiska() {
        return wykorzystywaneImionaNazwiska;
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
