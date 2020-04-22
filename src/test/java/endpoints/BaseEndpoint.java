package endpoints;

import Utils.PropertiesReader;
import io.restassured.response.Response;

import static Utils.RestUtils.*;

public abstract  class BaseEndpoint  {
    private String propertiesLocation="src/main/resources/BaseEndpointProperties.properties";
    PropertiesReader propertiesReader=new PropertiesReader(propertiesLocation);


    protected final String contentType = "application/json";
    protected Response lastResponse;

    public BaseEndpoint(){
        setBaseURI(propertiesReader.getURI());
        setBasePath(propertiesReader.getBasePath());
        setPort(propertiesReader.getPort());
        setAuthentication(propertiesReader.getUsername(),propertiesReader.getPassword());
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
