package com.weather.rest.webservice.weatherwebservices;

public class DailyForecast {
    private Integer maxTemp;
    private String icon;
    private String description;

    public DailyForecast(Integer maxTemp, String icon, String description) {
        this.maxTemp = maxTemp;
        this.icon = icon;
        this.description = description;
    }

    public Integer getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Integer maxTemp) {
        this.maxTemp = maxTemp;
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
