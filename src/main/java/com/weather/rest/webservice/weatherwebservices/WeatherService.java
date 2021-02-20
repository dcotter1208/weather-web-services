package com.weather.rest.webservice.weatherwebservices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    private static final String OPEN_WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/onecall?";
    private static final WebClient.Builder webClientBuilder = WebClient.builder();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Weather getWeather(String lat, String lon, String key) throws JsonProcessingException {
                /*
        1. Builder pattern to create a client
        2. get() to define what type of call - GET
        3. retrieve - the function that performs the fetch
        4. bodyToMono - whatever body you get back convert it to an instance of Weather class.
                        Mono meaning you'll get an object back sometime in the future (async/promise)
        5.
        */

        String constructedURL = OPEN_WEATHER_BASE_URL + "lat=" + lat + "&lon=" + lon + "&exclude=minutely,hourly,alerts" + "&units=imperial" + "&appid=" + key;
        String openWeatherResponse = webClientBuilder.build().get().uri(constructedURL).retrieve().bodyToMono(String.class).block();

        return constructWeather(openWeatherResponse);
    }

        Weather constructWeather(String response) throws JsonProcessingException {
            JsonNode root = objectMapper.readTree(response);
            Integer temp = root.path("current").path("temp").asInt();
            String icon = root.path("current").path("weather").get(0).path("icon").asText();
            String icon_url = String.format("http://openweathermap.org/img/wn/%s@2x.png", icon);
            String description = root.path("current").path("weather").get(0).path("description").asText();
            JsonNode dailyNode = root.path("daily");
            ArrayList<DailyForecast> dailyForecast = constructDailyForecast(dailyNode);
            Weather weather = new Weather(temp, icon_url, description, dailyForecast);

            return weather;
        }

    ArrayList<DailyForecast> constructDailyForecast(JsonNode dailyNode) {
            ArrayList<DailyForecast> list = new ArrayList<>();
            if (dailyNode.isArray()) {
                int daysInFuture = 1;
                for (JsonNode jsonNode : dailyNode) {
                    Integer maxTemp = jsonNode.path("temp").path("max").asInt();
                    String icon = jsonNode.path("weather").get(0).path("icon").asText();
                    String icon_url = String.format("http://openweathermap.org/img/wn/%s@2x.png", icon);
                    String description = jsonNode.path("weather").get(0).path("description").asText();
                    String day = dayOfWeek(daysInFuture);
                    daysInFuture++;
                    DailyForecast dailyForecast = new DailyForecast(maxTemp, icon_url, description, day);
                    list.add(dailyForecast);
                }
            }
            return list;
        }

        String dayOfWeek(Integer daysInFuture) {
            String today = LocalDate.now().toString();
            LocalDate date = LocalDate
                    .parse(today)
                    .plusDays(daysInFuture);
            String dayOfWeek = DayOfWeek.from(date).name().toLowerCase();
            String capDayOfWeek = dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
            
            return capDayOfWeek;
        }

    }
