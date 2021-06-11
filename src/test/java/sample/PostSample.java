package sample;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
public class PostSample {
    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RequestSpecification req = RestAssured.given().header("Content-Type", "application/json");
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", "33");
        jsonObj.put("petId", "33");
        jsonObj.put("quantity", "1");
        jsonObj.put("shipDate", "2021-06-10T09:33:58.195Z");
        jsonObj.put("status", "placed");
        jsonObj.put("complete", "true");
        req.body(jsonObj.toJSONString());
        Response res = req.post("/store/order");
        System.out.println("Response Code: " + res.getStatusCode());
        System.out.println("Response id: " + res.jsonPath().get("id"));
        System.out.println("Response body: " + res.body().asString());
    }
}