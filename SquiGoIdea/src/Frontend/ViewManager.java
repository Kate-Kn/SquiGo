package Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.*;

public class ViewManager {
    private Stage stage;
    private Scene scene;
    private AnchorPane mainPane;
    public ViewManager() {
        stage=new Stage();
        mainPane= new AnchorPane();
        scene=new Scene(mainPane);
        stage.setTitle("SquiGo");
        stage.setMaximized(true);
        stage.setScene(scene);
    }
    public Stage getStage(){
        return stage;
    }
}
