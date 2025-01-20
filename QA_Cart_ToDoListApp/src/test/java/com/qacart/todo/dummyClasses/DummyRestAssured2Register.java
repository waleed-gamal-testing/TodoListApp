package com.qacart.todo.dummyClasses;
import com.qacart.todo.objects.User;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class DummyRestAssured2Register {
    public static void main(String[] args) {

        User user = new User("waleed","Gamal","waleedgamalmahmoud1234@gmail.com","123d4567");
       Response response =
            given()
                .baseUri("https://qacart-todo.herokuapp.com")
                 .header("Content-Type","application/json")
                .body(user)
            .when()
                .post("/api/v1/users/register")
            .then()
                .log().all()
                .extract().response();
        String userId = response.path("userID");
        String firstName = response.path("firstName");
        Cookies cookies = new Cookies() ;
        Cookies accessToken = response.detailedCookies();
        System.out.println(userId);
        System.out.println(firstName);
        System.out.println(accessToken);

        //System.out.println(response.prettyPrint());

    }


}
