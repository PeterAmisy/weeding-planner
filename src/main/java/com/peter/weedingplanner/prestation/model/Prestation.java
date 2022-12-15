package com.peter.weedingplanner.prestation.model;

import com.peter.weedingplanner.facture.model.Facture;
import com.peter.weedingplanner.prestataire.model.Prestataire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "prestation")
public class Prestation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String name;
    private LocalDate dateEvenement;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "prestataire_id", referencedColumnName = "id")
    private Prestataire prestataire;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facture_id", referencedColumnName = "id")
    private Facture facture;
}
