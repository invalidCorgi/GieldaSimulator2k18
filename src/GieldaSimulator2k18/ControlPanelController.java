package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
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
        lista.addAll(swiat.getListaGield());
        lista.addAll(swiat.getListaRynkowWalutowoSurowcowych());
        lista.addAll(swiat.getListaWalut());
        lista.addAll(swiat.getListaSpolek());
        lista.addAll(swiat.getListaSurowcow());
        lista.addAll(swiat.getListaParWalut());
        lista.addAll(swiat.getListaIndeksow());
        lista.addAll(swiat.getListaInwestorow());
        lista.addAll(swiat.getListaFunduszyInwestycyjnych());

        MainListView.setItems(lista);
    }

    @FXML
    private void dodajGielde(){
        if (swiat.getListaWalut().size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Musi istnieć co najmniej jedna waluta");
            alert.show();
        }
        else {
            try {
                GieldaPapierowWartosciowych gielda = new GieldaPapierowWartosciowych(random, swiat.getListaWalut().get(random.nextInt(swiat.getListaWalut().size())));
                swiat.getListaGield().add(gielda);
                lista.add(gielda);
            }
            catch (Exception ex){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nie możesz utworzyć więcej giełd");
                alert.show();
            }
        }
    }

    @FXML
    private void dodajIndeks() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IndeksCreation.fxml"));
        stage.setTitle("Tworzenie Indeksów");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.setScene(new Scene(loader.load()));

        IndeksCreationController controller = loader.getController();
        controller.initData(swiat, lista);

        stage.show();
    }

    @FXML
    private void dodajWalute(){
        try {
            Waluta waluta = new Waluta(random);
            for (int i = 0; i < swiat.getListaRynkowWalutowoSurowcowych().size(); i++) {
                ParaWalut paraWalut  = new ParaWalut(random, swiat.getListaRynkowWalutowoSurowcowych().get(i).getWaluta(), waluta);
                swiat.getListaRynkowWalutowoSurowcowych().get(i).getListaParWalut().add(paraWalut);
                swiat.getListaParWalut().add(paraWalut);
                listaMain.add(paraWalut);
                lista.add(paraWalut);
            }
            RynekWalutowoSurowcowy rynekWalutowoSurowcowy = new RynekWalutowoSurowcowy(random, waluta);
            waluta.setRynekWalutowoSurowcowy(rynekWalutowoSurowcowy);
            for (int i = 0; i < swiat.getListaWalut().size(); i++) {
                ParaWalut paraWalut = new ParaWalut(random, waluta, swiat.getListaWalut().get(i));
                rynekWalutowoSurowcowy.getListaParWalut().add(paraWalut);
                swiat.getListaParWalut().add(paraWalut);
                listaMain.add(paraWalut);
                lista.add(paraWalut);
            }
            swiat.getListaRynkowWalutowoSurowcowych().add(rynekWalutowoSurowcowy);
            swiat.getListaWalut().add(waluta);
            lista.add(waluta);
            lista.add(rynekWalutowoSurowcowy);

            try {
                stworzPodmiotInwestujacy();
            }
            catch (Exception ignored){

            }
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nie możesz utworzyć więcej walut");
            alert.show();
        }
    }

    @FXML
    private void dodajSpolke(){
        if (swiat.getListaGield().size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Musi istnieć co najmniej jedna giełda");
            alert.show();
        }
        else {
            try {
                Spolka spolka = new Spolka(random);
                swiat.getListaGield().get(random.nextInt(swiat.getListaGield().size())).getListaSpolek().add(spolka);
                swiat.getListaSpolek().add(spolka);
                lista.add(spolka);
                listaMain.add(spolka);
            }
            catch (Exception ex){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nie możesz utworzyć więcej spółek");
                alert.show();
            }
        }
    }

    @FXML
    private void dodajSurowiec(){
        if (swiat.getListaWalut().size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Musi istnieć co najmniej jedna waluta");
            alert.show();
        }
        else {
            try {
                Surowiec surowiec = new Surowiec(random, swiat.getListaWalut());
                for (int i = 0; i < swiat.getListaRynkowWalutowoSurowcowych().size(); i++) {
                    if (swiat.getListaRynkowWalutowoSurowcowych().get(i).getWaluta() == surowiec.getWalutaNotowania()) {
                        swiat.getListaRynkowWalutowoSurowcowych().get(i).getListaSurowcow().add(surowiec);
                        break;
                    }
                }
                surowiec.getWalutaNotowania().getRynekWalutowoSurowcowy().getListaSurowcow().add(surowiec);
                swiat.getListaSurowcow().add(surowiec);
                lista.add(surowiec);
                listaMain.add(surowiec);
            }
            catch (Exception ex){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nie możesz utworzyć więcej surowców");
                alert.show();
            }
        }
    }

    @FXML
    private void ShowElementInformation() throws IOException {
        if (MainListView.getSelectionModel().getSelectedItem()!=null) {
            System.out.println("clicked on " + MainListView.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ObjectInformationPreview.fxml"));
            stage.setTitle(MainListView.getSelectionModel().getSelectedItem() + " - informacje");
            stage.setMinWidth(640);
            stage.setMinHeight(480);
            stage.setScene(new Scene(loader.load()));

            ObjectInformationPreviewController controller = loader.getController();
            controller.initData(MainListView.getSelectionModel().getSelectedItem());

            stage.show();
        }
    }

    private void stworzPodmiotInwestujacy() throws Exception {
        PodmiotInwestujacy podmiotInwestujacy;
        if (random.nextInt(1)==0){
            podmiotInwestujacy = new Inwestor(random);
            swiat.getListaInwestorow().add((Inwestor) podmiotInwestujacy);
        }
        else {
            podmiotInwestujacy = new FunduszInwestycyjny(random);
            swiat.getListaFunduszyInwestycyjnych().add((FunduszInwestycyjny) podmiotInwestujacy);
        }
        Thread thread = new Thread(podmiotInwestujacy);
        podmiotInwestujacy.setThread(thread);
        thread.start();
    }

}
