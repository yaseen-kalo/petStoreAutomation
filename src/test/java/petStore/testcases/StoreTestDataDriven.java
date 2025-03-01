package petStore.testcases;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import petStore.utilities.DataProviders;
import org.testng.annotations.Test;
import petStore.endpoints.storeEndpoint;
import petStore.payloads.store;

public class StoreTestDataDriven {

    store storePayload = new store();
    public static Logger logger = LogManager.getLogger("petStoreAutomation");

    @Test(dataProvider = "StoreData", dataProviderClass = DataProviders.class, priority = 1)
    public void testGetInventory (int orderId, int petId, int quantity, String shipDate, String status, Boolean completed)
    {

        Response response = storeEndpoint.getInventory();

        //log response
        response.then().log().all();

        System.out.println(response.then().log().body());

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Get Inventory executed");
    }

    @Test(dataProvider = "StoreData", dataProviderClass = DataProviders.class, priority = 2)
    public void testCreateOrder (int orderId, int petId, int quantity, String shipDate, String status, Boolean completed)
    {
        storePayload.setOrderId(orderId);
        storePayload.setPetId(petId);
        storePayload.setQuantity(quantity);
        storePayload.setShipDate(shipDate);
        storePayload.setStatus(status);
        storePayload.setComplete(completed);

        Response response = storeEndpoint.createOrder(storePayload);

        //log response
        response.then().log().all();

        System.out.println(response.then().log().body());

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Create Order executed");
    }

    @Test(dataProvider = "StoreData", dataProviderClass = DataProviders.class, priority = 3)
    public void testGetOrder (int orderId, int petId, int quantity, String shipDate, String status, Boolean completed)
    {

        Response response = storeEndpoint.getOrder(orderId);

        //log response
        response.then().log().all();

        System.out.println(response.then().log().body());

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Fetch Order executed");
    }

    @Test(dataProvider = "StoreData", dataProviderClass = DataProviders.class, priority = 4)
    public void testDeleteOrder (int orderId, int petId, int quantity, String shipDate, String status, Boolean completed)
    {

        Response response = storeEndpoint.deletetOrder(orderId);

        //log response
        response.then().log().all();

        System.out.println(response.then().log().body());

        //validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //log
        logger.info("Delete Order executed");
    }

}
