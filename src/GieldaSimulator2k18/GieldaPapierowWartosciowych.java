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
public class GieldaPapierowWartosciowych extends Rynek implements Serializable{
    private String kraj;
    private String miasto;
    private String adresSiedziby;
    private ArrayList<Spolka> listaSpolek = new ArrayList<>();
    private ArrayList<Indeks> listaIndeksow = new ArrayList<>();
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("Łol Strit", "Best giełda ever", "Papieladnia dla papierów", "Giełda i edukacja łupi domy arabów (like a WINE)")
    );
    private static List<String> miasta = new ArrayList<>(
            Arrays.asList("Warszawa", "Berlin", "Nowy Jork", "Kij wie", "Albo i nie")
    );
    private static List<String> adresy = new ArrayList<>(
            Arrays.asList("Sezamkowa 23", "Wiejska 2", "Miejska 3", "Abrakadabra 15", "Legolasa 9")
    );

    public GieldaPapierowWartosciowych(Random random, Waluta waluta) throws Exception {
        super(random, waluta,nazwy);
        kraj = waluta.getKrajePlatnicze().get(random.nextInt(waluta.getKrajePlatnicze().size()));
        miasto = miasta.get(random.nextInt(miasta.size()));
        adresSiedziby = adresy.get(random.nextInt(adresy.size()));
    }

    /**
     * Gets nazwy
     *
     * @return nazwy
     */
    public static List<String> getNazwy() {
        return nazwy;
    }

    /**
     * Gets kraj
     *
     * @return kraj
     */
    public String getKraj() {
        return kraj;
    }

    /**
     * Sets kraj
     *
     * @param kraj kraj to set
     */
    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    /**
     * Gets miasto
     *
     * @return miasto
     */
    public String getMiasto() {
        return miasto;
    }

    /**
     * Sets miasto
     *
     * @param miasto miasto to set
     */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    /**
     * Gets adresSiedziby
     *
     * @return adresSiedziby
     */
    public String getAdresSiedziby() {
        return adresSiedziby;
    }

    /**
     * Sets adresSiedziby
     *
     * @param adresSiedziby adresSiedziby to set
     */
    public void setAdresSiedziby(String adresSiedziby) {
        this.adresSiedziby = adresSiedziby;
    }

    /**
     * Gets listaSpolek
     *
     * @return listaSpolek
     */
    public ArrayList<Spolka> getListaSpolek() {
        return listaSpolek;
    }

    /**
     * Gets listaIndeksow
     *
     * @return listaIndeksow
     */
    public ArrayList<Indeks> getListaIndeksow() {
        return listaIndeksow;
    }

}
