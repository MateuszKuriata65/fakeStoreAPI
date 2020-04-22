package endpoints;

import io.restassured.response.Response;

import static Utils.RestUtils.*;

public abstract  class BaseEndpoint  {
    private static String username="ck_8da07afd3503a4242e95a2d5bad99cc2fb55c552";
    private static String password="cs_e57e8cadc42ca42064c44239853dda9aa2e77474";
    private static int port=80;
    private static String basePath="fakestore/wp-json/wc/v3/";
    private static String URI="http://localhost/";
    private static String URL="http://localhost/fakestore/wp-json/wc/v3/";

    protected final String contentType = "application/json";
    protected Response lastResponse;

    public BaseEndpoint(){
        setBaseURI(URI);
        setBasePath(basePath);
        setPort(port);
        setAuthentication(username,password);
    }

    public Response getLastResponse() {
        return lastResponse;
    }

    public int getLastStatusCode(){

        return lastResponse.statusCode();
    }

    public String responseMessage(){
        return lastResponse.jsonPath().getString("message");
    }




}
