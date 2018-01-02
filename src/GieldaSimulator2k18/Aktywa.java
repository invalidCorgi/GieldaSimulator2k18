/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author wojtekreg
 */
public abstract class Aktywa implements Serializable{
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

    public Aktywa(Random random, List<String> nazwy) throws Exception {
        this(random);
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
     * Gets dataPierwszejWyceny
     *
     * @return dataPierwszejWyceny
     */
    public LocalDateTime getDataPierwszejWyceny() {
        return dataPierwszejWyceny;
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
     * Gets kursMinimalny
     *
     * @return kursMinimalny
     */
    public synchronized Double getKursMinimalny() {
        return kursMinimalny;
    }

    /**
     * Sets kursMinimalny
     *
     * @param kursMinimalny kursMinimalny to set
     */
    public synchronized void setKursMinimalny(Double kursMinimalny) {
        this.kursMinimalny = kursMinimalny;
    }

    /**
     * Gets kursMaksymalny
     *
     * @return kursMaksymalny
     */
    public synchronized Double getKursMaksymalny() {
        return kursMaksymalny;
    }

    /**
     * Sets kursMaksymalny
     *
     * @param kursMaksymalny kursMaksymalny to set
     */
    public synchronized void setKursMaksymalny(Double kursMaksymalny) {
        this.kursMaksymalny = kursMaksymalny;
    }

    /**
     * Gets kursAktualny
     *
     * @return kursAktualny
     */
    public synchronized Double getKursAktualny() {
        return kursAktualny;
    }

    /**
     * Sets kursAktualny
     *
     * @param kursAktualny kursAktualny to set
     */
    public synchronized void setKursAktualny(Double kursAktualny) {
        this.kursAktualny = kursAktualny;
    }

    /**
     * Gets wolumen
     *
     * @return wolumen
     */
    public synchronized Double getWolumen() {
        return wolumen;
    }

    /**
     * Sets wolumen
     *
     * @param wolumen wolumen to set
     */
    public synchronized void setWolumen(Double wolumen) {
        this.wolumen = wolumen;
    }

    /**
     * Gets obroty
     *
     * @return obroty
     */
    public synchronized Double getObroty() {
        return obroty;
    }

    /**
     * Sets obroty
     *
     * @param obroty obroty to set
     */
    public synchronized void setObroty(Double obroty) {
        this.obroty = obroty;
    }

    /**
     * Gets historiaKursu
     *
     * @return historiaKursu
     */
    public synchronized List<WpisHistorii> getHistoriaKursu() {
        return historiaKursu;
    }

    /**
     * Gets liczbaKupujacych
     *
     * @return liczbaKupujacych
     */
    public synchronized int getLiczbaKupujacych() {
        return liczbaKupujacych;
    }

    /**
     * Sets liczbaKupujacych
     *
     * @param liczbaKupujacych liczbaKupujacych to set
     */
    public synchronized void setLiczbaKupujacych(int liczbaKupujacych) {
        this.liczbaKupujacych = liczbaKupujacych;
    }

    /**
     * Gets liczbaSprzedajacych
     *
     * @return liczbaSprzedajacych
     */
    public synchronized int getLiczbaSprzedajacych() {
        return liczbaSprzedajacych;
    }

    /**
     * Sets liczbaSprzedajacych
     *
     * @param liczbaSprzedajacych liczbaSprzedajacych to set
     */
    public synchronized void setLiczbaSprzedajacych(int liczbaSprzedajacych) {
        this.liczbaSprzedajacych = liczbaSprzedajacych;
    }

}
