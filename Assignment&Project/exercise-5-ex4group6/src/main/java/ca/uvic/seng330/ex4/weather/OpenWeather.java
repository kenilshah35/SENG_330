package ca.uvic.seng330.ex4.weather;

import ca.uvic.seng330.ex4.utils.HttpClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class OpenWeather implements Weather {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        @JsonProperty("main")
        WeatherInfo main;

        @JsonProperty("cod")
        int code;
    }

    private static final String DEFAULT_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String DEFAULT_TOKEN = "e56939f8409b3bca5c56164b20bf96a1";

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private HttpClient client;

    public OpenWeather() {
        this(DEFAULT_URL, DEFAULT_TOKEN);
    }

    public OpenWeather(String url, String apiToken) {
        Map<String, Object> params = param("appid", apiToken);
        params.put("units", "metric");
        this.client = new HttpClient(url, params);
    }

    private static Map<String, Object> param(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    private static WeatherInfo processRequest(HttpRequest request) throws Exception {
        String value = request.execute().parseAsString();
        Response data = MAPPER.readValue(value, Response.class);
        return data.main;
    }

    public WeatherInfo fetchByCity(String city) throws Exception {
        return processRequest(this.client.get("weather", param("q", city)));
    }

    public WeatherInfo fetchByLatLng(double lat, double lng) throws Exception {
        Map<String, Object> params = param("lat", lat);
        params.put("lon", lng);
        return processRequest(this.client.get("weather", params));
    }
}
