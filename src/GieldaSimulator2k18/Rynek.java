/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 *
 * @author wojtekreg
 */
public class Rynek implements Serializable{
    private String nazwa;
    private Waluta waluta;
    private double marzaProcentowa;

    public Rynek(Random random, Waluta waluta) {
        this.waluta = waluta;
        marzaProcentowa = random.nextDouble();
    }

    public Rynek(Random random, Waluta waluta, String nazwa) {
        this(random,waluta);
        this.nazwa = nazwa;
    }

    public Rynek(Random random, Waluta waluta, List<String> nazwy) {
        this(random,waluta);
        if (nazwy.size()>0) {
            nazwa = nazwy.get(random.nextInt(nazwy.size()));
            nazwy.remove(getNazwa());
        }
        else nazwa = "wszystkie zajęte";
    }

    @Override
    public String toString() {
        return nazwa;
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

    /**
     * Gets waluta
     *
     * @return waluta
     */
    public Waluta getWaluta() {
        return waluta;
    }

    /**
     * Sets waluta
     *
     * @param waluta waluta to set
     */
    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }

    /**
     * Gets marzaProcentowa
     *
     * @return marzaProcentowa
     */
    public double getMarzaProcentowa() {
        return marzaProcentowa;
    }

    /**
     * Sets marzaProcentowa
     *
     * @param marzaProcentowa marzaProcentowa to set
     */
    public void setMarzaProcentowa(double marzaProcentowa) throws NiepoprawnaMarzaException {
        if (marzaProcentowa<0 || marzaProcentowa>100)
            throw new NiepoprawnaMarzaException();
        this.marzaProcentowa = marzaProcentowa;
    }
}
