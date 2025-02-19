package petStore.endpoints;

public class Routes {

    //base url
    public static final String baseURL = "https://petstore.swagger.io/v2";

    //user module endpoints
    public static final String PostUser = baseURL + "/user";
    public static final String getUser = baseURL + "/user/{username}";
    public static final String putUser = baseURL + "/user/{username}";
    public static final String deleteUser = baseURL + "/user/{username}";

}
