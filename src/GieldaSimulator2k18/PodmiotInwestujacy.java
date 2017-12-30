/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;

/**
 *
 * @author wojtekreg
 */
public class PodmiotInwestujacy implements Serializable{
    private String imie;
    private String nazwisko;
    private Thread thread;

    /**
     * Gets thread
     *
     * @return thread
     */
    public Thread getThread() {
        return thread;
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
}
