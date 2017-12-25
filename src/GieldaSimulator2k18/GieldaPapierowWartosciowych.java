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
public class GieldaPapierowWartosciowych extends Rynek{
    private String kraj;
    private String miasto;
    private String adresSiedziby;
    private ArrayList<Spolka> listaSpolek = new ArrayList<>();
    private ArrayList<Indeks> listaIndeksow = new ArrayList<>();

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
