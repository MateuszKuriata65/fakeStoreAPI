package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth;

public class RestUtils {


    public static void setPort(int port){
         RestAssured.port=port;
    }

    public static void setBasePath(String basePath){
        RestAssured.basePath=basePath;
    }

    public static void setBaseURI(String URI){
        RestAssured.baseURI=URI;
    }

    public static void setAuthentication(String username, String password){
        RestAssured.authentication=oauth(username,password,"","");
    }

    public static void setContentType(String contentType){
        given().contentType(contentType);
    }

    public Response getLastResponse(Response lastResponse) {
        return lastResponse;
    }
}
