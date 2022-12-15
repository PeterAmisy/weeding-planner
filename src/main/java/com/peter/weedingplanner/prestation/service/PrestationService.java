package com.peter.weedingplanner.prestation.service;

import com.peter.weedingplanner.prestation.model.Prestation;
import com.peter.weedingplanner.prestation.repository.PrestationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PrestationService {

    private final PrestationRepository prestationRepository;

    public Iterable<Prestation> getAllPrestation() {
        return prestationRepository.findAll();
    }

    public Optional<Prestation> getPrestationById(Long id) {
        return prestationRepository.findById(id);
    }

    public void addPrestation(Prestation prestation) {
        prestationRepository.save(prestation);
    }

    public void deletePrestation(Long prestationId) {
        prestationRepository.deleteById(prestationId);
    }

    public void udpatePrestation(Long prestationId, Prestation prestation) {
        boolean existsById = prestationRepository.existsById(prestationId);
        if (existsById) {
            prestationRepository.save(Prestation.builder()
                    .id(prestation.getId())
                    .name(prestation.getName())
                    .dateEvenement(prestation.getDateEvenement())
                    .facture(prestation.getFacture())
                    .build());
        } else {
            throw new RuntimeException("Id is not valid, please check your id");
        }
    }
}
