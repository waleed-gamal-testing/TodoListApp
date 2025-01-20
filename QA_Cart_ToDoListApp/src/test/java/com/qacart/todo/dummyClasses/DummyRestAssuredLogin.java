package com.qacart.todo.dummyClasses;

import com.qacart.todo.objects.User2;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DummyRestAssuredLogin {
    public static void main(String[] args) {
        User2 user2 = new User2("waleedgamal1081996@gmail.com","Waleed.Gamal@1996");
       Response response =
       given()
               .baseUri("https://qacart-todo.herokuapp.com")
               .header("Content-Type","application/json")
               .body(user2)
       .when()
               .post("/api/v1/users/login")
       .then()
              // .log().all();   // print all response data
               .extract().response();
       String accessToken = response.path("userID");
        System.out.println(accessToken);

        //System.out.println(response.prettyPrint());

    }
}
