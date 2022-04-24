package com.epam.dhontar.aqamp;

import static com.epam.dhontar.aqamp.utils.enums.PersonType.USER;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.dhontar.aqamp.entity.PersonFactory;
import com.epam.dhontar.aqamp.entity.User;
import com.epam.dhontar.aqamp.utils.integrations.testrail.TestRails;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;

@Listeners({ReportPortalTestNGListener.class})
public class UsersTests extends BaseTest {
    private static final int USER_ID = 5;
    private static final String USER_NAME = "User Name";
    private static final String USER_PASSWORD = "password";

    @Test(priority = 2)
    @TestRails(id = "1")
    public void getUserById() {
        Response response = restClient.getEntityById(USER,5);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
        assertThat(response.as(User.class).getId()).isEqualTo(5);
    }

    @Test(priority = 1)
    @TestRails(id = "2")
    public void createUser() {
        User userEntity =  ((User) PersonFactory.createPerson(USER, USER_ID))
            .getBuilder()
            .withName(USER_NAME)
            .withPassword(USER_PASSWORD)
            .build();
        Response response = restClient.postEntity(USER, userEntity);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
        assertThat(response.as(User.class).getId()).isEqualTo(USER_ID + 1);
    }

    @Test(priority = 3)
    @TestRails(id = "3")
    public void deleteUser() {
        Response response = restClient.deleteEntity(USER,5);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
    }
}
