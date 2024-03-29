package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.Observable;
import java.util.ResourceBundle;

import static sample.LocaleManager.getCurrentLanguage;

public class ControllerMain extends Observable implements Initializable {

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


    public void listenCombo() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // слушаем изменение языка
                comboLocales.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Language selectedLang = (Language) comboLocales.getSelectionModel().getSelectedItem();
                        LocaleManager.setCurrentLanguage(selectedLang);

                        // уведомить всех слушателей, что произошла смена языка
                        setChanged();
                        notifyObservers(selectedLang);
                        System.out.println("Изменение языка");
                    }
                });

            }
        });
    }

    @FXML
    private void initialize() {
        // resourceBundle = ResourceBundle.getBundle(Main.BUNDLES_FOLDER);
        fillLangCombobox();
        LocaleManager.setCurrentLanguage(comboLocales.getSelectionModel().getSelectedItem());
        listenCombo();


    }

    @FXML
    void GoToWin3(ActionEvent event) {
        Parent root = null;
        ResourceBundle resourceBundle = ResourceBundle.getBundle(Main.BUNDLES_FOLDER, LocaleManager.currentLanguage.getLocale());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample3.fxml"), resourceBundle);

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        ((Stage) buttonWin3.getScene().getWindow()).setScene(scene);

    }

    @FXML
    void GoToWin2(ActionEvent event) {
        Parent root = null;
        ResourceBundle resourceBundle = ResourceBundle.getBundle(Main.BUNDLES_FOLDER, LocaleManager.currentLanguage.getLocale());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"), resourceBundle);

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        ((Stage) buttonWin2.getScene().getWindow()).setScene(scene);
    }

    public void fillLangCombobox() {
        Language langRU = new Language(RU_CODE, resourceBundle.getString("ru"), LocaleManager.RU_LOCALE, 0);
        Language langEN = new Language(EN_CODE, resourceBundle.getString("en"), LocaleManager.EN_LOCALE, 1);

        comboLocales.getItems().add(langRU);
        comboLocales.getItems().add(langEN);

        if (getCurrentLanguage() == null) { // по умолчанию показывать русский язык
            comboLocales.getSelectionModel().select(0);
        } else {
            comboLocales.getSelectionModel().select(getCurrentLanguage().getIndex());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        initialize();
    }
}
