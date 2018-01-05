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
public abstract class PodmiotInwestujacy implements Serializable, Runnable {
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
    private Swiat swiat;

    public PodmiotInwestujacy(Random random, Swiat swiat) throws Exception {
        if (wykorzystywaneImionaNazwiska.size() == imiona.size()*nazwiska.size())
            throw new Exception();
        do {
            imie = imiona.get(random.nextInt(imiona.size()));
            nazwisko = nazwiska.get(random.nextInt(imiona.size()));
            this.swiat = swiat;
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
     * Sets thread
     *
     * @param thread thread to set
     */
    public void setThread(Thread thread) {
        this.thread = thread;
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

    @Override
    public void run() {
        System.out.println("petla2");
    }

    @Override
    public String toString() {
        return imie+" "+nazwisko;
    }
}
