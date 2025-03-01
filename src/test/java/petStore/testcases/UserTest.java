package petStore.testcases;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petStore.endpoints.userEndpoint;
import petStore.payloads.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserTest {

    Faker fake;
    user userPayload;
    public static Logger logger;

    @BeforeClass
    public void generateUserTestData()
    {
        fake = new Faker();
        userPayload = new user();

        userPayload.setUserId(fake.idNumber().hashCode());
        userPayload.setUsername(fake.name().username());
        userPayload.setFirstName(fake.name().firstName());
        userPayload.setLastName(fake.name().lastName());
        userPayload.setEmail(fake.internet().emailAddress());
        userPayload.setPassword(fake.internet().password(5,10));
        userPayload.setPhone(fake.phoneNumber().phoneNumber());

        logger = LogManager.getLogger("petStoreAutomation");
    }

    @Test(priority = 1, invocationCount = 50)
    public void testCreateUser()
    {
           Response response = userEndpoint.createUser(userPayload);

        //log response
           response.then().log().all();

           //validation
           Assert.assertEquals(response.getStatusCode(), 200);

           //log
        logger.info("Create User executed");
    }


    @Test(priority = 2)
    public void testGetUser()
    {
        Response response = userEndpoint.getUser(this.userPayload.getUsername());

        //log response
        System.out.println("-------------------Get Data");
        response.then().log().all();

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Get User executed");
    }

    @Test(priority = 3)
    public void testUpdateUser()
    {
        userPayload.setFirstName(fake.name().firstName());
        Response response = userEndpoint.putUser(this.userPayload.getUsername(),userPayload);

        //log response
        System.out.println("------------------Update Data");
        response.then().log().all();

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //read data again to verify that the data gets changed or not.
        testGetUser();

        //log
        logger.info("Update User executed");
    }

    @Test(priority = 4)
    public void testDeleteUser()
    {
        Response response = userEndpoint.deleteUser(this.userPayload.getUsername());

        //log response
        response.then().log().all();

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.warn("User will deleted");
    }
}
