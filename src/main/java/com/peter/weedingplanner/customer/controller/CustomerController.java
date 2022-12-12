package com.peter.weedingplanner.customer.controller;

import com.peter.weedingplanner.customer.Model.Customer;
import com.peter.weedingplanner.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping({"","/"})
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return customerList;
    };

}
