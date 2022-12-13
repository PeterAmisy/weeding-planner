package com.peter.weedingplanner.customer.controller;

import com.peter.weedingplanner.customer.Model.Customer;
import com.peter.weedingplanner.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping({"", "/"})
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        log.info("start getting customers...");
        List<Customer> customerList = customerService.getAllCustomer();
        return customerList;
    }

    @GetMapping("{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") Long id) {
        log.info("getting customer by his/her Id");
        return customerService.getCustomerById(id);

    }

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void updateStudent(@PathVariable("customerId") Long customerId,
                              @RequestBody Customer customer) {
        customerService.udpateCustomer(customerId, customer);
    }

}
