package com.peter.weedingplanner.customer.repositories;

import com.peter.weedingplanner.customer.Model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(Customer id);


}
