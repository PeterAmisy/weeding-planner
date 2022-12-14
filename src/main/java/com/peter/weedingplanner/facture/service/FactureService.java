package com.peter.weedingplanner.facture.service;

import com.peter.weedingplanner.facture.model.Facture;
import com.peter.weedingplanner.facture.repository.FactureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FactureService {

    private final FactureRepository factureRepository;

    public Iterable<Facture> getAllFacture() {
        return factureRepository.findAll();
    }

    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    public void addFacture(Facture facture) {
        factureRepository.save(facture);
    }

    public void deleteFacture(Long factureId) {
        factureRepository.deleteById(factureId);
    }

    public void udpateFacture(Long factureId, Facture facture) {
        boolean existsById = factureRepository.existsById(factureId);
        if (existsById) {
            factureRepository.save(Facture.builder()
                    .id(facture.getId())
                    .name(facture.getName())
                    .prestation(facture.getPrestation())
                    .prixHt(facture.getPrixHt())
                    .prixTtc(facture.getPrixTtc())
                    .build());
        } else {
            throw new RuntimeException("Id is not valid, please check your id");
        }
    }
}
