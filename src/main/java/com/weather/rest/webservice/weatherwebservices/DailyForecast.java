package com.weather.rest.webservice.weatherwebservices;

public class DailyForecast {
    private Integer maxTemp;
    private String icon;
    private String description;
    private String dayOfWeek;

    public DailyForecast(Integer maxTemp, String icon, String description, String dayOfWeek) {
        this.maxTemp = maxTemp;
        this.icon = icon;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
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

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
