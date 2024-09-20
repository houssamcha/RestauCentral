package com.RestauCentral.RestauCentral.Service.Impl;


import com.RestauCentral.RestauCentral.Model.Offre;
import com.RestauCentral.RestauCentral.Repository.OffreRepository;
import com.RestauCentral.RestauCentral.Service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreServiceImpl implements OffreService {

    @Autowired
    private OffreRepository offreRepository;

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @Override
    public Offre getOffreById(Long id) {
        return offreRepository.findById(id).orElse(null);
    }

    @Override
    public Offre addOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void deleteOffre(Long id) {
        offreRepository.deleteById(id);
    }

    @Override
    public Offre updateOffre(Long id, Offre offre) {
        Optional<Offre> existingOffre = offreRepository.findById(id);
        if (existingOffre.isPresent()) {
            Offre updatedOffre = existingOffre.get();
            updatedOffre.setNom(offre.getNom());
            updatedOffre.setDescription(offre.getDescription());
            updatedOffre.setPrix(offre.getPrix());
            updatedOffre.setRestaurant(offre.getRestaurant());
            return offreRepository.save(updatedOffre);
        }
        return null;
    }

    @Override
    public List<Offre> getOffresByRestaurantId(Long restaurantId) {
        return offreRepository.findByRestaurantId(restaurantId);
    }
}