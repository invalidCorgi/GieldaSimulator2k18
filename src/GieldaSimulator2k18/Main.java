package GieldaSimulator2k18;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        primaryStage.setTitle("Giełda Symulator 2k18");
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(480);
        primaryStage.setScene(new Scene(root,640,480));
        primaryStage.show();*/
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainStage.fxml"));
        stage.setTitle("Giełda Simulator 2k18");
        stage.setMinWidth(700);
        stage.setMinHeight(480);
        stage.setScene(new Scene(loader.load(),700,480));

        MainStageController controller = loader.getController();
        controller.initData();

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
