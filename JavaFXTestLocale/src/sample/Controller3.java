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
import java.util.ResourceBundle;


public class Controller3 {


    ResourceBundle resourceBundle;
    @FXML
    private AnchorPane AnchorPain3;
    @FXML
    private Button buttonWin3;

    @FXML
    private Button buttonWinMain;

    @FXML
    void GoToWin2(ActionEvent event) {
        Parent root = null;
        resourceBundle = ResourceBundle.getBundle(Main.BUNDLES_FOLDER, LocaleManager.currentLanguage.getLocale());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"), resourceBundle);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        ((Stage) AnchorPain3.getScene().getWindow()).setScene(scene);
    }


    @FXML
    void GoToWinMain(ActionEvent event) {
        Main main = new Main();
        resourceBundle = ResourceBundle.getBundle(Main.BUNDLES_FOLDER);
        main.createGUI(LocaleManager.currentLanguage.getLocale());
    }

}

