package com.peter.weedingplanner.customer.services;

import com.peter.weedingplanner.customer.Model.Customer;
import com.peter.weedingplanner.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void saveCustomer(Customer customer) {
        try {
            customerRepository.save(customer);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public Customer findCustomerByEmail(Customer customer) {
        return customerRepository.findCustomerByEmail(customer);
    }


    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public void udpateCustomer(Long customerId, Customer customer) {
        boolean existsById = customerRepository.existsById(customerId);
        if (existsById) {
            customerRepository.save(Customer.builder()
                    .id(customerId)
                    .email(customer.getEmail())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .build());
        } else {
            throw new RuntimeException("Id is not valid, please check your id");
        }
    }
}
