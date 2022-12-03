package ca.uvic.seng330.ex4.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("pressure")
    private double pressure;

    @JsonProperty("humidity")
    private double humidity;

    @JsonProperty("temp_min")
    private double tempMin;

    @JsonProperty("temp_max")
    private double tempMax;

    @JsonProperty("feels_like")
    private double feelsLike;

    // Is only created by Jackson when JSON data is parsed
    private WeatherInfo() {}

    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getMinTemp() {
        return tempMin;
    }

    public double getMaxTemp() {
        return tempMax;
    }

    public double getPerceptualTemp() {
        return feelsLike;
    }
}
