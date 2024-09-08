package com.RestauCentral.RestauCentral.Service;

import com.RestauCentral.RestauCentral.Model.Restaurant;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(int id);
    Restaurant addRestaurant(Restaurant restaurant);
    void deleteRestaurant(int id);
    Restaurant updateRestaurant(int id, Restaurant restaurant);
}
