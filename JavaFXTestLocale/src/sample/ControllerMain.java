package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {

    ResourceBundle resourceBundle;

    @FXML
    private ComboBox<Language> comboLocales;

    @FXML
    private AnchorPane MainAnchorPain;

    @FXML
    private Button buttonWin2;

    @FXML
    private Button buttonWin3;

    public static final String RU_CODE = "ru";
    public static final String EN_CODE = "en";

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
        ((Stage) MainAnchorPain.getScene().getWindow()).setScene(scene);

    }

    @FXML
    void GoToWin2(ActionEvent event) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        ((Stage) MainAnchorPain.getScene().getWindow()).setScene(scene);
    }

    private void fillLangCombobox() {
        Language langRU = new Language(RU_CODE, resourceBundle.getString("ru"), LocaleManager.RU_LOCALE, 0);
        Language langEN = new Language(EN_CODE, resourceBundle.getString("en"), LocaleManager.EN_LOCALE, 1);

        comboLocales.getItems().add(langRU);
        comboLocales.getItems().add(langEN);

        if (LocaleManager.getCurrentLanguage() == null) { // по умолчанию показывать русский язык
            comboLocales.getSelectionModel().select(0);
        } else {
            comboLocales.getSelectionModel().select(LocaleManager.getCurrentLanguage().getIndex());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        fillLangCombobox();
    }
}