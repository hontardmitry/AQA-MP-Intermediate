package com.epam.dhontar.aqamp.utils.enums;

public enum RestEndpoints {
    AUTHORS("Authors/"),
    USERS("Users/");

    private final String urlValue;

    RestEndpoints(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getValue() {
        return urlValue;
    }
}
