package pl.example.model;

import pl.example.model.client.ExampleWeatherClient;
import pl.example.model.client.WeatherClient;

public class WeatherServiceFactory { // factory allows getting object instance without knowledge how it's actually created

    public static WeatherService createWeatherService() {
        return new WeatherService(createWeatherClient());
    }

    private static WeatherClient createWeatherClient() {
        return new ExampleWeatherClient();
    }
}
