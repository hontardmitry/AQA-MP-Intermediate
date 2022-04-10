package com.epam.dhontar.aqamp.utils.enums;

public enum ServicesEndpoints {
    BASE_URL("https://fakerestapi.azurewebsites.net/api/v1/"),

    SLACK_API_URL("");

    private final String urlValue;

    ServicesEndpoints(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getValue() {
        return urlValue;
    }
}
