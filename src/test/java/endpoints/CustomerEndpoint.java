package endpoints;

import POJOs.Customer;

import static io.restassured.RestAssured.*;

public  class CustomerEndpoint extends BaseEndpoint {

    private final String customerEndpoint="customers";


    public Customer getCustomer(int id){
        lastResponse=get(customerEndpoint+"/"+id);
        return lastResponse.as(Customer.class);
    }

    public void createCustomer(Customer customer){
        lastResponse=given().
                contentType(contentType).
                body(customer).
                when().
                post(customerEndpoint);
    }


    public void deleteCustomer(int id){
        lastResponse=given().
                param("force","true").
                when().
                delete(customerEndpoint+"/"+id);
    }











}
