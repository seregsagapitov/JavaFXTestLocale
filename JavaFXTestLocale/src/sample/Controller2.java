package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller2 {


    @FXML
    private AnchorPane AnchorPain2;

    @FXML
    private Button buttonWin3;

    @FXML
    private Button buttonWinMain;

    @FXML
    void GoToWin3(ActionEvent event) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample3.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        ((Stage) AnchorPain2.getScene().getWindow()).setScene(scene);
    }

    @FXML
    void GoToWinMain(ActionEvent event) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sampleMain.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        ((Stage) AnchorPain2.getScene().getWindow()).setScene(scene);
    }
}

