package pl.example.model.client;

import pl.example.model.Weather;

import java.util.List;

public interface WeatherClient {

    Weather currentWeather(String cityName);

    List<Weather> weatherForecast(String cityName);
}
