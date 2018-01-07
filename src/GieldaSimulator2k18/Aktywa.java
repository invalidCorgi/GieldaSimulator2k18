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
    private Rynek rynek;

    /**
     * Konstruktor losujący wszystkie pola oprócz nazwy
     *
     * @param random instancja Random do wylosowania pól
     * @param rynek Rynek, na którym występuje aktywa
     */

    public Aktywa(Random random, Rynek rynek) {
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
        this.rynek = rynek;
    }

    /**
     * Kontruktor losujący wszystkie pola łącznie z nazwą; w razie zajętych wszystkich nazw rzuca wyjątek
     *
     * @param random instancja Random do wylosowania pól
     * @param nazwy lista nazw, z której jedna będzie wylosowana
     * @param rynek Rynek, na którym występuje aktywa
     * @throws Exception
     */

    public Aktywa(Random random, List<String> nazwy, Rynek rynek) throws Exception {
        this(random, rynek);
        if (nazwy.size()>0) {
            nazwa = nazwy.get(random.nextInt(nazwy.size()));
            nazwy.remove(getNazwa());
        }
        else throw new Exception();
    }

    /**
     *
     * @return nazwa
     */

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
     * Sets rynek
     *
     * @param rynek rynek to set
     */
    protected void setRynek(Rynek rynek) {
        this.rynek = rynek;
    }

    /**
     * Kupienie aktywu przez podmiot inwestujący łącznie ze zmianą kursu aktywu i zmianą budżetu inwestora
     *
     * @param podmiotInwestujacy podmiot inwestujący, który chce kupić Aktywa
     * @return prawda, jeśli możliwe jest kupienie Aktywa, wpp fałsz
     */

    public synchronized boolean kupAktywa(PodmiotInwestujacy podmiotInwestujacy){
        if(FunduszInwestycyjny.class.isInstance(podmiotInwestujacy)) {
            podmiotInwestujacy.getAktywaList().add(this);
            historiaKursu.add(new WpisHistorii(LocalDateTime.now(), kursAktualny));
            liczbaKupujacych++;
            wolumen++;
            obroty+=kursAktualny;
            przeliczKurs();
            return true;
        }
        else{
            Inwestor inwestor = (Inwestor) podmiotInwestujacy;
            double cena = getKursAktualny() * (1 + rynek.getMarzaProcentowa()/100);
            if (inwestor.getBudzet()>cena){
                podmiotInwestujacy.getAktywaList().add(this);
                inwestor.setBudzet(inwestor.getBudzet()-cena);
                historiaKursu.add(new WpisHistorii(LocalDateTime.now(), kursAktualny));
                liczbaKupujacych++;
                wolumen++;
                obroty+=kursAktualny;
                przeliczKurs();
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * Sprzedaż aktywu ze zmianą kursu aktywu i budżetu inwestora
     *
     * @param podmiotInwestujacy podmiot inwestujący chcący sprzedać aktywa
     */

    public synchronized void sprzedajAktywa(PodmiotInwestujacy podmiotInwestujacy){
        historiaKursu.add(new WpisHistorii(LocalDateTime.now(), kursAktualny));
        if (Inwestor.class.isInstance(podmiotInwestujacy)){
            Inwestor inwestor= (Inwestor) podmiotInwestujacy;
            double cena = kursAktualny * (1 - rynek.getMarzaProcentowa()/100);
            inwestor.setBudzet(inwestor.getBudzet()+cena);
        }
        podmiotInwestujacy.getAktywaList().remove(this);
        liczbaSprzedajacych++;
        przeliczKurs();
    }

    /**
     * Przeliczenie kursu w zależności od liczby kupujących i sprzedających aktywa
     */

    private void przeliczKurs(){
        if (liczbaKupujacych == liczbaSprzedajacych){
            kursAktualny=kursOtwarcia;
        }
        if (liczbaKupujacych > liczbaSprzedajacych){
            if (liczbaSprzedajacych==0){
                kursAktualny = kursOtwarcia*Math.pow(1.1, liczbaKupujacych);
            }
            else {
                kursAktualny = kursOtwarcia*liczbaKupujacych/liczbaSprzedajacych;
            }
        }
        if (liczbaSprzedajacych > liczbaKupujacych){
            if (liczbaKupujacych == 0){
                kursAktualny = kursOtwarcia*Math.pow(0.9, liczbaSprzedajacych);
            }
            else {
                kursAktualny = kursOtwarcia*liczbaSprzedajacych/liczbaKupujacych;
            }
        }
        if (kursAktualny>kursMaksymalny)
            kursMaksymalny=kursAktualny;
        if (kursAktualny<kursMinimalny)
            kursMinimalny=kursAktualny;
        if (Spolka.class.isInstance(this)){
            Spolka spolka = (Spolka) this;
            for (int i=0; i<spolka.getListaIndeksow().size(); i++){
                spolka.getListaIndeksow().get(i).updateLacznaWartosc();
            }
        }
    }

}
