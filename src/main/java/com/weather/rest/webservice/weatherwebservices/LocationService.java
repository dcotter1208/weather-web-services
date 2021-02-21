package com.weather.rest.webservice.weatherwebservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LocationService {
    private static final String BASE_URL = "https://us1.locationiq.com/v1/search.php?key=%s&format=json&q=%s";
    private static final String KEY = "";
    private static final WebClient.Builder webClientBuilder = WebClient.builder();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Location getCoordinatesFromLocation(String location) throws JsonProcessingException {
        String constructedURL = String.format(BASE_URL, KEY, location);
        String res = webClientBuilder.build().get().uri(constructedURL).retrieve().bodyToMono(String.class).block();

        return constructLocation(res);
    }

    Location constructLocation(String response) throws JsonProcessingException {
        JsonNode root = objectMapper.readTree(response);
        String lat = root.path(0).path("lat").asText();
        String lon = root.path(0).path("lon").asText();

        return new Location(lat, lon);
    }
}
