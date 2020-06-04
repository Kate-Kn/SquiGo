package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private void createButton(){
        Button button=new Button();
        mainPane.getChildren().add(button);
    }
}
