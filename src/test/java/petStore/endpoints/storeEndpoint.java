package petStore.endpoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.payloads.store;

public class storeEndpoint {
    public static Response createOrder(store payload)
    {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postOrder);

        return response;
    }

    public static Response getInventory()
    {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get(Routes.getInventory);

        return response;
    }

    public static Response getOrder(int orderId)
    {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParams("orderId", orderId)
                .when()
                .get(Routes.getOrder);

        return response;
    }

    public static Response deletetOrder(int orderId)
    {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParams("orderId", orderId)
                .when()
                .delete(Routes.deleteOrder);

        return response;
    }
}
