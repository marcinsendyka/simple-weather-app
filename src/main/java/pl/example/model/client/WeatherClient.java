package pl.example.model.client;

import pl.example.model.Weather;

public interface WeatherClient {
    Weather currentWeather(String cityName);
}
