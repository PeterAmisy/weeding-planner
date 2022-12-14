package com.peter.weedingplanner.prestation.controller;

import com.peter.weedingplanner.prestation.model.Prestation;
import com.peter.weedingplanner.prestation.service.PrestationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestations")
@AllArgsConstructor
@Slf4j
public class PrestationController {


    private final PrestationService prestationService;

    @GetMapping("/")
    public List<Prestation> getAllPrestation() {
        log.info("start getting prestations...");
        Iterable<Prestation> prestationList = prestationService.getAllPrestation();
        return (List<Prestation>) prestationList;
    }

    @GetMapping("/{prestataionId}")
    public Optional<Prestation> getPrestationById(@PathVariable("prestataionId") Long id) {
        log.info("getting prestation by his/her Id");
        return prestationService.getPrestationById(id);

    }

    //todo: getPrestataireByName

    @PostMapping
    public void addPrestataire(@RequestBody Prestation prestation) {
        prestationService.addPrestation(prestation);
    }

    @DeleteMapping("/{prestataionId}")
    public void deleteCustomer(@PathVariable("prestataionId") Long prestationId) {
        prestationService.deletePrestation(prestationId);
    }

    @PutMapping(path = "/{prestataionId}")
    public void updateStudent(@PathVariable("prestataionId") Long prestationId,
                              @RequestBody Prestation prestation) {
        if(prestationId == null || prestation.getId()== null){
            throw new IllegalArgumentException("you need to provide an id");
        }else {
            prestationService.udpatePrestation(prestationId, prestation);
        }
    }
}
