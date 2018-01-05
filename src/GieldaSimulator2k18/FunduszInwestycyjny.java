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

import static java.lang.Thread.sleep;

/**
 *
 * @author wojtekreg
 */
public class FunduszInwestycyjny extends PodmiotInwestujacy implements Serializable{
    private String nazwa;
    private static List<String> nazwy = new ArrayList<>(
            Arrays.asList("Kaszlajda&Obiekty", "Bank Vivaldiego", "Jam jest FUNDUSZ")
    );

    public FunduszInwestycyjny(Random random, Swiat swiat) throws Exception {
        super(random, swiat);
        if (nazwy.size()>0) {
            nazwa = nazwy.get(random.nextInt(nazwy.size()));
            nazwy.remove(getNazwa());
        }
        else throw new Exception();
    }

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
        while (true) {
            if (getThread().isInterrupted()) {
                break;
            }
            super.run();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
