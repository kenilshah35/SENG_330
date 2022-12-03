package ca.uvic.seng330.ex4.weather;

import ca.uvic.seng330.ex4.Observation;

public interface Weather {

    public WeatherInfo fetchByCity(String city) throws Exception;

    public WeatherInfo fetchByLatLng(double lat, double lng) throws Exception;

    default WeatherInfo fetchByObservation(Observation observation) throws Exception {
        return fetchByLatLng(observation.getLatitude(), observation.getLongitude());
    }
}
