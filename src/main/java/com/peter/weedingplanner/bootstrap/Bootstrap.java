package com.peter.weedingplanner.bootstrap;

import com.peter.weedingplanner.customer.Model.Customer;
import com.peter.weedingplanner.customer.repository.CustomerRepository;
import com.peter.weedingplanner.project.model.Project;
import com.peter.weedingplanner.project.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {


    private final CustomerRepository customerRepository;
    private final ProjectRepository projectRepository;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----Init from Bootstrap !! ");


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

        System.out.println("customer saved " + customerRepository.count());

        Project nellyWeeding = Project.builder()
                .id(1L)
                .name("Nelly's Weeding")
                .startDate(LocalDate.of(2023, 1, 1))
                .endDate(LocalDate.of(2023, 11, 10))
                .build();

        Project nellyTraditionalWeeding = Project.builder()
                .id(2L)
                .name("Oukoumbi")
                .startDate(LocalDate.of(2023, 1, 1))
                .endDate(LocalDate.of(2023, 12, 12))
                .build();

        projectRepository.save(nellyWeeding);
        projectRepository.save(nellyTraditionalWeeding);

        System.out.println("project saved " + projectRepository.count());


    }
}
