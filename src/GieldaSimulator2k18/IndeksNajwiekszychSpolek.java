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
public class IndeksNajwiekszychSpolek extends Indeks{
    private int iloscSpolek;

    /**
     * Gets iloscSpolek
     *
     * @return iloscSpolek
     */
    public int getIloscSpolek() {
        return iloscSpolek;
    }

    /**
     * Sets iloscSpolek
     *
     * @param iloscSpolek iloscSpolek to set
     */
    public void setIloscSpolek(int iloscSpolek) throws NieMaTyleSpolekException {
        if (iloscSpolek>getGielda().getListaSpolek().size())
            throw new NieMaTyleSpolekException();
        this.iloscSpolek = iloscSpolek;
    }


}
