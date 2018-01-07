/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author wojtekreg
 */
public class Surowiec extends Aktywa implements Serializable{
    private String jednostkaHandlowa;
    private Waluta walutaNotowania;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("ropa naftowa", "gaz", "złoto", "srebro", "ziemniak", "biohazard", "marchewka", "rzodkiewka", "cubulak", "lager", "porter")
    );
    private static List<String> jednostkiHandlowe = new ArrayList<>(
            Arrays.asList("baryłka", "uncja", "kilogram")
    );

    /**
     * Konstruktor
     *
     * @param random instancja Random
     * @param waluty lista walut z ktorych bedzie wylosowana waluta notowania
     * @throws Exception
     */

    public Surowiec(Random random, List<Waluta> waluty) throws Exception {
        super(random, nazwy, waluty.get(0).getRynekWalutowoSurowcowy());
        walutaNotowania = waluty.get(random.nextInt(waluty.size()));
        setRynek(walutaNotowania.getRynekWalutowoSurowcowy());
        jednostkaHandlowa = jednostkiHandlowe.get(random.nextInt(jednostkiHandlowe.size()));
    }

    /**
     * Gets nazwy
     *
     * @return nazwy
     */
    public static List<String> getNazwy() {
        return nazwy;
    }

    /**
     * Gets jednostkiHandlowe
     *
     * @return jednostkiHandlowe
     */
    public static List<String> getJednostkiHandlowe() {
        return jednostkiHandlowe;
    }

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
