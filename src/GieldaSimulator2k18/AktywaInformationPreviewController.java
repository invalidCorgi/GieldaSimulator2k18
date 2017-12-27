package GieldaSimulator2k18;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AktywaInformationPreviewController {
    @FXML
    private ListView<String> InformationListView;

    public void initData(Aktywa aktywa){
        ObservableList<String> list = FXCollections.observableArrayList();
        InformationListView.setItems(list);
        list.add("Nazwa: "+aktywa.getNazwa());
        list.add("Data pierwszej wyceny: "+aktywa.getDataPierwszejWyceny());
        list.add("Kurs aktualny: "+aktywa.getKursAktualny());
        list.add("Kurs otwarcia: "+aktywa.getKursOtwarcia());
        list.add("Kurs minimalny: "+aktywa.getKursMinimalny());
        list.add("Kurs maksymalny: "+aktywa.getKursMaksymalny());
        list.add("Wolumen: "+aktywa.getWolumen());
        list.add("Obroty: "+aktywa.getObroty());
        if (Surowiec.class.isInstance(aktywa)){
            Surowiec surowiec = (Surowiec) aktywa;
            list.add("Jednostka handlowa: "+surowiec.getJednostkaHandlowa());
            list.add("Waluta notowania: "+surowiec.getWalutaNotowania());
        }
        if (Spolka.class.isInstance(aktywa)){
            Spolka spolka = (Spolka) aktywa;
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
    }
}
