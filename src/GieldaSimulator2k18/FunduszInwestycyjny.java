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
public class FunduszInwestycyjny extends PodmiotInwestujacy implements Runnable, Serializable{
    private String nazwa;

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

    @Override
    public void run() {

    }
}
