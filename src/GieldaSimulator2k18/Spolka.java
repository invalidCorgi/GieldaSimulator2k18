/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 *
 * @author wojtekreg
 */
public class Spolka extends Aktywa implements Serializable, Runnable{
    private int liczbaAkcji;
    private double zysk;
    private double przychod;
    private double kapitalWlasny;
    private double kapitalZakladowy;
    private List<Indeks> listaIndeksow;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("MikroShit", "Ajpul", "BiegaGames", "InvalidCorgiGames", "Ikeła", "Łerla Merlę", "Lydl", "Stonka", "Brutto")
    );
    private Random random;
    private Thread thread;
    private GieldaPapierowWartosciowych gielda;

    /**
     * Gets nazwy
     *
     * @return nazwy
     */
    public static List<String> getNazwy() {
        return nazwy;
    }

    public Spolka(Random random, GieldaPapierowWartosciowych gielda) throws Exception {
        super(random, nazwy);
        this.random = random;
        this.liczbaAkcji = random.nextInt(50)+10;
        this.zysk = 0;
        this.przychod = 0;
        this.kapitalZakladowy = 5000 + random.nextDouble()*20000;
        this.kapitalWlasny = kapitalZakladowy + random.nextDouble()*100000;
        this.listaIndeksow = new ArrayList<>();
        this.gielda = gielda;
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
     * Gets przychod
     *
     * @return przychod
     */
    public double getPrzychod() {
        return przychod;
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
     * Gets kapitalZakladowy
     *
     * @return kapitalZakladowy
     */
    public double getKapitalZakladowy() {
        return kapitalZakladowy;
    }

    /**
     * Gets listaIndeksow
     *
     * @return listaIndeksow
     */
    public List<Indeks> getListaIndeksow() {
        return listaIndeksow;
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
     * Gets gielda
     *
     * @return gielda
     */
    public GieldaPapierowWartosciowych getGielda() {
        return gielda;
    }

    @Override
    public void run(){
        while (true){
            if (thread.isInterrupted())
                break;
            zysk = random.nextDouble()*100000;
            przychod = zysk + random.nextDouble()*1000000;
            if (random.nextInt(4)==0)
                liczbaAkcji++;
            System.out.println("petla");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
