package pl.example.model.client;

import pl.example.model.Weather;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class ExampleWeatherClient implements WeatherClient {

    private static final Random RANDOM = new Random();

    @Override
    public Weather currentWeather(String cityName) {
        return randomWeather(cityName);
    }

    @Override
    public List<Weather> weatherForecast(String cityName) {
        LocalDate now = LocalDate.now(Clock.systemDefaultZone());
        return List.of(randomWeather(cityName, now.plusDays(1)), randomWeather(cityName, now.plusDays(2)));
    }

    private Weather randomWeather(String cityName, LocalDate date) {
        return new Weather(cityName, randomNumber(), date);
    }

    private Weather randomWeather(String cityName) {
        return new Weather(cityName, randomNumber(), LocalDate.now());
    }

    private int randomNumber() {
        return RANDOM.nextInt(45);
    }

}
