package com.peter.weedingplanner.facture.controller;

import com.peter.weedingplanner.facture.model.Facture;
import com.peter.weedingplanner.facture.service.FactureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factures")
@AllArgsConstructor
@Slf4j
public class FactureController {

    private final FactureService factureService;

    @GetMapping("/")
    public List<Facture> getAllFacture() {
        log.info("start getting factures...");
        Iterable<Facture> factureList = factureService.getAllFacture();
        return (List<Facture>) factureList;
    }

    @GetMapping("/{factureId}")
    public Optional<Facture> getFactureById(@PathVariable("factureId") Long id) {
        log.info("getting facture by his/her Id");
        return factureService.getFactureById(id);

    }


    @PostMapping
    public void addPrestataire(@RequestBody Facture facture) {
        factureService.addFacture(facture);
    }

    @DeleteMapping("/{factureId}")
    public void deleteCustomer(@PathVariable("factureId") Long factureId) {
        factureService.deleteFacture(factureId);
    }

    @PutMapping(path = "/{factureId}")
    public void updateStudent(@PathVariable("factureId") Long factureId,
                              @RequestBody Facture facture) {
        if (factureId == null || facture.getId() == null) {
            throw new IllegalArgumentException("you need to provide an id");
        } else {
            factureService.udpateFacture(factureId, facture);
        }
    }
}
