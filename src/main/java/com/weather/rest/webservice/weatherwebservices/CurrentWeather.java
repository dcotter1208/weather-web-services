package com.weather.rest.webservice.weatherwebservices;

public class CurrentWeather {
    private Integer temp;
    private String icon;
    private String description;

    public CurrentWeather(Integer temp, String icon, String description) {
        this.temp = temp;
        this.icon = icon;
        this.description = description;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
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
}
