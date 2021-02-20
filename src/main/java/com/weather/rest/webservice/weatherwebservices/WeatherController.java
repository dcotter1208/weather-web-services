package com.weather.rest.webservice.weatherwebservices;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "weather-forecast")
    public Weather forecast(@RequestParam String lat, @RequestParam String lon, @RequestParam String key) throws JsonProcessingException {
        return weatherService.getWeather(lat, lon, key);
    }
}
