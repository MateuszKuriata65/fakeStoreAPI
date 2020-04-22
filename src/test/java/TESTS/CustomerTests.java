package TESTS;

import POJOs.Customer;
import endpoints.CustomerEndpoint;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/dataTest.csv",numLinesToSkip = 1)
    public void createCustomerTest(String firstName,String lastName,String email,String username,String password){
        Customer newCustomer=new Customer(firstName,lastName,email,username,password);
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
