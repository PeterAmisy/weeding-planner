package com.peter.weedingplanner.prestataire.controller;

import com.peter.weedingplanner.prestataire.model.Prestataire;
import com.peter.weedingplanner.prestataire.service.PrestataireService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/prestataires")
public class PrestataireController {


    private final PrestataireService prestataireService;

    @GetMapping("/")
    public List<Prestataire> getAllPrestataires() {
        log.info("start getting prestataires...");
        Iterable<Prestataire> prestataireList = prestataireService.getAllPrestataire();
        return (List<Prestataire>) prestataireList;
    }

    @GetMapping("/{prestataireId}")
    public Optional<Prestataire> getCustomerById(@PathVariable("prestataireId") Long id) {
        log.info("getting customer by his/her Id");
        return prestataireService.getPrestataireById(id);

    }

    //todo: getPrestataireByName

    @PostMapping
    public void addPrestataire(@RequestBody Prestataire prestataire) {
        prestataireService.addPrestataire(prestataire);
    }

    @DeleteMapping("/{prestataireId}")
    public void deleteCustomer(@PathVariable("prestataireId") Long prestataireId) {
        prestataireService.deletePrestataire(prestataireId);
    }

    @PutMapping(path = "/{prestataireId}")
    public void updateStudent(@PathVariable("prestataireId") Long prestataireId,
                              @RequestBody Prestataire prestataire) {
        if (prestataireId == null || prestataire.getId() == null) {
            throw new IllegalArgumentException("you need to provide an id");
        } else {
            prestataireService.udpateProject(prestataireId, prestataire);
        }
    }
}
