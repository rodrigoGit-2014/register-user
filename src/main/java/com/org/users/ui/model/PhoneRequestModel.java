package com.org.users.ui.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneRequestModel {

    private long number;
    @JsonProperty("citycode")
    private int cityCode;
    @JsonProperty("countrycode")
    private int countryCode;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
}
