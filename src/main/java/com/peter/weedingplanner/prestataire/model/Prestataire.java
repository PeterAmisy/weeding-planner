package com.peter.weedingplanner.prestataire.model;

import com.peter.weedingplanner.prestation.model.Prestation;
import com.peter.weedingplanner.utils.Adresse;
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
@Table(name = "prestataire")
public class Prestataire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Embedded
    private Adresse adresse;
    private String email;
    private String tel;
    @OneToOne(mappedBy = "prestataire")
    private Prestation prestation;


}
