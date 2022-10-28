package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Customer;
import com.server.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return service.addCustomers(customers);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById (@PathVariable int id){
        return service.getCustomerById(id);
    }
}
