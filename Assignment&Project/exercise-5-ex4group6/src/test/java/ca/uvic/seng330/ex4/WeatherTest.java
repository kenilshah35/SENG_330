package ca.uvic.seng330.ex4;

import static org.junit.jupiter.api.Assertions.*;

import ca.uvic.seng330.ex4.weather.MockWeather;
import ca.uvic.seng330.ex4.weather.MockWeather.City;
import ca.uvic.seng330.ex4.weather.MockWeather.Lat;
import ca.uvic.seng330.ex4.weather.Weather;
import ca.uvic.seng330.ex4.weather.WeatherInfo;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherTest {

    Weather weather;

    class WeatherTestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Weather.class).to(MockWeather.class);
        }

        @Provides
        @City
        private String provideCity() {
            return "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":10.53,\"feels_like\":5.03,\"temp_min\":9.44,\"temp_max\":12,\"pressure\":996,\"humidity\":76},\"visibility\":10000,\"wind\":{\"speed\":6.7,\"deg\":250,\"gust\":12.3},\"clouds\":{\"all\":0},\"dt\":1603825491,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1603781142,\"sunset\":1603816968},\"timezone\":0,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        }

        @Provides
        @Lat
        private String provideLat() {
            return "{\"coord\":{\"lon\":-123.44,\"lat\":48.66},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":9.2,\"feels_like\":6.14,\"temp_min\":8.89,\"temp_max\":9.44,\"pressure\":1029,\"humidity\":81},\"visibility\":10000,\"wind\":{\"speed\":3.1,\"deg\":160},\"clouds\":{\"all\":90},\"dt\":1603826033,\"sys\":{\"type\":1,\"id\":991,\"country\":\"CA\",\"sunrise\":1603810393,\"sunset\":1603846902},\"timezone\":-25200,\"id\":6090579,\"name\":\"North Saanich\",\"cod\":200}";
        }
    }

    @BeforeEach
    void setup() {
        Injector injector = Guice.createInjector(new WeatherTestModule());
        weather = injector.getInstance(Weather.class);
    }

    @Test
    void testByCity() {
        WeatherInfo info = null;
        try {
            info = weather.fetchByCity("London");
        } catch (Exception ex) {
            fail("Exception was thrown while fetching weather by city");
        }
        assertEquals(info.getTemp(), 10.53);
        assertEquals(info.getPressure(), 996);
        assertEquals(info.getMinTemp(), 9.44);
        assertEquals(info.getMaxTemp(), 12);
        assertEquals(info.getPerceptualTemp(), 5.03);
    }

    @Test
    void testByLatLng() {
        WeatherInfo info = null;
        try {
            info = weather.fetchByLatLng(0, 0);
        } catch (Exception ex) {
            fail("Exception was thrown while fetching weather by lat lng");
        }
        assertEquals(info.getTemp(), 9.2);
        assertEquals(info.getPressure(), 1029);
        assertEquals(info.getMinTemp(), 8.89);
        assertEquals(info.getMaxTemp(), 9.44);
        assertEquals(info.getPerceptualTemp(), 6.14);
    }
}
