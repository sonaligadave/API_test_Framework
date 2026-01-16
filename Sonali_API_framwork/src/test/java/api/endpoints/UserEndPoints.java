package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
    // Create user
    public static Response createUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(routes.post_url);
        return response;
    }

    public static Response getUser(String userName) {
        Response response =
                given()
                        .pathParam("username", userName)
                        .accept(ContentType.JSON)
                        .get(routes.get_url);
        return response;
    }


    public static Response putUser(String userName) {
        Response response = given()
                .pathParam("username", userName)
                .accept(ContentType.ANY)
                .contentType(ContentType.JSON)
                .when()
                .put(routes.get_url);
        return response;

    }

    public static Response deleteUser(String userName) {
        Response response = given()
                .pathParam("username", userName)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(routes.get_url);

        return response;
    }


}