package com.weather.rest.webservice.weatherwebservices;

public class Weather {
    private String location;
    private Double temperature;
    private String icon;

    public Weather(String location, Double temperature, String icon) {
        this.location = location;
        this.temperature = temperature;
        this.icon = icon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
