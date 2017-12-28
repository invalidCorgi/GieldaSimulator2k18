/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author wojtekreg
 */
public abstract class Aktywa {
    private String nazwa;
    private LocalDateTime dataPierwszejWyceny;
    private double kursOtwarcia;
    private double kursMinimalny;
    private double kursMaksymalny;
    private double kursAktualny;
    private double wolumen;
    private double obroty;
    private List<WpisHistorii> historiaKursu;
    private int liczbaKupujacych;
    private int liczbaSprzedajacych;

    public Aktywa(Random random) {
        dataPierwszejWyceny = LocalDateTime.now();
        kursOtwarcia = random.nextDouble()*10;
        kursMinimalny = kursOtwarcia;
        kursMaksymalny = kursOtwarcia;
        kursAktualny = kursOtwarcia;
        wolumen = 0;
        obroty = 0;
        historiaKursu = new ArrayList<>();
        historiaKursu.add(new WpisHistorii(dataPierwszejWyceny,kursOtwarcia));
        liczbaKupujacych = 0;
        liczbaSprzedajacych = 0;
    }

    public Aktywa(Random random, List<String> nazwy) {
        this(random);
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
     * Gets dataPierwszejWyceny
     *
     * @return dataPierwszejWyceny
     */
    public LocalDateTime getDataPierwszejWyceny() {
        return dataPierwszejWyceny;
    }

    /**
     * Sets dataPierwszejWyceny
     *
     * @param dataPierwszejWyceny dataPierwszejWyceny to set
     */
    public void setDataPierwszejWyceny(LocalDateTime dataPierwszejWyceny) {
        this.dataPierwszejWyceny = dataPierwszejWyceny;
    }

    /**
     * Gets kursOtwarcia
     *
     * @return kursOtwarcia
     */
    public Double getKursOtwarcia() {
        return kursOtwarcia;
    }

    /**
     * Sets kursOtwarcia
     *
     * @param kursOtwarcia kursOtwarcia to set
     */
    public void setKursOtwarcia(Double kursOtwarcia) {
        this.kursOtwarcia = kursOtwarcia;
    }

    /**
     * Gets kursMinimalny
     *
     * @return kursMinimalny
     */
    public Double getKursMinimalny() {
        return kursMinimalny;
    }

    /**
     * Sets kursMinimalny
     *
     * @param kursMinimalny kursMinimalny to set
     */
    public void setKursMinimalny(Double kursMinimalny) {
        this.kursMinimalny = kursMinimalny;
    }

    /**
     * Gets kursMaksymalny
     *
     * @return kursMaksymalny
     */
    public Double getKursMaksymalny() {
        return kursMaksymalny;
    }

    /**
     * Sets kursMaksymalny
     *
     * @param kursMaksymalny kursMaksymalny to set
     */
    public void setKursMaksymalny(Double kursMaksymalny) {
        this.kursMaksymalny = kursMaksymalny;
    }

    /**
     * Gets kursAktualny
     *
     * @return kursAktualny
     */
    public Double getKursAktualny() {
        return kursAktualny;
    }

    /**
     * Sets kursAktualny
     *
     * @param kursAktualny kursAktualny to set
     */
    public void setKursAktualny(Double kursAktualny) {
        this.kursAktualny = kursAktualny;
    }

    /**
     * Gets wolumen
     *
     * @return wolumen
     */
    public Double getWolumen() {
        return wolumen;
    }

    /**
     * Sets wolumen
     *
     * @param wolumen wolumen to set
     */
    public void setWolumen(Double wolumen) {
        this.wolumen = wolumen;
    }

    /**
     * Gets obroty
     *
     * @return obroty
     */
    public Double getObroty() {
        return obroty;
    }

    /**
     * Sets obroty
     *
     * @param obroty obroty to set
     */
    public void setObroty(Double obroty) {
        this.obroty = obroty;
    }

    /**
     * Gets historiaKursu
     *
     * @return historiaKursu
     */
    public List<WpisHistorii> getHistoriaKursu() {
        return historiaKursu;
    }

    /**
     * Sets historiaKursu
     *
     * @param historiaKursu historiaKursu to set
     */
    public void setHistoriaKursu(List<WpisHistorii> historiaKursu) {
        this.historiaKursu = historiaKursu;
    }

    /**
     * Gets liczbaKupujacych
     *
     * @return liczbaKupujacych
     */
    public int getLiczbaKupujacych() {
        return liczbaKupujacych;
    }

    /**
     * Sets liczbaKupujacych
     *
     * @param liczbaKupujacych liczbaKupujacych to set
     */
    public void setLiczbaKupujacych(int liczbaKupujacych) {
        this.liczbaKupujacych = liczbaKupujacych;
    }

    /**
     * Gets liczbaSprzedajacych
     *
     * @return liczbaSprzedajacych
     */
    public int getLiczbaSprzedajacych() {
        return liczbaSprzedajacych;
    }

    /**
     * Sets liczbaSprzedajacych
     *
     * @param liczbaSprzedajacych liczbaSprzedajacych to set
     */
    public void setLiczbaSprzedajacych(int liczbaSprzedajacych) {
        this.liczbaSprzedajacych = liczbaSprzedajacych;
    }

}
