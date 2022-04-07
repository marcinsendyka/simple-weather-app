package pl.example.model;

import pl.example.model.client.WeatherClient;

public class WeatherService { // this is main class of this project

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) { // accepting WeatherClient in constructor inverts dependency. also allows to easy test it
        this.weatherClient = weatherClient;
    }

    public Weather getWeather(String cityName) {
        return weatherClient.currentWeather(cityName);
    }
}
