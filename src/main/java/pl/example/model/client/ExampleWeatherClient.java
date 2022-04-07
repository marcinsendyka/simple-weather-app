package pl.example.model.client;

import pl.example.model.Weather;

import java.time.LocalDate;
import java.util.Random;

public class ExampleWeatherClient implements WeatherClient {

    private static final Random RANDOM = new Random();

    @Override
    public Weather currentWeather(String cityName) {
        return new Weather(cityName, randomNumber(), LocalDate.now());
    }

    private int randomNumber() {
        return RANDOM.nextInt(45);
    }

}
