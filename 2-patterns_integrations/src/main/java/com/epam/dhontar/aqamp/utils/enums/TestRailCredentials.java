package com.epam.dhontar.aqamp.utils.enums;

public enum TestRailCredentials {
    TESTRAIL_USER("dimahtest@gmail.com"),
    TESTRAIL_PWD("?pKSTr8ApHo8MJGk"),
    TESTRAIL_URL("https://aqadmitry.testrail.io/");

    private final String constantValue;

    TestRailCredentials(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getValue() {
        return constantValue;
    }
}