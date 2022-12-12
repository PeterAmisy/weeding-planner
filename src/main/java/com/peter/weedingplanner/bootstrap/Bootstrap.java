package com.peter.weedingplanner.bootstrap;

import com.peter.weedingplanner.customer.Model.Customer;
import com.peter.weedingplanner.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;

@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {



        Customer nelly = Customer.builder()
                .id(1L)
                .firstName("Nelly")
                .lastName("AMISY")
                .email("nelly@msn.com")
                .build();
        Customer soraya = Customer.builder()
                .id(2L)
                .firstName("Soraya")
                .lastName("Mistoihi")
                .email("soraya@msn.com")
                .build();
        Customer naima = Customer.builder()
                .id(3L)
                .firstName("Naima")
                .lastName("SAID")
                .email("naima@msn.com")
                .build();
        Customer zouria = Customer.builder()
                .id(4L)
                .firstName("Zouria")
                .lastName("SOILIHI")
                .email("zou@msn.com")
                .build();

        customerRepository.save(nelly);
        customerRepository.save(soraya);
        customerRepository.save(naima);
        customerRepository.save(zouria);
    }
}
