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
    private List<Aktywa> aktywaList;
    private static List<String> imiona = new ArrayList<>(
            Arrays.asList("Obi Wan", "Darek", "Wilczek", "Jan", "Marcin", "Kamil", "Tadeusz", "Mistrz", "Yukki", "Natsume", "Hiruka", "Ookami", "InvalidCorgi")
    );
    private static List<String> nazwiska = new ArrayList<>(
            Arrays.asList("Kenobi", "Łolstrit", "Domyśl-Się", "Gruszka", "Koszlajda", "Morzy", "Yoda", "Kłoda", "Broda", "Smroda", "Trololoda")
    );
    private static List<String> wykorzystywaneImionaNazwiska = new ArrayList<>();
    private Swiat swiat;
    private Random random;

    /**
     * Konstruktor
     *
     * @param random instancja Random
     * @param swiat swiat symulacji
     * @throws Exception
     */

    public PodmiotInwestujacy(Random random, Swiat swiat) throws Exception {
        this.random = random;
        if (wykorzystywaneImionaNazwiska.size() == imiona.size()*nazwiska.size())
            throw new Exception();
        do {
            imie = imiona.get(random.nextInt(imiona.size()));
            nazwisko = nazwiska.get(random.nextInt(imiona.size()));
            this.swiat = swiat;
        }while (wykorzystywaneImionaNazwiska.contains(imie + " " + nazwisko));
        wykorzystywaneImionaNazwiska.add(imie + " " + nazwisko);
        aktywaList = new ArrayList<>();
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

    /**
     * Gets random
     *
     * @return random
     */
    protected Random getRandom() {
        return random;
    }

    /**
     * Gets swiat
     *
     * @return swiat
     */
    public Swiat getSwiat() {
        return swiat;
    }

    /**
     * Gets aktywaList
     *
     * @return aktywaList
     */
    public List<Aktywa> getAktywaList() {
        return aktywaList;
    }

    protected void logNazwa(){
        System.out.println("Pętla " + imie + " " + nazwisko);
    }

    /**
     *
     * @return istniejące aktywa byc moze mozliwe do kupienia, w razie niepowodzenia w szukaniu null
     */

    protected Aktywa znajdzAktywaDoKupienia(){
        int rand = random.nextInt(2);
        if (swiat.getListaGield().size() > 0 && rand==0){
            GieldaPapierowWartosciowych gielda = swiat.getListaGield().get(random.nextInt(swiat.getListaGield().size()));
            if (gielda.getListaSpolek().size() > 0){
                Spolka spolka = gielda.getListaSpolek().get(random.nextInt(gielda.getListaSpolek().size()));
                if (spolka.getLiczbaAkcji() > 0) {
                    return spolka;
                } else {
                    return null;
                }
            }
            else {
                return null;
            }
        }
        else if (swiat.getListaRynkowWalutowoSurowcowych().size() > 0 && rand==1){
            RynekWalutowoSurowcowy rynek = swiat.getListaRynkowWalutowoSurowcowych().get(random.nextInt(swiat.getListaRynkowWalutowoSurowcowych().size()));
            rand = random.nextInt(2);
            if (rynek.getListaSurowcow().size() > 0 && rand==0){
                return rynek.getListaSurowcow().get(random.nextInt(rynek.getListaSurowcow().size()));
            }
            else if (rynek.getListaParWalut().size() > 0 && rand==1){
                return rynek.getListaParWalut().get(random.nextInt(rynek.getListaParWalut().size()));
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return imie+" "+nazwisko;
    }
}
