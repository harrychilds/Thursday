package sample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSample {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        RequestSpecification reqObj = RestAssured.given();

        Response respObj = reqObj.get("/pet/12");

        System.out.println("Response Code ---> " + respObj.getStatusCode());

        if(respObj.getStatusCode() == 200) {
            System.out.println("Status check passed!");
        }
        else {
            System.out.println("Status check failed!");
        }

        System.out.println("Header value of content type ---> " + respObj.getHeader("content-type"));

        System.out.println(respObj.getBody().asString());

        System.out.println("From Response - id ---> " + respObj.jsonPath().get("id"));

        System.out.println("From Response - name in category ---> " + respObj.jsonPath().get("category.name"));



    }

}
