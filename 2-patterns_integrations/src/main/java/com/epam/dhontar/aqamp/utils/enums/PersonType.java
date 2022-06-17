package com.epam.dhontar.aqamp.utils.enums;

public enum PersonType {
    AUTHOR("Authors/"),
    USER("Users/");

    private final String pathValue;

    PersonType(String pathValue) {
        this.pathValue = pathValue;
    }

    public String getValue() {
        return pathValue;
    }
}
