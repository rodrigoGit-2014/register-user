package com.org.users.dto;

import java.io.Serializable;

public class PhoneDTO implements Serializable {

    private long number;
    private int cityCode;
    private int countryCode;

    public PhoneDTO(long number, int cityCode, int countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    public PhoneDTO() {
    }

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
