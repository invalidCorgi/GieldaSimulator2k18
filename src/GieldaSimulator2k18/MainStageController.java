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

    private Swiat swiat;
    private Random random;
    private ObservableList<Aktywa> list;

    /**
     *
     *
     * @throws IOException
     */
    @FXML
    private void OpenControlPanel() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ControlPanel.fxml"));
        stage.setTitle("Panel kontrolny");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.setScene(new Scene(loader.load()));

        ControlPanelController controller = loader.getController();
        controller.initData(swiat,list,random);

        stage.show();
    }

    @FXML
    private void ShowElementInformation() throws IOException, InterruptedException {
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

    public void initData(){
        list = FXCollections.observableArrayList();
        MainListView.setItems(list);
        swiat = new Swiat();
        random = new Random();
    }
}
