/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author wojtekreg
 */
public class Surowiec extends Aktywa{
    private String jednostkaHandlowa;
    private Waluta walutaNotowania;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("ropa naftowa", "gaz", "złoto", "srebro")
    );
    private static List<String> jednostkiHandlowe = new ArrayList<>(
            Arrays.asList("baryłki", "uncje")
    );

    public Surowiec(Random random, List<Waluta> waluty) {
        super(random, nazwy);
        walutaNotowania = waluty.get(random.nextInt(waluty.size()));
        jednostkaHandlowa = jednostkiHandlowe.get(random.nextInt(jednostkiHandlowe.size()));
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
