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
public class Waluta implements Serializable{
    private String nazwa;
    private ArrayList<String> krajePlatnicze;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("złoty", "dolar", "euro", "yen", "batat", "bitcoin", "ethereum", "monero")
    );
    private RynekWalutowoSurowcowy rynekWalutowoSurowcowy;

    /**
     * Gets nazwy
     *
     * @return nazwy
     */
    public static List<String> getNazwy() {
        return nazwy;
    }

    /**
     * Gets rynekWalutowoSurowcowy
     *
     * @return rynekWalutowoSurowcowy
     */
    public RynekWalutowoSurowcowy getRynekWalutowoSurowcowy() {
        return rynekWalutowoSurowcowy;
    }

    /**
     * Sets rynekWalutowoSurowcowy
     *
     * @param rynekWalutowoSurowcowy rynekWalutowoSurowcowy to set
     */
    public void setRynekWalutowoSurowcowy(RynekWalutowoSurowcowy rynekWalutowoSurowcowy) {
        this.rynekWalutowoSurowcowy = rynekWalutowoSurowcowy;
    }

    /**
     * Konstruktor
     *
     * @param random generator pseudolosowy
     */
    public Waluta(Random random) throws Exception {
        if (nazwy.size()>0) {
            nazwa = nazwy.get(random.nextInt(nazwy.size()));
            nazwy.remove(getNazwa());
        }
        else throw new Exception();
        krajePlatnicze = new ArrayList<>();
    }

    @Override
    public String toString() {
        return nazwa;
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
     * Gets krajePlatnicze
     *
     * @return krajePlatnicze
     */
    public ArrayList<String> getKrajePlatnicze() {
        return krajePlatnicze;
    }
}
