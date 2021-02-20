package com.weather.rest.webservice.weatherwebservices;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RestController;

 import javax.websocket.DeploymentException;
 import java.net.URISyntaxException;

//@RestController makes this a REST Controller that can handle REST requests
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "weather-forecast/{lat}/{lon}")
    public Weather forecast(@PathVariable String lat, @PathVariable String lon) throws JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(WeatherController.class);
        logger.info(lat);
        logger.info(lon);
        return weatherService.getWeather(lat, lon);
    }
}
