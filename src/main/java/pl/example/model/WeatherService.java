package pl.example.model;

import pl.example.model.client.WeatherClient;

import java.util.List;

public class WeatherService { // this is main class of this project

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) { // accepting WeatherClient in constructor inverts dependency. also allows to easy test it
        this.weatherClient = weatherClient;
    }

    public CurrentWeatherAndForecast getWeather(String cityName) {
        try {
            Weather weather = weatherClient.currentWeather(cityName);
            List<Weather> weatherForecast = weatherClient.weatherForecast(cityName);
            return new CurrentWeatherAndForecast(weather, weatherForecast);
        } catch (Exception e) {
            throw new FailedToGetWeatherException("Failed to get weather", e);
        }

    }
}
