package com.server.ecommerce.service;

import com.server.ecommerce.entity.Customer;
import com.server.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer addCustomer(Customer customer){
        return repository.save(customer);
    }

    public List<Customer> addCustomers(List<Customer> customers){
        return repository.saveAll(customers);
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }
}
