package com.epam.dhontar.aqamp.utils.enums;

public enum RestEndpoints {
    AUTHORS("https://fakerestapi.azurewebsites.net/api/v1/Authors/"),
    USERS("https://fakerestapi.azurewebsites.net/api/v1/Users/");

    private final String urlValue;

    RestEndpoints(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getValue() {
        return urlValue;
    }
}
