package com.RestauCentral.RestauCentral.Controller;

import com.RestauCentral.RestauCentral.Model.Offre;
import com.RestauCentral.RestauCentral.Service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offres")
@CrossOrigin(origins = "http://localhost:4200")

public class OffreController {

    @Autowired
    private OffreService offreService;

    // Get all offers
    @GetMapping
    public List<Offre> getAllOffres() {
        return offreService.getAllOffres();
    }

    // Get an offer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable Long id) {
        Offre offre = offreService.getOffreById(id);
        if (offre != null) {
            return ResponseEntity.ok(offre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get offers by restaurant ID
    @GetMapping("/restaurant/{restaurantId}")
    public List<Offre> getOffresByRestaurantId(@PathVariable Long restaurantId) {
        return offreService.getOffresByRestaurantId(restaurantId);
    }

    // Create a new offer
    @PostMapping
    public Offre addOffre(@RequestBody Offre offre) {
        return offreService.addOffre(offre);
    }

    // Update an offer by ID
    @PutMapping("/{id}")
    public ResponseEntity<Offre> updateOffre(@PathVariable Long id, @RequestBody Offre offre) {
        Offre updatedOffre = offreService.updateOffre(id, offre);
        if (updatedOffre != null) {
            return ResponseEntity.ok(updatedOffre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an offer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable Long id) {
        offreService.deleteOffre(id);
        return ResponseEntity.noContent().build();
    }
}
