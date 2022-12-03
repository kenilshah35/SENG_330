package ca.uvic.seng330.ex4.weather;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import ca.uvic.seng330.ex4.weather.OpenWeather.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.annotation.Retention;
import javax.inject.Inject;
import javax.inject.Qualifier;

public class MockWeather implements Weather {

    @Qualifier
    @Retention(RUNTIME)
    public @interface City {}

    @Qualifier
    @Retention(RUNTIME)
    public @interface Lat {}

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private String cityJson;
    private String latJson;

    @Inject
    public MockWeather(@City String cityJson, @Lat String latJson) {
        this.cityJson = cityJson;
        this.latJson = latJson;
    }

    public WeatherInfo fetchByCity(String city) throws Exception {
        Response data = MAPPER.readValue(cityJson, Response.class);
        return data.main;
    }

    public WeatherInfo fetchByLatLng(double lat, double lng) throws Exception {
        Response data = MAPPER.readValue(latJson, Response.class);
        return data.main;
    }
}
