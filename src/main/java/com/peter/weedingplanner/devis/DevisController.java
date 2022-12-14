package com.peter.weedingplanner.devis;

import com.peter.weedingplanner.devis.model.Devis;
import com.peter.weedingplanner.devis.service.DevisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devis")
@AllArgsConstructor
@Slf4j
public class DevisController {

    private final DevisService devisService;

    @GetMapping("/")
    public List<Devis> getAllDevis() {
        log.info("start getting deviss...");
        Iterable<Devis> devisList = devisService.getAllDevis();
        return (List<Devis>) devisList;
    }

    @GetMapping("/{devisId}")
    public Optional<Devis> getDevisById(@PathVariable("devisId") Long id) {
        log.info("getting devis by his/her Id");
        return devisService.getDevisById(id);

    }

    @PostMapping
    public void addPrestataire(@RequestBody Devis devis) {
        devisService.addDevis(devis);
    }

    @DeleteMapping("/{devisId}")
    public void deleteCustomer(@PathVariable("devisId") Long devisId) {
        devisService.deleteDevis(devisId);
    }

    @PutMapping(path = "/{devisId}")
    public void updateStudent(@PathVariable("devisId") Long devisId,
                              @RequestBody Devis devis) {
        devisService.udpateDevis(devisId, devis);
    }
}
