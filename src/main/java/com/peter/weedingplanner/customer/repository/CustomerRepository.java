package com.peter.weedingplanner.customer.repository;

import com.peter.weedingplanner.customer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByEmail(Customer email);


}
