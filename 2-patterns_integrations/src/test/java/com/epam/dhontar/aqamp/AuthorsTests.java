package com.epam.dhontar.aqamp;


import com.epam.dhontar.aqamp.entity.Author;
import com.epam.dhontar.aqamp.entity.PersonFactory;
import com.epam.dhontar.aqamp.utils.integrations.testrail.TestRails;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.dhontar.aqamp.utils.enums.PersonType.AUTHOR;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners({ReportPortalTestNGListener.class})
public class AuthorsTests extends BaseTest {

    private static final int AUTHOR_ID = 11;
    private static final int ID_BOOK = 11;
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";


    @Test(priority = 5)
    @TestRails(id = "5")
    public void getAuthorById() {
        Response response = restClient.getEntityById(AUTHOR,5);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
        assertThat(response.as(Author.class).getId()).isEqualTo(5);
    }

    @Test(priority = 4)
    @TestRails(id = "6")
    public void createAuthor(){
        Author authorEntity = ((Author) PersonFactory.createPerson(AUTHOR, AUTHOR_ID))
            .getBuilder()
            .withIdBook(ID_BOOK)
            .withFirstName(FIRST_NAME)
            .withLastName(LAST_NAME)
            .build();
        Response response = restClient.postEntity(AUTHOR, authorEntity);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
        assertThat(response.as(Author.class).getId()).isEqualTo(AUTHOR_ID);
    }

//    @Ignore
    @Test(priority = 6)
    @TestRails(id = "7")
    public void deleteAuthor() {
        Response response = restClient.deleteEntity(AUTHOR,5);
        assertThat(response.statusCode()).as("Status code").isEqualTo(SC_OK);
    }
}
