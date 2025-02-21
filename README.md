![RestAssuredFrameworkDesign_page-0001.jpg](attachment:d37e6580-839b-4da0-999e-b8e18bbaf53e:RestAssuredFrameworkDesign_page-0001.jpg)

**Endpoint Package** will have some classes where Routes.java will maintains URLs and in the rest of classes we will create our requests like get, post, put & delete

- Routes.java
- ProductsEndPoints.java
- UsersEndPoints.java
- OrdersEndPoints.java
- ReviewsEndPoints.java

**TestCases Package**, here we will maintain all the validations for every request.

- ProductTestCases
- UsersTestCases
- OrdersTestCases
- ReviewsTestCases

**Payload Package** will maintain payload of every module. We will create POJO class.

- ProductPayload
- UsersPayload
- OrdersPayload
- ReviewsPayload

**Utilities Package**, here we will maintain Data Provider class in order to acheiving Data Driven Testing. It is a common utility class. We don’t need separate for every module.

- DataProvider
- Json Utility
- Xlsx Utility
- Extent Report

**Test Data package**, It will maintain test data for every module separately.

- ProductData
- UserData
- OrderData
- ReviewData

**TestNG.xml**, It help us to group the test cases or prioritize them and also help us to run the test cases.

**Pom.xml**, we will define plugin and dependencies which we will use in the project.

**Report package**, the will maintain the executed test case reports.

- TestNG Reports
- Extent Reports

# Endpoints Package:

## Routes Class:

In routes class, we only need to maintains urls for base url and every module’s url. We don’t need to create any methods.

e.g.

base_url, post_user_url, get_user_url, put_user_url, get_product_url, post_product_url, delete_store_url

## UserEndPoints.java Class:

we have to create methods to perform get, post, put and delete request, but when we need to perform these request then there will be a payload/request body which will go with request like post and put. So, for that we will create Pojo class first in payload package which gonna use in create_user method.

here is an example of create request for put req in [Userendpoint.java](http://Userendpoint.java) class.

`public static Response putUser(String username, User payload) {
    Response response = given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .param("username", payload.getUsername())
            .body(payload)
            .when()
            .put(Routes.putUser);
    return response;
}`

@BeforeClass annotation means this method will run before all the methods present in this class.

e.g. generateTestData()

Steps we took to perform complete task

1. Create Maven project in Intellij.
2. Update dependencies in pom.xml
3. Create folder structure
4. create [Routes.java](http://Routes.java) to maintain URLs.
5. create pojo class for user module payload
6. create [userEndpoints.java](http://userEndpoints.java) to create curd operation
7. create testcases for user module in testcase package.
8. Data Driven Testing with JSON file
9. create Data Provider class in  utilities package.
10. Save JSON file in TestData Folder.
11. Generate Extent Report from creating ExtentListenerClass in utility package.
12. Generate testng.xml file.
13. Add Listener tag in xml and run testcases from xml file.