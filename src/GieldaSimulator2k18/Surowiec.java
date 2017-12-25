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
public class Surowiec extends Aktywa{
    private String jednostkaHandlowa;
    private Waluta walutaNotowania;

    /**
     * Gets jednostkaHandlowa
     *
     * @return jednostkaHandlowa
     */
    public String getJednostkaHandlowa() {
        return jednostkaHandlowa;
    }

    /**
     * Gets walutaNotowania
     *
     * @return walutaNotowania
     */
    public Waluta getWalutaNotowania() {
        return walutaNotowania;
    }
}
