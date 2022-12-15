package com.peter.weedingplanner.utils;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Adresse {

    private String adresse1;
    private Integer zipCode;
    private String city;
}
