package com.weather.rest.webservice.weatherwebservices;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    private static final String BASE_WEATHER_URL = "http://api.weatherstack.com/current";
    private static final String API_KEY = "";
    private static final String WEATHER_URL = "http://api.weatherstack.com/current?access_key={key}&units=f&query=detroit";
    private static final WebClient.Builder webClientBuilder = WebClient.builder();

    public String getCurrentWeather() {
        /*
        1. Builder pattern to create a client
        2. get() to define what type of call - GET
        3. retrieve - the function that performs the fetch
        4. bodyToMono - whatever body you get back convert it to an instance of Weather class.
                        Mono meaning you'll get an object back sometime in the future (async/promise)
        5.
        */

       String weatherStackResponse = webClientBuilder.build().get().uri(WEATHER_URL).retrieve().bodyToMono(String.class).block();
       return weatherStackResponse;
        }
    }