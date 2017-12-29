package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.time.format.DateTimeFormatter;

public class ObjectInformationPreviewController {
    @FXML
    private ListView<String> InformationListView;

    private Object object;
    private ObservableList<String> list;

    @FXML
    private void DeleteObject(){

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
    }

    private void initWaluta(Waluta waluta){
    }

    private void initPodmiotInwestujacy(PodmiotInwestujacy podmiotInwestujacy){
    }

    private void initFunduszInwestycyjny(FunduszInwestycyjny funduszInwestycyjny){
    }

    private void initInwestor(Inwestor inwestor){
    }

    private void initRynek(Rynek rynek){
    }

    private void initGieldaPapierowWartosciowych(GieldaPapierowWartosciowych gieldaPapierowWartosciowych){
    }

    private void initRynekWalutowoSurowcowy(RynekWalutowoSurowcowy rynekWalutowoSurowcowy){
    }

    private void initIndeks(Indeks indeks){
    }

    private void initIndeksNajwiekszychSpolek(IndeksNajwiekszychSpolek indeksNajwiekszychSpolek){
    }
}
