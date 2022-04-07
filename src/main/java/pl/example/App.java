package pl.example;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.example.views.ViewFactory;

import java.util.Locale;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Locale.setDefault(new Locale("en"));
        ViewFactory.showMainWindow(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}