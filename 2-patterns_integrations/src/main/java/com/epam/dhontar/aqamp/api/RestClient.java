package com.epam.dhontar.aqamp.api;

import com.epam.dhontar.aqamp.entity.Person;
import com.epam.dhontar.aqamp.utils.enums.PersonType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.epam.dhontar.aqamp.utils.enums.ServicesEndpoints.API_BASE_URL;
import static io.restassured.RestAssured.given;

public class RestClient {
    public Response getEntityById(PersonType personType, int id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(API_BASE_URL.getValue() + personType.getValue() + id);
    }

    public Response deleteEntity(PersonType personType, int id) {
        return given()
            .contentType(ContentType.JSON)
            .when()
            .delete(API_BASE_URL.getValue() + personType.getValue() + id);
    }

    public Response postEntity(PersonType personType, Person personObject) {
        try {
            return given()
                .contentType(ContentType.JSON)
                .body(personObject.toJson())
                .when()
                .post(API_BASE_URL.getValue() + personType.getValue());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
