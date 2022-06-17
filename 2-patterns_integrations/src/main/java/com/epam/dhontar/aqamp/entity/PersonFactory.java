package com.epam.dhontar.aqamp.entity;

import com.epam.dhontar.aqamp.utils.enums.PersonType;

public class PersonFactory {
    public static Person createPerson(PersonType personType, int id) {
        return switch (personType) {
            case USER -> new User.Builder(id).build();
            case AUTHOR -> new Author.Builder(id).build();
        };
    }
}

