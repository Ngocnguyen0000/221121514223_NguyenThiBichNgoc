package com.example.a221121514223_nguyenthibichngoc.model;

public class Weather {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDateTime(){return DateTime;}

    public void setDateTime(String dateTime) {DateTime = dateTime;}
    public int getWeatherIcon() {return WeatherIcon;}
    public void setWeatherIcon(int weatherIcon) {WeatherIcon = weatherIcon;}
    public String getIconPhrase() {return IconPhrase;}

    public void setIconPhrase(String iconPhrase){IconPhrase = iconPhrase;}
    public  com.example.a221121514223_nguyenthibichngoc.model.Temperature getTemperature(){return Temperature;}
    public void setTemperature(com.example.a221121514223_nguyenthibichngoc.model.Temperature temperature){Temperature = temperature;}
}
