package com.scalefocus.java.simeonyachev.breweryclient.web.client;

import com.scalefocus.java.simeonyachev.breweryclient.web.model.BeerDTO;
import com.scalefocus.java.simeonyachev.breweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerByIdSuccessfully() {
        BeerDTO beerDTO = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDTO);
    }

    @Test
    void saveBeerSuccessfully() {
        BeerDTO beerDTO = BeerDTO.builder().name("Beer").build();

        URI uri = client.saveBeer(beerDTO);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerSuccessfully() {
        BeerDTO beerDTO = BeerDTO.builder().name("Beer").build();

        client.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void deleteBeerByIdSuccessfully() {
        client.deleteBeer(UUID.randomUUID());
    }@Test
    void getCustomerByIdSuccessfully() {
        CustomerDTO customerDTO = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void saveCustomerSuccessfully() {
        CustomerDTO customerDTO = CustomerDTO.builder().name("Name").build();

        URI uri = client.saveCustomer(customerDTO);
        assertNotNull(uri);
    }

    @Test
    void updateCustomerSuccessfully() {
        CustomerDTO customerDTO = CustomerDTO.builder().name("Name").build();
        client.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void deleteCustomerSuccessfully() {
        client.deleteCustomer(UUID.randomUUID());
    }
}