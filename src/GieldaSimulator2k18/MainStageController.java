package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStageController {
    @FXML
    private Button OpenControlPanelButton;
    @FXML
    private ListView<String> MainListView;

    private Swiat swiat = new Swiat();

    @FXML
    private void OpenControlPanel() throws IOException {
        swiat.getListaWalut().add(new Waluta("złoty"));
        swiat.getListaWalut().add(new Waluta("dolar"));
        ObservableList<String> list = FXCollections.observableArrayList();
        MainListView.setItems(list);

        for (int i=0; i<swiat.getListaWalut().size(); i++){
            list.add(swiat.getListaWalut().get(i).getNazwa());
        }
        Stage stage = new Stage();
        //Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "ControlPanel.fxml"
                )
        );
        stage.setTitle("Panel kontrolny");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.setScene(new Scene(loader.load()));

        ControlPanelController controller =
                loader.<ControlPanelController>getController();
        controller.initData(swiat,list);

        stage.show();
    }
}
