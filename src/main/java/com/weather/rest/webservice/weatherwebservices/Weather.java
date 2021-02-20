package com.weather.rest.webservice.weatherwebservices;
import java.util.ArrayList;

public class Weather {
    private Integer temperature;
    private String icon;
    private String description;
    private ArrayList<DailyForecast> forecast;

    public Weather(Integer temperature, String icon, String description, ArrayList<DailyForecast> forecast) {
        this.temperature = temperature;
        this.icon = icon;
        this.description = description;
        this.forecast = forecast;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<DailyForecast> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<DailyForecast> forecast) {
        this.forecast = forecast;
    }
}
