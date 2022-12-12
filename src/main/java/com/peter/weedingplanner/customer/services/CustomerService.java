package com.peter.weedingplanner.customer.services;

import com.peter.weedingplanner.customer.Model.Customer;
import com.peter.weedingplanner.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
