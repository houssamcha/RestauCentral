package com.RestauCentral.RestauCentral.Repository;

import com.RestauCentral.RestauCentral.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}