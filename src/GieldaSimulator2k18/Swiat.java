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
public class Swiat {
    ArrayList<GieldaPapierowWartosciowych> listaGield = new ArrayList<>();
    ArrayList<RynekWalutowoSurowcowy> listaRynkowWalutowoSurowcowych = new ArrayList<>();
    ArrayList<Spolka> listaSpolek = new ArrayList<>();
    ArrayList<Surowiec> listaSurowcow = new ArrayList<>();
    ArrayList<Waluta> listaWalut = new ArrayList<>();
    ArrayList<ParaWalut> listaParWalut = new ArrayList<>();
    ArrayList<Indeks> listaIndeksow = new ArrayList<>();
    ArrayList<FunduszInwestycyjny> listaFunduszyInwestycyjnych = new ArrayList<>();

    /**
     * Gets listaGield
     *
     * @return listaGield
     */
    public ArrayList<GieldaPapierowWartosciowych> getListaGield() {
        return listaGield;
    }

    /**
     * Gets listaRynkowWalutowoSurowcowych
     *
     * @return listaRynkowWalutowoSurowcowych
     */
    public ArrayList<RynekWalutowoSurowcowy> getListaRynkowWalutowoSurowcowych() {
        return listaRynkowWalutowoSurowcowych;
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
     * Gets listaSurowcow
     *
     * @return listaSurowcow
     */
    public ArrayList<Surowiec> getListaSurowcow() {
        return listaSurowcow;
    }

    /**
     * Gets listaWalut
     *
     * @return listaWalut
     */
    public ArrayList<Waluta> getListaWalut() {
        return listaWalut;
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
     * Gets listaIndeksow
     *
     * @return listaIndeksow
     */
    public ArrayList<Indeks> getListaIndeksow() {
        return listaIndeksow;
    }

    /**
     * Gets listaFunduszyInwestycyjnych
     *
     * @return listaFunduszyInwestycyjnych
     */
    public ArrayList<FunduszInwestycyjny> getListaFunduszyInwestycyjnych() {
        return listaFunduszyInwestycyjnych;
    }

    /**
     * Gets listaInwestorow
     *
     * @return listaInwestorow
     */
    public ArrayList<Inwestor> getListaInwestorow() {
        return listaInwestorow;
    }

    ArrayList<Inwestor> listaInwestorow = new ArrayList<>();
}
