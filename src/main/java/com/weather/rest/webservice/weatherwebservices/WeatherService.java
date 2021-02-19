package com.weather.rest.webservice.weatherwebservices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    private static final String BASE_WEATHER_URL = "http://api.weatherstack.com/";
    private static final String API_KEY = "";
    private static final WebClient.Builder webClientBuilder = WebClient.builder();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Weather getCurrentWeather(String location) throws JsonProcessingException {
        /*
        1. Builder pattern to create a client
        2. get() to define what type of call - GET
        3. retrieve - the function that performs the fetch
        4. bodyToMono - whatever body you get back convert it to an instance of Weather class.
                        Mono meaning you'll get an object back sometime in the future (async/promise)
        5.
        */
        String constructedURL = BASE_WEATHER_URL + "current?access_key=" + API_KEY + "&units=f" + "&query=" + location;
        String weatherStackResponse = webClientBuilder.build().get().uri(constructedURL).retrieve().bodyToMono(String.class).block();
        return constructedJSON(weatherStackResponse);
        }

        Weather constructedJSON(String response) throws JsonProcessingException {
            JsonNode root = objectMapper.readTree(response);
            String location = root.path("location").path("name").asText();
            Double temp = root.path("current").path("temperature").asDouble();
            String icon_url = root.path("current").path("weather_icons").path(0).asText();
            Weather weather = new Weather(location, temp, icon_url);

            return weather;
        }
    }