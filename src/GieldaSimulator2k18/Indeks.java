/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wojtekreg
 */
public class Indeks implements Serializable{
    private String nazwa;
    private ArrayList<Spolka> listaSpolek = new ArrayList<>();
    double lacznaWartosc;
    private GieldaPapierowWartosciowych gielda;

    /**
     * Gets nazwa
     *
     * @return nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Sets nazwa
     *
     * @param nazwa nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
     * Gets lacznaWartosc
     *
     * @return lacznaWartosc
     */
    public double getLacznaWartosc() {
        return lacznaWartosc;
    }

    /**
     * Sets lacznaWartosc
     *
     * @param lacznaWartosc lacznaWartosc to set
     */
    public void setLacznaWartosc(double lacznaWartosc) {
        this.lacznaWartosc = lacznaWartosc;
    }

    /**
     * Gets gielda
     *
     * @return gielda
     */
    public GieldaPapierowWartosciowych getGielda() {
        return gielda;
    }

}
