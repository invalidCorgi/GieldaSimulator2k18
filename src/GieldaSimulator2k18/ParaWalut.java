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

    public ParaWalut(Random random, Waluta glownaWaluta, Waluta drugaWaluta) {
        super(random);
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
     * Sets drugaWaluta
     *
     * @param drugaWaluta drugaWaluta to set
     */
    public void setDrugaWaluta(Waluta drugaWaluta) {
        this.drugaWaluta = drugaWaluta;
    }

    /**
     * Gets glownaWaluta
     *
     * @return glownaWaluta
     */
    public Waluta getGlownaWaluta() {
        return glownaWaluta;
    }

    /**
     * Sets glownaWaluta
     *
     * @param glownaWaluta glownaWaluta to set
     */
    public void setGlownaWaluta(Waluta glownaWaluta) {
        this.glownaWaluta = glownaWaluta;
    }
}
