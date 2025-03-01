package petStore.testcases;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petStore.endpoints.userEndpoint;
import petStore.payloads.user;
import petStore.utilities.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserTestDataDriven {

    user userPayload = new user();
    Faker fake;
    public static Logger logger = LogManager.getLogger("petStoreAutomation");


    @Test(dataProvider = "UserData", dataProviderClass = DataProviders.class, priority = 1)
    public void testCreateUser(int userId, String Username, String firstName, String lastName, String email, String password, String Phone, int userStatus)
    {
        userPayload.setUserId(userId);
        userPayload.setUsername(Username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(Phone);
        userPayload.setUserStatus(userStatus);

           Response response = userEndpoint.createUser(userPayload);

        //log response
           response.then().log().all();

           System.out.println(response.then().log().body());

           //validation
           Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Create User executed");
    }


    @Test(priority = 2, dataProvider = "UserData", dataProviderClass = DataProviders.class)
    public void testGetUser(int userId, String Username, String firstName, String lastName, String email, String password, String Phone, int userStatus)
    {
        Response response = userEndpoint.getUser(Username);

        //log response
        System.out.println("-------------------Get Data");
        response.then().log().all();

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Get User executed");
    }

   @Test(priority = 3,  dataProviderClass = DataProviders.class, dataProvider = "UserData")
    public void testUpdateUser(int userId, String Username, String firstName, String lastName, String email, String password, String Phone, int userStatus)
   {
       user updatedUserPayload = new user();
       updatedUserPayload.setUserId(userId);
       updatedUserPayload.setUsername(Username);
       updatedUserPayload.setFirstName(firstName); // Set new first name
       updatedUserPayload.setLastName(lastName);
       updatedUserPayload.setEmail(email);
       updatedUserPayload.setPassword(password);
       updatedUserPayload.setPhone(Phone);
       updatedUserPayload.setUserStatus(userStatus);

       Response response = userEndpoint.putUser(Username, updatedUserPayload);

        //log response
        System.out.println("------------------Update Data");
        response.then().log().all();

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

       //log
       logger.info("Update User executed");
    }

    @Test(priority = 4,  dataProviderClass = DataProviders.class, dataProvider = "UserData")
    public void testDeleteUser(int userId, String Username, String firstName, String lastName, String email, String password, String Phone, int userStatus)
    {
        Response response = userEndpoint.deleteUser(Username);

        //log response
        response.then().log().all();

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.warn("User will deleted");
    }
}
