package GieldaSimulator2k18;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Swiat swiat;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainStage.fxml"));
        stage.setTitle("Giełda Simulator 2k18");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.setScene(new Scene(loader.load(),640,480));
        swiat = new Swiat();
        stage.setOnCloseRequest(event -> {
            zatrymajSymulacje(swiat);
            Platform.exit();
        });

        MainStageController controller = loader.getController();
        controller.initData(swiat);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * zatrzymuje wszystkie watki w symulacji
     *
     * @param swiat swiat symulacji do zatrzymania
     */

    public static void zatrymajSymulacje(Swiat swiat){
        for (int i=0; i<swiat.getListaFunduszyInwestycyjnych().size();i++){
            swiat.getListaFunduszyInwestycyjnych().get(i).getThread().interrupt();
        }
        for (int i=0; i<swiat.getListaInwestorow().size();i++){
            swiat.getListaInwestorow().get(i).getThread().interrupt();
        }
        for (int i=0; i<swiat.getListaSpolek().size(); i++){
            swiat.getListaSpolek().get(i).getThread().interrupt();
        }
    }
}
