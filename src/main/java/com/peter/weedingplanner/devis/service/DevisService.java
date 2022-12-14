package com.peter.weedingplanner.devis.service;

import com.peter.weedingplanner.devis.model.Devis;
import com.peter.weedingplanner.devis.repository.DevisRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DevisService {

    private final DevisRepository devisRepository;

    public Iterable<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    public Optional<Devis> getDevisById(Long id) {
        return devisRepository.findById(id);
    }

    public void addDevis(Devis devis) {
        devisRepository.save(devis);
    }

    public void deleteDevis(Long devisId) {
        devisRepository.deleteById(devisId);
    }

    public void udpateDevis(Long devisId, Devis devis) {
        boolean existsById = devisRepository.existsById(devisId);
        if (existsById) {
            devisRepository.save(Devis.builder()
                    .id(devis.getId())
                    .name(devis.getName())
                    .dateEvenement(devis.getDateEvenement())
                    .prixObtenue(devis.getPrixSimuler())
                    .prixSimuler(devis.getPrixSimuler())
                    .build());
        } else {
            throw new RuntimeException("Id is not valid, please check your id");
        }
    }
}
