package pl.example.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherServiceBadTest {


    @Test
    void serviceShouldReturnNotNullWeather() {
        // given
        var weatherService = mock(WeatherService.class);
        when(weatherService.getWeather("City")).thenReturn(weather());

        // when
        CurrentWeatherAndForecast result = weatherService.getWeather("City"); //main test line should not call mock, real object have to be called!

        // then
         assertThat(result).isNotNull();// only null is checked, but assertion could be more specific

    }

    private CurrentWeatherAndForecast weather() {
        return new CurrentWeatherAndForecast(new Weather("City", 10, LocalDate.now()), List.of());
    }
}