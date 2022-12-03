package ca.uvic.seng330.ex4.weather;

import com.google.inject.AbstractModule;

public class WeatherModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Weather.class).to(OpenWeather.class);
    }
}
