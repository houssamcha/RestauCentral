package com.RestauCentral.RestauCentral.Repository;

import com.RestauCentral.RestauCentral.Model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
    List<Offre> findByRestaurantId(Long restaurantId);
}