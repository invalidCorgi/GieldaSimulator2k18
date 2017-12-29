/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author wojtekreg
 */
public class RynekWalutowoSurowcowy extends Rynek implements Serializable{
    private ArrayList<ParaWalut> listaParWalut;
    private ArrayList<Surowiec> listaSurowcow;

    public RynekWalutowoSurowcowy(Random random, Waluta waluta) {
        super(random,waluta,"Rynek "+waluta);
        listaParWalut = new ArrayList<>();
        listaSurowcow = new ArrayList<>();
    }

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
