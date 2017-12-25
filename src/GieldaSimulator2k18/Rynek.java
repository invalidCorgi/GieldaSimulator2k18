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
public class Rynek {
    private String nazwa;
    private Waluta waluta;
    private double marzaProcentowa;

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
