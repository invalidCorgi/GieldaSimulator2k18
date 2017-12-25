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
public class Spolka extends Aktywa{
    private int liczbaAkcji;
    private double zysk;
    private double przychod;
    private double kapitalWlasny;
    private double kapitalZakladowy;
    private ArrayList<Indeks> listaIndeksow = new ArrayList<>();

    /**
     * Gets liczbaAkcji
     *
     * @return liczbaAkcji
     */
    public int getLiczbaAkcji() {
        return liczbaAkcji;
    }

    /**
     * Sets liczbaAkcji
     *
     * @param liczbaAkcji liczbaAkcji to set
     */
    public void setLiczbaAkcji(int liczbaAkcji) {
        this.liczbaAkcji = liczbaAkcji;
    }

    /**
     * Gets zysk
     *
     * @return zysk
     */
    public double getZysk() {
        return zysk;
    }

    /**
     * Sets zysk
     *
     * @param zysk zysk to set
     */
    public void setZysk(double zysk) {
        this.zysk = zysk;
    }

    /**
     * Gets przychod
     *
     * @return przychod
     */
    public double getPrzychod() {
        return przychod;
    }

    /**
     * Sets przychod
     *
     * @param przychod przychod to set
     */
    public void setPrzychod(double przychod) {
        this.przychod = przychod;
    }

    /**
     * Gets kapitalWlasny
     *
     * @return kapitalWlasny
     */
    public double getKapitalWlasny() {
        return kapitalWlasny;
    }

    /**
     * Sets kapitalWlasny
     *
     * @param kapitalWlasny kapitalWlasny to set
     */
    public void setKapitalWlasny(double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    /**
     * Gets kapitalZakladowy
     *
     * @return kapitalZakladowy
     */
    public double getKapitalZakladowy() {
        return kapitalZakladowy;
    }

    /**
     * Sets kapitalZakladowy
     *
     * @param kapitalZakladowy kapitalZakladowy to set
     */
    public void setKapitalZakladowy(double kapitalZakladowy) {
        this.kapitalZakladowy = kapitalZakladowy;
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
