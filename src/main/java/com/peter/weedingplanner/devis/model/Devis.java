package com.peter.weedingplanner.devis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "devis")
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String name;
    private Double prixSimuler;
    private Double prixObtenue;
    private LocalDate dateEvenement;

}
