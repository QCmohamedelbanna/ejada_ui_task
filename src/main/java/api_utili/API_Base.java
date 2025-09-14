package api_utili;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class API_Base {

    public Response get(String endPoint) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();
    }

    public Response get(String endPoint,String token,String orderId) {
        return RestAssured
                .given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .when()
                .get(endPoint + orderId)
                .then()
                .extract()
                .response();
    }

    public Response post(Object body, String endPoint, String token) {
        return RestAssured
                .given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();
    }

    public Response post(Object body, String endPoint) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();
    }

    public Response patch(String token, Object body, String endPoint, String orderId) {
        return RestAssured
                .given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(endPoint + orderId)
                .then()
                .extract()
                .response();

    }

    public Response delete(String token, String endPoint, String orderId) {
        return RestAssured
                .given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .when()
                .delete(endPoint + orderId)
                .then()
                .extract()
                .response();
    }


}
