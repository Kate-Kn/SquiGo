//package sample;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//
//public class Controller  implements Initializable {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button Play_Button;
//
//    void Play(ActionEvent event) {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/sample/sample2.fxml"));
//        try {
//            loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Parent root = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
//    }
//
//    @FXML
//    private Button Exit_Button;
//
//    void Exit(ActionEvent event) {
//        Platform.exit();
//    }
//
//    @FXML
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Exit_Button.setOnAction(this::Exit);
//        Play_Button.setOnAction(this::Play);
//
//    }
//}
