package pl.example.model;

import java.time.LocalDate;
import java.util.List;

public class CurrentWeatherAndForecast {

    private final Weather currentWeather;
    private final List<Weather> weatherForecast;

    public CurrentWeatherAndForecast(Weather currentWeather, List<Weather> weatherForecast) {
        this.currentWeather = currentWeather;
        this.weatherForecast = weatherForecast;
    }

    public Weather getCurrentWeather() {
        return currentWeather;
    }

    public List<Weather> getWeatherForecast() {
        return weatherForecast;
    }

}
