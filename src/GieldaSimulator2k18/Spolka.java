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
public class Spolka extends Aktywa implements Serializable{
    private int liczbaAkcji;
    private double zysk;
    private double przychod;
    private double kapitalWlasny;
    private double kapitalZakladowy;
    private List<Indeks> listaIndeksow;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("MikroShit", "Ajpul", "BiegaGames", "InvalidCorgiGames")
    );

    /**
     * Gets nazwy
     *
     * @return nazwy
     */
    public static List<String> getNazwy() {
        return nazwy;
    }

    public Spolka(Random random) throws Exception {
        super(random, nazwy);
        this.liczbaAkcji = random.nextInt(50)+10;
        this.zysk = 0;
        this.przychod = 0;
        this.kapitalZakladowy = 5000 + random.nextDouble()*20000;
        this.kapitalWlasny = kapitalZakladowy + random.nextDouble()*100000;
        this.listaIndeksow = new ArrayList<>();
    }

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
    public List<Indeks> getListaIndeksow() {
        return listaIndeksow;
    }

}
