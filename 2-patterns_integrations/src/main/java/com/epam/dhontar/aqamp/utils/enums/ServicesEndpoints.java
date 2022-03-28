package com.epam.dhontar.aqamp.utils.enums;

public enum ServicesEndpoints {
    //    SITE_URL("https://fakerestapi.azurewebsites.net/index.html"),
    BASE_URL("https://fakerestapi.azurewebsites.net/api/v1/"),
    AUTHORS_URL("Authors/"),
    USERS_URL("Users/"),
    SLACK_API_URL("");

    private final String urlValue;

    ServicesEndpoints(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getValue() {
        return urlValue;
    }
}