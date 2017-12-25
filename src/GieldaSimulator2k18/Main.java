package GieldaSimulator2k18;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        primaryStage.setTitle("Giełda Symulator 2k18");
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(480);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Swiat swiat = new Swiat();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
