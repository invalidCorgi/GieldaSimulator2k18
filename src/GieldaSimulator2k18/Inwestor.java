/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

/**
 *
 * @author wojtekreg
 */
public class Inwestor extends PodmiotInwestujacy implements Runnable{
    private String pesel;
    private double budzet;

    /**
     * Gets pesel
     *
     * @return pesel
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * Sets pesel
     *
     * @param pesel pesel to set
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * Gets budzet
     *
     * @return budzet
     */
    public double getBudzet() {
        return budzet;
    }

    /**
     * Sets budzet
     *
     * @param budzet budzet to set
     */
    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    @Override
    public void run() {

    }
}
