package TESTS;

import POJOs.Customer;
import endpoints.CustomerEndpoint;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTests {

    private static CustomerEndpoint customerEndpoint;
    private static List<Integer>  newCustomers =new ArrayList<>();

    @BeforeAll
    public static void setUpTest(){
         customerEndpoint=new CustomerEndpoint();
    }


    @Test
    public void getCustomer(){
        Customer customer=customerEndpoint.getCustomer(198);
        Assertions.assertEquals(200,customerEndpoint.getLastStatusCode());
        System.out.println(customer.toString());

    }

    @Test
    public void createCustomerTest(){
        Customer newCustomer=new Customer("mateusz","janusz","s89z@jan3u3sz54.pl","mw14uszek1","mateuszek2");
        System.out.println(newCustomer);
        customerEndpoint.createCustomer(newCustomer);
        Assertions.assertEquals(201,customerEndpoint.getLastStatusCode(),customerEndpoint.responseMessage());
        newCustomers.add(customerEndpoint.getLastResponse().jsonPath().get("id"));
        System.out.println(newCustomers.toString());
    }

    @AfterAll
    public static void afterTest(){
        for (int id:newCustomers
             ) {
        customerEndpoint.deleteCustomer(id);
        Assertions.assertEquals(200,customerEndpoint.getLastStatusCode(), customerEndpoint.responseMessage());
            System.out.println("I removed customer with id="+id);
        }

    }

}
