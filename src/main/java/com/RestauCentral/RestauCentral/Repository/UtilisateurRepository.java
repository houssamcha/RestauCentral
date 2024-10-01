package com.RestauCentral.RestauCentral.Repository;

import com.RestauCentral.RestauCentral.Model.Restaurant;
import com.RestauCentral.RestauCentral.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findByRestaurantId(Long restaurantId);

    List<Utilisateur> findByRestaurant(Restaurant restaurant);


}