package com.peter.weedingplanner.facture.model;

import com.peter.weedingplanner.prestation.model.Prestation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String name;
    private Double prixHt;
    private Double prixTtc;


    @OneToOne(mappedBy = "facture")
    private Prestation prestation;
}
