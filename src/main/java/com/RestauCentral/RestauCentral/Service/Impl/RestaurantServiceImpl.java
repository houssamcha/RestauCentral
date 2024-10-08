package com.RestauCentral.RestauCentral.Service.Impl;

import com.RestauCentral.RestauCentral.Model.Restaurant;
import com.RestauCentral.RestauCentral.Repository.RestaurantRepository;
import com.RestauCentral.RestauCentral.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return restaurantRepository.findById(id).orElse(null); // consider handling this better
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        if (restaurant == null || restaurant.getName() == null || restaurant.getAddress() == null) {
            throw new IllegalArgumentException("Restaurant name and address cannot be null");
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant updateRestaurant(int id, Restaurant restaurant) {
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
        if (existingRestaurant.isPresent()) {
            Restaurant updatedRestaurant = existingRestaurant.get();
            if (restaurant.getName() != null) {
                updatedRestaurant.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                updatedRestaurant.setAddress(restaurant.getAddress());
            }
            updatedRestaurant.setOffres(restaurant.getOffres());
            // Uncomment and implement if you have Commandes
            // updatedRestaurant.setCommandes(restaurant.getCommandes());
            return restaurantRepository.save(updatedRestaurant);
        }
        return null;
    }
}
