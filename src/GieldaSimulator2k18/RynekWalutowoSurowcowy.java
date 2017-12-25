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
public class RynekWalutowoSurowcowy extends Rynek{
    private ArrayList<ParaWalut> listaParWalut = new ArrayList<>();
    private ArrayList<Surowiec> listaSurowcow = new ArrayList<>();

    /**
     * Gets listaParWalut
     *
     * @return listaParWalut
     */
    public ArrayList<ParaWalut> getListaParWalut() {
        return listaParWalut;
    }

    /**
     * Gets listaSurowcow
     *
     * @return listaSurowcow
     */
    public ArrayList<Surowiec> getListaSurowcow() {
        return listaSurowcow;
    }
}
