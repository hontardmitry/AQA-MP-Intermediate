package com.epam.dhontar.aqamp;

import static java.lang.String.format;

import com.epam.dhontar.aqamp.api.RestClient;
import com.epam.dhontar.aqamp.observer.Chat;
import com.epam.dhontar.aqamp.observer.ChatSubscriber;
import com.epam.dhontar.aqamp.utils.integrations.slack.SlackClient;
import com.epam.dhontar.aqamp.utils.integrations.testrail.TestRails;
import com.epam.dhontar.aqamp.utils.integrations.testrail.bindings.APIException;
import com.epam.dhontar.aqamp.utils.integrations.testrail.bindings.TestRailAPIClient;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseTest {
    RestClient restClient = new RestClient();

    String PROJECT_ID = "1";

    List<ChatSubscriber> subscribers = new ArrayList<>();
    TestRailAPIClient testRailAPIClient = new TestRailAPIClient();

    Chat chat = new Chat();

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        for (int i = 0; i < 2; i++){
            subscribers.add(new ChatSubscriber("Subscriber" + (i + 1)));
            chat.addObserver(subscribers.get(i));
        }
        chat.addObserver(new SlackClient());

        Map <String, Object> data =
            Map.of("include_all", true, "name", "Test Run on " + LocalDateTime.now());

        JSONObject c = (JSONObject) testRailAPIClient.sendPost("add_run/" + PROJECT_ID, data);
        Long suite_id = (Long) c.get("id");
        ctx.setAttribute("suiteId", suite_id);
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = this.getClass().getMethod(method.getName());

        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId", ta.id());
        }
    }

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx, Method method)
        throws IOException, APIException {

        Map<String, Object> data =
            result.isSuccess() ?
                Map.of("status_id", 1) :
                Map.of("status_id", 5, "comment", result.getThrowable().toString());

        if (!result.isSuccess()) {
            chat.addMessage(format("Test %s FAILED with %s", method.getName(), result.getThrowable().toString()));
        }

        String caseId = (String) ctx.getAttribute("caseId");
        Long suiteId = (Long) ctx.getAttribute("suiteId");
        testRailAPIClient.sendPost("add_result_for_case/" + suiteId + "/" + caseId, data);
    }

}
