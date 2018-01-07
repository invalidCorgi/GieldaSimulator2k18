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

    /**
     * Konstruktor ustawiajacy pola oprocz nazwy
     *
     * @param random instancja Random
     * @param waluta waluta rynku do przypisania
     */

    public Rynek(Random random, Waluta waluta) {
        this.waluta = waluta;
        marzaProcentowa = random.nextDouble();
    }

    /**
     * Konstruktor ze z gory podana nazwa
     *
     * @param random instancja Random
     * @param waluta waluta rynku do przypisania
     * @param nazwa nazwa do przypisania
     */

    public Rynek(Random random, Waluta waluta, String nazwa) {
        this(random,waluta);
        this.nazwa = nazwa;
    }

    /**
     * Konstruktor losujacy nazwe z kolekcji
     *
     * @param random instancja Random
     * @param waluta waluta rynku do przypisania
     * @param nazwy lista nazw, z ktorej bedzie losowana nazwa
     * @throws Exception
     */

    public Rynek(Random random, Waluta waluta, List<String> nazwy) throws Exception {
        this(random,waluta);
        if (nazwy.size()>0) {
            nazwa = nazwy.get(random.nextInt(nazwy.size()));
            nazwy.remove(getNazwa());
        }
        else throw new Exception();
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
