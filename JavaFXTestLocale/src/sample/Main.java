package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class Main extends Application implements Observer {
// 555
//    public static final String BUNDLES_FOLDER = "bundles.Locale";
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sampleMain.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 400, 400));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
public static final String FXML_MAIN = "sampleMain.fxml";
    public static final String BUNDLES_FOLDER = "sample.bundles.Locale";
    private static Stage primaryStage;
    private Parent fxmlMain;
    private ControllerMain controllerMain;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private FXMLLoader fxmlLoader;

    private AnchorPane currentRoot;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        createGUI(LocaleManager.RU_LOCALE);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update(Observable o, Object arg) {
        Language language = (Language) arg;
        AnchorPane newNode = loadFXML(language.getLocale()); // получить новое дерево компонентов  с нужной локалью
        currentRoot.getChildren().setAll(newNode.getChildren()); // заменить старые дочерние компоненты на новые

    }

    // Загружаем дерево компонентов и возвращаем в виде AnchorPane (корневой элемент в FXML)
    private AnchorPane loadFXML(Locale locale) {
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(FXML_MAIN));
        fxmlLoader.setResources(ResourceBundle.getBundle(BUNDLES_FOLDER, locale));
        AnchorPane node = null;
        try {
            node = (AnchorPane) fxmlLoader.load();
            controllerMain = fxmlLoader.getController();
            controllerMain.addObserver(this);
            primaryStage.setTitle(fxmlLoader.getResources().getString("testJavaLocale"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    private void createGUI(Locale locale) {
        currentRoot = loadFXML(locale);
        Scene scene = new Scene(currentRoot, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }







}
