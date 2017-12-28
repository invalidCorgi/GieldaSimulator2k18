package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.Random;

public class ControlPanelController {
    @FXML
    private ListView<Object> MainListView;

    private ObservableList<Object> lista;
    private ObservableList<Aktywa> listaMain;
    private Random random;
    private Swiat swiat;

    public void initData(Swiat swiat, ObservableList<Aktywa> listaMain, Random random){
        this.swiat = swiat;
        this.random = random;
        this.listaMain = listaMain;
        lista = FXCollections.observableArrayList();
        for (int i=0;i<swiat.getListaGield().size();i++){
            lista.add(swiat.getListaGield().get(i));
        }
        for (int i=0;i<swiat.getListaRynkowWalutowoSurowcowych().size();i++){
            lista.add(swiat.getListaRynkowWalutowoSurowcowych().get(i));
        }
        for (int i=0;i<swiat.getListaWalut().size();i++){
            lista.add(swiat.getListaWalut().get(i));
        }
        for (int i=0;i<swiat.getListaSpolek().size();i++){
            lista.add(swiat.getListaSpolek().get(i));
        }
        for (int i=0;i<swiat.getListaSurowcow().size();i++){
            lista.add(swiat.getListaSurowcow().get(i));
        }
        for (int i=0;i<swiat.getListaParWalut().size();i++){
            lista.add(swiat.getListaParWalut().get(i));
        }
        for (int i=0;i<swiat.getListaIndeksow().size();i++){
            lista.add(swiat.getListaIndeksow().get(i));
        }
        for (int i=0;i<swiat.getListaInwestorow().size();i++){
            lista.add(swiat.getListaInwestorow().get(i));
        }
        for (int i=0;i<swiat.getListaFunduszyInwestycyjnych().size();i++){
            lista.add(swiat.getListaFunduszyInwestycyjnych().get(i));
        }



        MainListView.setItems(lista);
    }

    @FXML
    private void dodajGielde(){
        if (swiat.getListaWalut().size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Musi istnieć co najmniej jedna waluta");
            alert.show();
        }
        else {
            GieldaPapierowWartosciowych gielda = new GieldaPapierowWartosciowych(random,swiat.getListaWalut().get(random.nextInt(swiat.getListaWalut().size())));
            swiat.getListaGield().add(gielda);
            lista.add(gielda);
        }
    }

    @FXML
    private void dodajIndeks(){

    }

    @FXML
    private void dodajWalute(){
        Waluta waluta = new Waluta(random);
        for (int i=0;i<swiat.getListaRynkowWalutowoSurowcowych().size();i++){
            swiat.getListaRynkowWalutowoSurowcowych().get(i).getListaParWalut().add(new ParaWalut(random,swiat.getListaRynkowWalutowoSurowcowych().get(i).getWaluta(),waluta));
        }
        RynekWalutowoSurowcowy rynekWalutowoSurowcowy = new RynekWalutowoSurowcowy(random,waluta);
        for (int i=0;i<swiat.getListaWalut().size();i++){
            rynekWalutowoSurowcowy.getListaParWalut().add(new ParaWalut(random,waluta,swiat.getListaWalut().get(i)));
        }
        swiat.getListaRynkowWalutowoSurowcowych().add(rynekWalutowoSurowcowy);
        swiat.getListaWalut().add(waluta);
        lista.add(waluta);
        lista.add(rynekWalutowoSurowcowy);
    }

    @FXML
    private void dodajSpolke(){
        if (swiat.getListaGield().size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Musi istnieć co najmniej jedna giełda");
            alert.show();
        }
        else {
            Spolka spolka = new Spolka(random);
            swiat.getListaGield().get(random.nextInt(swiat.getListaGield().size())).getListaSpolek().add(spolka);
            swiat.getListaSpolek().add(spolka);
            lista.add(spolka);
            listaMain.add(spolka);
        }
    }

    @FXML
    private void dodajSurowiec(){
        if (swiat.getListaWalut().size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Musi istnieć co najmniej jedna waluta");
            alert.show();
        }
        else {
            Surowiec surowiec = new Surowiec(random,swiat.getListaWalut());
            for (int i=0;i<swiat.getListaRynkowWalutowoSurowcowych().size();i++){
                if (swiat.getListaRynkowWalutowoSurowcowych().get(i).getWaluta()==surowiec.getWalutaNotowania()){
                    swiat.getListaRynkowWalutowoSurowcowych().get(i).getListaSurowcow().add(surowiec);
                    break;
                }
            }
            swiat.getListaSurowcow().add(surowiec);
            lista.add(surowiec);
            listaMain.add(surowiec);
        }
    }

}
