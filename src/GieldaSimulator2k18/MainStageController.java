package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class MainStageController {
    @FXML
    private Button OpenControlPanelButton;
    @FXML
    private ListView<Aktywa> MainListView;

    private Swiat swiat = new Swiat();
    private Random random = new Random();

    /**
     *
     *
     * @throws IOException
     */
    @FXML
    private void OpenControlPanel() throws IOException {
        swiat.getListaWalut().add(new Waluta(random));
        swiat.getListaWalut().add(new Waluta(random));
        swiat.getListaWalut().add(new Waluta(random));
        for (int i=0;i<2;i++)
        {
            swiat.getListaSpolek().add(new Spolka(random));
            swiat.getListaParWalut().add(new ParaWalut(random,swiat.getListaWalut().get(random.nextInt(swiat.getListaWalut().size())),swiat.getListaWalut().get(random.nextInt(swiat.getListaWalut().size()))));
            swiat.getListaSurowcow().add(new Surowiec(random,swiat.getListaWalut()));
        }
        ObservableList<Aktywa> list = FXCollections.observableArrayList();
        MainListView.setItems(list);

        for (int i=0; i<swiat.getListaSpolek().size(); i++){
            list.add(swiat.getListaSpolek().get(i));
        }
        for (int i=0; i<swiat.getListaParWalut().size(); i++){
            list.add(swiat.getListaParWalut().get(i));
        }
        for (int i=0; i<swiat.getListaSurowcow().size(); i++){
            list.add(swiat.getListaSurowcow().get(i));
        }
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ControlPanel.fxml"));
        stage.setTitle("Panel kontrolny");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.setScene(new Scene(loader.load()));

        ControlPanelController controller = loader.getController();
        controller.initData(swiat,list);

        stage.show();
    }

    @FXML
    private void ShowElementInformation() throws IOException {
        if (MainListView.getSelectionModel().getSelectedItem()!=null) {
            System.out.println("clicked on " + MainListView.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AktywaInformationPreview.fxml"));
            stage.setTitle(MainListView.getSelectionModel().getSelectedItem() + " - informacje");
            stage.setMinWidth(640);
            stage.setMinHeight(480);
            stage.setScene(new Scene(loader.load()));

            AktywaInformationPreviewController controller = loader.getController();
            controller.initData(MainListView.getSelectionModel().getSelectedItem());

            stage.show();
        }
    }
}
