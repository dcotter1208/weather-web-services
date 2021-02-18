package com.weather.rest.webservice.weatherwebservices;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RestController;


//Controller
//@RestController makes this a REST Controller that can handle REST requests
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WeatherController {

    @GetMapping(path = "weather/{location}")
    public Weather currentWeather(@PathVariable String location) {
        return new Weather(String.format("%s", location), 5, "icon/url");
    }
}
