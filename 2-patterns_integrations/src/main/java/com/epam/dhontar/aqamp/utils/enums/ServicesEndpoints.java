package com.epam.dhontar.aqamp.utils.enums;

public enum ServicesEndpoints {
    API_BASE_URL("https://fakerestapi.azurewebsites.net/api/v1/"),
    SLACK_API_URL("https://hooks.slack.com/services/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");

    private final String urlValue;

    ServicesEndpoints(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getValue() {
        return urlValue;
    }
}
