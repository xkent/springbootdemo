package com.example.entity;

import com.example.commons.Myjob;

import java.io.Serializable;


public class City implements Serializable {

    private int id;
    private Myjob myjob;

    public City() {
    }

    public City(int id, String cityName, String province, String description) {
        this.id = id;
        this.cityName = cityName;
        this.province = province;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String cityName;
    private String province;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


}
