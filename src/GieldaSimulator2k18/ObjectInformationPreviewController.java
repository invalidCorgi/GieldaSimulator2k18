package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.time.format.DateTimeFormatter;

public class ObjectInformationPreviewController {
    @FXML
    private ListView<String> InformationListView;
    @FXML
    private Button DeleteButton;

    private Object object;
    private ObservableList<String> list;
    private Swiat swiat;

    @FXML
    private void DeleteObject(){
        if (PodmiotInwestujacy.class.isInstance(object)){
            PodmiotInwestujacy podmiotInwestujacy = (PodmiotInwestujacy) object;
            PodmiotInwestujacy.getWykorzystywaneImionaNazwiska().remove(podmiotInwestujacy.getImie() + " " + podmiotInwestujacy.getNazwisko());
            if (FunduszInwestycyjny.class.isInstance(object)){
                FunduszInwestycyjny funduszInwestycyjny = (FunduszInwestycyjny) object;
                swiat.getListaFunduszyInwestycyjnych().remove(funduszInwestycyjny);
            }
            if (Inwestor.class.isInstance(object)){
                Inwestor inwestor = (Inwestor) object;
                swiat.getListaInwestorow().remove(inwestor);
            }
            podmiotInwestujacy.getThread().interrupt();
        }
        if (Spolka.class.isInstance(object)){
            Spolka spolka = (Spolka) object;
            swiat.getListaSpolek().remove(spolka);
            Spolka.getNazwy().add(spolka.getNazwa());
        }
    }

    public void initData(Object object){
        this.object = object;
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

    private void initSpolka(Spolka spolka){
        DeleteButton.setDisable(false);
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

    private void initSurowiec(Surowiec surowiec){
        list.add("Jednostka handlowa: "+surowiec.getJednostkaHandlowa());
        list.add("Waluta notowania: "+surowiec.getWalutaNotowania());
    }

    private void initParaWalut(ParaWalut paraWalut){
        list.add("Główna waluta: " + paraWalut.getGlownaWaluta());
        list.add("Druga waluta: " + paraWalut.getDrugaWaluta());
    }

    private void initWaluta(Waluta waluta){
        list.add("Nazwa: " + waluta.getNazwa());
        list.add("Lista krajów płatniczych:");
        list.addAll(waluta.getKrajePlatnicze());
    }

    private void initPodmiotInwestujacy(PodmiotInwestujacy podmiotInwestujacy){
        DeleteButton.setDisable(false);
        list.add("Imie: " + podmiotInwestujacy.getImie());
        list.add("Nazwisko: " + podmiotInwestujacy.getNazwisko());
    }

    private void initFunduszInwestycyjny(FunduszInwestycyjny funduszInwestycyjny){
        list.add("Nazwa: " + funduszInwestycyjny.getNazwa());
    }

    private void initInwestor(Inwestor inwestor){
        list.add("PESEL: " + inwestor.getPesel());
        list.add("Budżet: " + inwestor.getBudzet());
    }

    private void initRynek(Rynek rynek){
        list.add("Nazwa: " + rynek.getNazwa());
        list.add("Waluta: " + rynek.getWaluta());
        list.add("Marża procentowa: " + rynek.getMarzaProcentowa() + "%");
    }

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

    private void initIndeks(Indeks indeks){
        list.add("Nazwa: " + indeks.getNazwa());
        list.add("Giełda: " + indeks.getGielda());
        list.add("Łączna wartość: " + indeks.getLacznaWartosc());
        list.add("Lista spółek:");
        for (int i=0;i<indeks.getListaSpolek().size();i++){
            list.add(indeks.getListaSpolek().get(i).toString());
        }
    }

    private void initIndeksNajwiekszychSpolek(IndeksNajwiekszychSpolek indeksNajwiekszychSpolek){
        list.add("Ilość spółek: " + indeksNajwiekszychSpolek.getIloscSpolek());
    }
}
