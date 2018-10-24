package com.example.entity;

import java.io.Serializable;

public class Mobile implements Serializable {
    private String mobileNumber;
    private int isBlacklisted;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getIsBlacklisted() {
        return isBlacklisted;
    }

    public void setIsBlacklisted(int isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }
}
