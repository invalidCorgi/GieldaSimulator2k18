package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObjectInformationPreviewController {
    @FXML
    private ListView<String> InformationListView;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button wykupAkcjeButton;
    @FXML
    private TextField liczbaAkcjiTextField;
    @FXML
    private TextField cenaWykupuTextField;

    private Object object;
    private ObservableList<String> list;
    private ObservableList<Aktywa> mainListViewObservableList;
    private ObservableList<Object> controlPanelListViewObservableList;
    private Swiat swiat;

    /**
     * Usuniecie inwestora, funduszu inwestycyjnego lub spolki jesli nie ma jej na zadnym indeksie
     */

    @FXML
    private void DeleteObject(){
        if (PodmiotInwestujacy.class.isInstance(object)){
            PodmiotInwestujacy podmiotInwestujacy = (PodmiotInwestujacy) object;
            podmiotInwestujacy.getThread().interrupt();
            PodmiotInwestujacy.getWykorzystywaneImionaNazwiska().remove(podmiotInwestujacy.getImie() + " " + podmiotInwestujacy.getNazwisko());
            if (FunduszInwestycyjny.class.isInstance(object)){
                FunduszInwestycyjny funduszInwestycyjny = (FunduszInwestycyjny) object;
                swiat.getListaFunduszyInwestycyjnych().remove(funduszInwestycyjny);
            }
            if (Inwestor.class.isInstance(object)){
                Inwestor inwestor = (Inwestor) object;
                swiat.getListaInwestorow().remove(inwestor);
            }
            controlPanelListViewObservableList.remove(podmiotInwestujacy);
        }
        if (Spolka.class.isInstance(object)){
            Spolka spolka = (Spolka) object;
            if (spolka.getListaIndeksow().size() == 0) {
                spolka.getThread().interrupt();
                swiat.getListaSpolek().remove(spolka);
                spolka.getGielda().getListaSpolek().remove(spolka);
                Spolka.getNazwy().add(spolka.getNazwa());
                mainListViewObservableList.remove(spolka);
                controlPanelListViewObservableList.remove(spolka);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nie można usunąć spółki należącej do indeksu");
                alert.show();
            }
        }
    }

    /**
     * Reczne wykupienie akcji spolki
     */

    @FXML
    private void wykupAkcje(){
        try {
            int ilosc = Integer.parseInt(liczbaAkcjiTextField.getText());
            double cena = Double.parseDouble(cenaWykupuTextField.getText());
            Spolka spolka = (Spolka) object;
            int liczbaAkcji = spolka.getLiczbaAkcji() - ilosc;
            if (liczbaAkcji<0)
                liczbaAkcji=0;
            spolka.setLiczbaAkcji(liczbaAkcji);
            spolka.setKursAktualny(cena);
            spolka.getHistoriaKursu().add(new WpisHistorii(LocalDateTime.now(),cena));
            if (cena > spolka.getKursMaksymalny())
                spolka.setKursMaksymalny(cena);
            if (cena < spolka.getKursMinimalny())
                spolka.setKursMinimalny(cena);
            list.clear();
            initAktywa(spolka);
            initSpolka(spolka);
        }
        catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wprowadź liczbę w polu tekstowym");
            alert.show();
        }
    }

    /**
     *
     * Inicjalizacja okna informacjami o obiekcie
     *
     * @param object obiekt ktorego informacje sa do wyswietlenia
     * @param aktywaObservableList lista aktywow z okna glownego
     * @param objectObservableList lista obiektow z panelu kontrolnego
     * @param swiat swiat do symulacji
     */

    public void initData(Object object, ObservableList<Aktywa> aktywaObservableList, ObservableList<Object> objectObservableList, Swiat swiat){
        this.object = object;
        this.swiat = swiat;
        mainListViewObservableList = aktywaObservableList;
        controlPanelListViewObservableList = objectObservableList;
        list = FXCollections.observableArrayList();
        InformationListView.setItems(list);
        if (Aktywa.class.isInstance(object)){
            initAktywa((Aktywa) object);
            if (Spolka.class.isInstance(object)){
                initSpolka((Spolka) object);
            }
            if (Surowiec.class.isInstance(object)){
                initSurowiec((Surowiec) object);
            }
            if (ParaWalut.class.isInstance(object)){
                initParaWalut((ParaWalut) object);
            }
        }
        if (Waluta.class.isInstance(object)){
            initWaluta((Waluta) object);
        }
        if (PodmiotInwestujacy.class.isInstance(object)){
            initPodmiotInwestujacy((PodmiotInwestujacy) object);
            if (FunduszInwestycyjny.class.isInstance(object)){
                initFunduszInwestycyjny((FunduszInwestycyjny) object);
            }
            if (Inwestor.class.isInstance(object)){
                initInwestor((Inwestor) object);
            }
        }
        if (Rynek.class.isInstance(object)) {
            initRynek((Rynek) object);
            if (GieldaPapierowWartosciowych.class.isInstance(object)) {
                initGieldaPapierowWartosciowych((GieldaPapierowWartosciowych) object);
            }
            if (RynekWalutowoSurowcowy.class.isInstance(object)){
                initRynekWalutowoSurowcowy((RynekWalutowoSurowcowy) object);
            }
        }
        if (Indeks.class.isInstance(object)){
            initIndeks((Indeks) object);
            if (IndeksNajwiekszychSpolek.class.isInstance(object)){
                initIndeksNajwiekszychSpolek((IndeksNajwiekszychSpolek) object);
            }
        }
    }

    /**
     *
     * @param aktywa aktywa do przedstawienia
     */

    private void initAktywa(Aktywa aktywa){
        list.add("Nazwa: "+aktywa.getNazwa());
        list.add("Data pierwszej wyceny: "+aktywa.getDataPierwszejWyceny().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        list.add("Kurs aktualny: "+aktywa.getKursAktualny());
        list.add("Kurs otwarcia: "+aktywa.getKursOtwarcia());
        list.add("Kurs minimalny: "+aktywa.getKursMinimalny());
        list.add("Kurs maksymalny: "+aktywa.getKursMaksymalny());
        list.add("Wolumen: "+aktywa.getWolumen());
        list.add("Obroty: "+aktywa.getObroty());
    }

    /**
     *
     * @param spolka spolka do przedstawienia
     */

    private void initSpolka(Spolka spolka){
        DeleteButton.setDisable(false);
        wykupAkcjeButton.setDisable(false);
        list.add("Liczba akcji: "+spolka.getLiczbaAkcji());
        list.add("Zysk: "+spolka.getZysk());
        list.add("Przychód: "+spolka.getPrzychod());
        list.add("Kapitał zakładowy: "+spolka.getKapitalZakladowy());
        list.add("Kapitał własny: "+spolka.getKapitalWlasny());
        if (spolka.getListaIndeksow().size()>0) {
            list.add("Nalezy do indeksów:");
            for (int i=0;i<spolka.getListaIndeksow().size();i++){
                list.add(spolka.getListaIndeksow().get(i).toString());
            }
        }
    }

    /**
     *
     * @param surowiec surowiec do przedstawienia
     */

    private void initSurowiec(Surowiec surowiec){
        list.add("Jednostka handlowa: "+surowiec.getJednostkaHandlowa());
        list.add("Waluta notowania: "+surowiec.getWalutaNotowania());
    }

    /**
     *
     * @param paraWalut para walut do przedstawienia
     */

    private void initParaWalut(ParaWalut paraWalut){
        list.add("Główna waluta: " + paraWalut.getGlownaWaluta());
        list.add("Druga waluta: " + paraWalut.getDrugaWaluta());
    }

    /**
     *
     * @param waluta waluta do przedstawienia
     */

    private void initWaluta(Waluta waluta){
        list.add("Nazwa: " + waluta.getNazwa());
        list.add("Lista krajów płatniczych:");
        list.addAll(waluta.getKrajePlatnicze());
    }

    /**
     *
     * @param podmiotInwestujacy podmiot inwestujacy do przedstawienia
     */

    private void initPodmiotInwestujacy(PodmiotInwestujacy podmiotInwestujacy){
        DeleteButton.setDisable(false);
        list.add("Imie: " + podmiotInwestujacy.getImie());
        list.add("Nazwisko: " + podmiotInwestujacy.getNazwisko());
    }

    /**
     *
     * @param funduszInwestycyjny fundusz inwestycyjny do przedstawienia
     */

    private void initFunduszInwestycyjny(FunduszInwestycyjny funduszInwestycyjny){
        list.add("Nazwa: " + funduszInwestycyjny.getNazwa());
    }

    /**
     *
     * @param inwestor inwestor do przedstawienia
     */

    private void initInwestor(Inwestor inwestor){
        list.add("PESEL: " + inwestor.getPesel());
        list.add("Budżet: " + inwestor.getBudzet());
    }

    /**
     *
     * @param rynek rynek do przedstawienia
     */

    private void initRynek(Rynek rynek){
        list.add("Nazwa: " + rynek.getNazwa());
        list.add("Waluta: " + rynek.getWaluta());
        list.add("Marża procentowa: " + rynek.getMarzaProcentowa() + "%");
    }

    /**
     *
     * @param gieldaPapierowWartosciowych gielda do przedstawienia
     */

    private void initGieldaPapierowWartosciowych(GieldaPapierowWartosciowych gieldaPapierowWartosciowych){
        list.add("Kraj: " + gieldaPapierowWartosciowych.getKraj());
        list.add("Miasto: " + gieldaPapierowWartosciowych.getMiasto());
        list.add("Adres siedziby: " + gieldaPapierowWartosciowych.getAdresSiedziby());
        list.add("Lista spółek:");
        for (int i=0; i<gieldaPapierowWartosciowych.getListaSpolek().size();i++){
            list.add(gieldaPapierowWartosciowych.getListaSpolek().get(i).toString());
        }
        list.add("Lista indeksów:");
        for (int i=0; i<gieldaPapierowWartosciowych.getListaIndeksow().size();i++){
            list.add(gieldaPapierowWartosciowych.getListaIndeksow().get(i).toString());
        }
    }

    /**
     *
     * @param rynekWalutowoSurowcowy rynek walutowy do przedstawienia
     */

    private void initRynekWalutowoSurowcowy(RynekWalutowoSurowcowy rynekWalutowoSurowcowy){
        list.add("Lista par walut:");
        for (int i=0; i<rynekWalutowoSurowcowy.getListaParWalut().size();i++){
            list.add(rynekWalutowoSurowcowy.getListaParWalut().get(i).toString());
        }
        list.add("Lista surowców:");
        for (int i=0; i<rynekWalutowoSurowcowy.getListaSurowcow().size();i++){
            list.add(rynekWalutowoSurowcowy.getListaSurowcow().get(i).toString());
        }
    }

    /**
     *
     * @param indeks indeks do przedstawienia
     */

    private void initIndeks(Indeks indeks){
        list.add("Nazwa: " + indeks.getNazwa());
        list.add("Giełda: " + indeks.getGielda());
        list.add("Łączna wartość: " + indeks.getLacznaWartosc());
        list.add("Lista spółek:");
        for (int i=0;i<indeks.getListaSpolek().size();i++){
            list.add(indeks.getListaSpolek().get(i).toString());
        }
    }

    /**
     *
     * @param indeksNajwiekszychSpolek indeks najwiekszych spolek do przestawienia
     */

    private void initIndeksNajwiekszychSpolek(IndeksNajwiekszychSpolek indeksNajwiekszychSpolek){
        list.add("Ilość spółek: " + indeksNajwiekszychSpolek.getIloscSpolek());
    }
}
