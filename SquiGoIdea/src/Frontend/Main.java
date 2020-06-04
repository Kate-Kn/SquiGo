package Frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.SequenceInputStream;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        ViewManager view=new ViewManager();
        stage=view.getStage();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
