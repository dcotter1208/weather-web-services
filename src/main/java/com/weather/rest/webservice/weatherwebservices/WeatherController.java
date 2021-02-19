package com.weather.rest.webservice.weatherwebservices;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RestController;

 import javax.websocket.DeploymentException;
 import java.net.URISyntaxException;

//Controller
//@RestController makes this a REST Controller that can handle REST requests
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "weather/{location}")
    public String currentWeather(@PathVariable String location) throws URISyntaxException, DeploymentException {

        return weatherService.getCurrentWeather(location);
    }
}
