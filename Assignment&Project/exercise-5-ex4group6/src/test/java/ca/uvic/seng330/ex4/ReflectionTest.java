package ca.uvic.seng330.ex4;

import static org.junit.jupiter.api.Assertions.*;

import ca.uvic.seng330.ex4.utils.HttpClient;
import ca.uvic.seng330.ex4.weather.OpenWeather;
import com.google.api.client.http.GenericUrl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReflectionTest {
    HttpClient client;
    OpenWeather weather = new OpenWeather();

    @BeforeEach
    void setup() {
        client = new HttpClient("https://api.openweathermap.org/data/2.5/");
        weather = new OpenWeather();
    }

    @Test
    void testOpenWeatherDefaultConstructor() {

        try {
            // Use reflection to get private fields
            Field weatherField = OpenWeather.class.getDeclaredField("client");
            Field urlField = HttpClient.class.getDeclaredField("url");
            Field paramsField = HttpClient.class.getDeclaredField("defaultParams");
            Field defaultUrlField = OpenWeather.class.getDeclaredField("DEFAULT_URL");
            Field defaultTokenField = OpenWeather.class.getDeclaredField("DEFAULT_TOKEN");

            // Make the private fields accessible
            weatherField.setAccessible(true);
            urlField.setAccessible(true);
            paramsField.setAccessible(true);
            defaultUrlField.setAccessible(true);
            defaultTokenField.setAccessible(true);

            // Get the private objects
            HttpClient weatherClient = (HttpClient) weatherField.get(weather);
            String url = (String) urlField.get(weatherClient);
            Map<String, Object> params = (Map<String, Object>) paramsField.get(weatherClient);
            String defaultUrl = (String) defaultUrlField.get(null);
            String defaultToken = (String) defaultTokenField.get(null);

            // Sanity check on default construction of OpenWeather
            assertEquals(url, defaultUrl);
            assertEquals(params.get("appid"), defaultToken);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
            fail();
        }
    }

    @Test
    void testOpenWeatherParamBuilder() {
        try {
            // Invoke private method OpenWeather.param
            Method paramMethod =
                    OpenWeather.class.getDeclaredMethod("param", String.class, Object.class);
            paramMethod.setAccessible(true);
            Map<String, Object> map =
                    (Map<String, Object>) paramMethod.invoke(weather, "key", "value");

            // Test values returned
            assertEquals(map.size(), 1);
            assertTrue(map.containsKey("key"));
            assertEquals(map.get("key"), "value");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
            fail();
        }
    }

    @Test
    void testHttpClientUrlBuilder() {
        try {
            // Build map parameter manually
            Map<String, Object> map = new HashMap<>();
            map.put("q", "London");

            // Invoke private method HttpClient.buildUrl
            Method paramMethod =
                    HttpClient.class.getDeclaredMethod("buildUrl", String.class, Map.class);
            paramMethod.setAccessible(true);
            GenericUrl url = (GenericUrl) paramMethod.invoke(client, "weather", map);

            assertEquals(
                    url.toString(), "https://api.openweathermap.org/data/2.5/weather?q=London");

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
            fail();
        }
    }
}
