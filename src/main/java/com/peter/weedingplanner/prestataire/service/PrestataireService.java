package com.peter.weedingplanner.prestataire.service;

import com.peter.weedingplanner.prestataire.model.Prestataire;
import com.peter.weedingplanner.prestataire.repository.PrestataireRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class PrestataireService {

    private final PrestataireRepository prestataireRepository;

    public Iterable<Prestataire> getAllPrestataire() {
        return prestataireRepository.findAll();
    }

    public Optional<Prestataire> getPrestataireById(Long id) {
        return prestataireRepository.findById(id);
    }

    public void addPrestataire(Prestataire prestataire) {
        prestataireRepository.save(prestataire);
    }

    public void deletePrestataire(Long prestataireId) {
        prestataireRepository.deleteById(prestataireId);
    }

    public void udpateProject(Long prestataireId, Prestataire prestataire) {
        boolean existsById = prestataireRepository.existsById(prestataireId);
        if (existsById) {
            prestataireRepository.save(Prestataire.builder()
                    .id(prestataire.getId())
                    .name(prestataire.getName())
                    .tel(prestataire.getTel())
                    .prestation(prestataire.getPrestation())
                    .email(prestataire.getEmail())
                    .adresse(prestataire.getAdresse())
                    .build());
        } else {
            throw new RuntimeException("Id is not valid, please check your id");
        }
    }
}
