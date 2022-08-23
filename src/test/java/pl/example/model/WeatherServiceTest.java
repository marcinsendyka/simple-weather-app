package pl.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.example.model.client.WeatherClient;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private WeatherClient weatherClient; // stub can be used instead

    @Test
    void shouldReturnWeatherForecast() { // can be split in two: one for current weather and one for forecast
        // given
        LocalDate date = LocalDate.now();
        Weather expectedCurrentWeather = createWeather(date);
        List<Weather> expectedForecastWeather = List.of(createWeather(date.plusDays(1)), createWeather(date.plusDays(2)));
        when(weatherClient.currentWeather("Kraków"))
                .thenReturn(expectedCurrentWeather);
        when(weatherClient.weatherForecast("Kraków"))
                .thenReturn(expectedForecastWeather);

        // when
        CurrentWeatherAndForecast result = weatherService.getWeather("Kraków");

        // then
        //assertJ way
        assertThat(result.getCurrentWeather())
                .isEqualTo(expectedCurrentWeather);
        assertThat(result.getWeatherForecast()).containsExactlyElementsOf(expectedForecastWeather);
        //junit way
        assertEquals(result.getCurrentWeather(), expectedCurrentWeather);
        assertEquals(result.getWeatherForecast(), expectedForecastWeather);
    }

    @Test
    void shouldThrowFailedToGetWeatherExceptionWhenCannotGetWeather() {
        // given
        when(weatherClient.currentWeather("City")).thenThrow(new RuntimeException());

        // when & then
        assertThatThrownBy(() -> weatherService.getWeather("City"))
                .isInstanceOf(FailedToGetWeatherException.class);
    }

    private Weather createWeather(LocalDate date) {
        return new Weather("Kraków", 10., date);
    }
}
