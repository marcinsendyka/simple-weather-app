package pl.example.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.example.App;
import pl.example.controller.FxmlDefinedController;
import pl.example.controller.MainViewController;

import java.io.IOException;

public class ViewFactory {

    private static final int MAIN_WINDOW_HEIGHT = 850;
    private static final int MAIN_WINDOW_WIDTH = 1375;

    private static final BorderPane MAIN_VIEW = (BorderPane) loadFXML(new MainViewController("MainView"));
    private static final Scene SCENE = new Scene(MAIN_VIEW);

    public static Parent loadFXML(FxmlDefinedController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/fxml/" + controller.getFxmlName() + ".fxml"));
        fxmlLoader.setController(controller);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error with loadFXML function!");
            return null;
        }
    }

    public static void showMainWindow(Stage primaryStage) {
        primaryStage.setScene(SCENE);
        primaryStage.setMinWidth(MAIN_WINDOW_WIDTH);
        primaryStage.setMinHeight(MAIN_WINDOW_HEIGHT);
        primaryStage.setMaximized(false);
        primaryStage.show();
    }

}
