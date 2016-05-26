package com.agyl.recyclergus.models;
/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class FoldersContentListViewData {
    private String firstName;
    private String lastName;
    private String street;
    private String weatherNumber;
    private String weatherText;

    public FoldersContentListViewData(String street,
                                      String firstName,
                                      String lastName,
                                      String weatherNumber,
                                      String weatherText) {
        this.street = street;
        this.lastName = lastName;
        this.firstName = firstName;
        this.weatherNumber = weatherNumber;
        this.weatherText = weatherText;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getWeatherNumber() {
        return weatherNumber;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public String getStreet() {
        return street;
    }

}
