package pl.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pl.example.model.Weather;
import pl.example.model.WeatherService;
import pl.example.model.WeatherServiceFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable { // Controller is the glue code between business logic and user interface

    private final String fxmlName;

    @FXML
    private Button checkWeatherButton;
    @FXML
    private Label temperature;
    @FXML
    private Label temperatureLabel;

    private WeatherService weatherService;

    public MainViewController(String fxmlName) {
        this.fxmlName = fxmlName;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
        temperature.setVisible(false);
        temperatureLabel.setVisible(false);
    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }

    @FXML
    public void checkWeatherAction() {
        // GET DATA INPUT FROM USER
        String homeCity = "Kraków"; // get actual city name from text input

        // INVOKE BUSINESS LOGIC / MODEL
        Weather weather = weatherService.getWeather(homeCity);

        // DISPLAY RESULT FROM BUSINESS LOGIC
        displayWeather(weather);
    }

    public void displayWeather(Weather weatherForecast) {
        temperature.setVisible(true);
        temperatureLabel.setVisible(true);
        temperature.setText("" + weatherForecast.getTempInCelsius());
    }

}
