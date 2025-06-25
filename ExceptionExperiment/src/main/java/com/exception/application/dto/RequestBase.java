package com.exception.application.dto;

import com.exception.application.enums.EnumMapper;

public class RequestBase {

    private String name;
        private String numbers;
        private EnumMapper mapUrl;


    public EnumMapper getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(EnumMapper mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public RequestBase(){

    }

    public RequestBase(String name, String numbers, EnumMapper mapUrl) {
        this.name = name;
        this.numbers = numbers;
        this.mapUrl = mapUrl;
    }

    @Override
    public String toString() {
        return "RequestBase{" +
                "name='" + name + '\'' +
                ", numbers='" + numbers + '\'' +
                ", mapUrl=" + mapUrl +
                '}';
    }
}
