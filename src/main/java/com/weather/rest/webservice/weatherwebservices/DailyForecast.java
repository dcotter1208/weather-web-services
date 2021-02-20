package com.weather.rest.webservice.weatherwebservices;

public class DailyForecast {
    private Double maxTemp;
    private String icon;
    private String description;

    public DailyForecast(Double maxTemp, String icon, String description) {
        this.maxTemp = maxTemp;
        this.icon = icon;
        this.description = description;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
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
