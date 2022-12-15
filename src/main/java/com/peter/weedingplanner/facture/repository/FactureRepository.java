package com.peter.weedingplanner.facture.repository;

import com.peter.weedingplanner.facture.model.Facture;
import org.springframework.data.repository.CrudRepository;

public interface FactureRepository extends CrudRepository<Facture, Long> {
}
