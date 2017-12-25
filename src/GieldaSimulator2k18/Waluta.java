/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.util.ArrayList;

/**
 *
 * @author wojtekreg
 */
public class Waluta {
    private String nazwa;
    private ArrayList<String> krajePlatnicze;

    /**
     * Konstruktor
     *
     * @param nazwa nazwa do ustawienia
     */
    public Waluta(String nazwa) {
        this.nazwa = nazwa;
        krajePlatnicze = new ArrayList<>();
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
