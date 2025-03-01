package petStore.endpoints;

public class Routes {

    //base url
    public static final String baseURL = "https://petstore.swagger.io/v2";

    //user module endpoints
    public static final String postUser = baseURL + "/user";
    public static final String getUser = baseURL + "/user/{username}";
    public static final String putUser = baseURL + "/user/{username}";
    public static final String deleteUser = baseURL + "/user/{username}";

    //store module endpoints
    public static final String postOrder = baseURL + "/store/order";
    public static final String getInventory = baseURL + "/store/inventory";
    public static final String getOrder = baseURL + "/store/order/{orderId}";
    public static final String deleteOrder = baseURL + "/store/order/{orderId}";

    //pet module endpoints



}
