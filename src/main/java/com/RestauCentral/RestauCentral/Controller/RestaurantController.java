package com.RestauCentral.RestauCentral.Controller;

import com.RestauCentral.RestauCentral.Model.Restaurant;
import com.RestauCentral.RestauCentral.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('RESTAURANT')")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RESTAURANT')")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('RESTAURANT')")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        if (updatedRestaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 for successful deletion
    }
}
