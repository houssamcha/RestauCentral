package com.RestauCentral.RestauCentral.Service;


import com.RestauCentral.RestauCentral.Model.Offre;
import java.util.List;

public interface OffreService {
    List<Offre> getAllOffres();
    Offre getOffreById(Long id);
    Offre addOffre(Offre offre);
    void deleteOffre(Long id);
    Offre updateOffre(Long id, Offre offre);
    List<Offre> getOffresByRestaurantId(Long restaurantId);
}