package com.weather.rest.webservice.weatherwebservices;
import java.util.ArrayList;

public class Weather {
    private CurrentWeather current;
    private ArrayList<DailyForecast> forecast;

    public Weather(CurrentWeather current, ArrayList<DailyForecast> forecast) {
        this.current = current;
        this.forecast = forecast;
    }

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public ArrayList<DailyForecast> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<DailyForecast> forecast) {
        this.forecast = forecast;
    }
}
