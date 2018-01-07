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
public class ParaWalut extends Aktywa implements Serializable{
    private Waluta glownaWaluta;
    private Waluta drugaWaluta;

    /**
     * Konstruktor
     *
     * @param random instancja Random
     * @param glownaWaluta waluta za ktora kupuje sie druga walute
     * @param drugaWaluta kupowana waluta
     */

    public ParaWalut(Random random, Waluta glownaWaluta, Waluta drugaWaluta) {
        super(random, glownaWaluta.getRynekWalutowoSurowcowy());
        this.glownaWaluta = glownaWaluta;
        this.drugaWaluta = drugaWaluta;
        setNazwa(drugaWaluta.getNazwa()+"/"+glownaWaluta.getNazwa());
    }

    /**
     * Gets drugaWaluta
     *
     * @return drugaWaluta
     */
    public Waluta getDrugaWaluta() {
        return drugaWaluta;
    }

    /**
     * Gets glownaWaluta
     *
     * @return glownaWaluta
     */
    public Waluta getGlownaWaluta() {
        return glownaWaluta;
    }

}
