package petStore.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.payloads.user;

import static io.restassured.RestAssured.*;

public class userEndpoint {

    public static Response createUser(user payload)
    {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postUser);

        return response;
    }

    public static Response getUser(String Username) {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParams("username", Username)
                .when()
                .get(Routes.getUser);

        return response;
    }

    public static Response putUser(String Username, user payload) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParams("username", Username)
                .body(payload)
                .when()
                .put(Routes.putUser);

        return response;
    }

    public static Response deleteUser(String Username) {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParams("username", Username)
                .when()
                .delete(Routes.deleteUser);

        return response;
    }
}
