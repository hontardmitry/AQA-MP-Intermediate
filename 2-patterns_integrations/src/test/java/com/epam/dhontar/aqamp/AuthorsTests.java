package com.epam.dhontar.aqamp;


import static com.epam.dhontar.aqamp.utils.enums.ServicesEndpoints.AUTHORS_URL;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.dhontar.aqamp.api.RestClient;
import com.epam.dhontar.aqamp.entity.Author;
import com.epam.dhontar.aqamp.utils.integrations.testrail.TestRails;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;

@Listeners({ReportPortalTestNGListener.class})
public class AuthorsTests extends BaseTest {

    private static final int AUTHOR_ID = 11;
    private static final int ID_BOOK = 11;
    private static final String FIRST_NAME = "User Name";
    private static final String LAST_NAME = "password";

    private final RestClient authorClient = new RestClient(AUTHORS_URL);

    @Test(priority = 5)
    @TestRails(id = "4")
    public void getAuthorById() {
        Response response = authorClient.getEntityById(5);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
        assertThat(response.as(Author.class).getId()).isEqualTo(5);
    }

    @Test(priority = 4)
    @TestRails(id = "5")
    public void createAuthor() {
        Author author = new Author
            .AuthorBuilder(AUTHOR_ID, ID_BOOK)
            .withFirstName(FIRST_NAME)
            .withLastName(LAST_NAME)
            .build();
        Response response = authorClient.postEntity(author);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
        assertThat(response.as(Author.class).getId()).isEqualTo(AUTHOR_ID);
    }

    @Ignore
    @Test(priority = 6)
    @TestRails(id = "6")
    public void deleteAuthor() {
        Response response = authorClient.deleteEntity(5);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
    }
}
