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
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
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
            updatedRestaurant.setName(restaurant.getName());
            updatedRestaurant.setAddress(restaurant.getAddress());
            updatedRestaurant.setPhone(restaurant.getPhone());
            updatedRestaurant.setCommandes(restaurant.getCommandes());
            updatedRestaurant.setServiceLivraison(restaurant.getServiceLivraison());
            return restaurantRepository.save(updatedRestaurant);
        }
        return null;
    }
}
