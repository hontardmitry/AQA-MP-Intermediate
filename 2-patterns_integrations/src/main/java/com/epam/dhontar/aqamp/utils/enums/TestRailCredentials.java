package com.epam.dhontar.aqamp.utils.enums;

public enum TestRailCredentials {
    TESTRAIL_USER("dimahtest1@gmail.com"),
    TESTRAIL_PWD("?pKSTr8ApHo8MJGk"),
    TESTRAIL_URL("https://aqampdhon.testrail.io/");

    private final String constantValue;

    TestRailCredentials(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getValue() {
        return constantValue;
    }
}
