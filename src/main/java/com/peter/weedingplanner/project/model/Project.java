package com.peter.weedingplanner.project.model;

import com.peter.weedingplanner.customer.Model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne
    private Customer customer;
}
