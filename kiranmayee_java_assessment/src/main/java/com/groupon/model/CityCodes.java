package com.groupon.model;


public enum CityCodes {
    BANGLORE("BL"),
    HYDERABAD("HY"),
    MUMBAI("MB"),
    CALCUTTA("CL");

    public final String cityCode;

    private CityCodes(String cityCode) {
        this.cityCode = cityCode;
    }
}