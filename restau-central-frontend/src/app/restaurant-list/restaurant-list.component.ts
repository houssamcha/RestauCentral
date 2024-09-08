import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../services/restaurant.services';
import { Restaurant } from '../Model/restaurant.model';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {
  restaurants: Restaurant[] = [];

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurantService.getRestaurants().subscribe(
      (data: Restaurant[]) => this.restaurants = data,
      (error) => console.error('Error fetching restaurants', error)
    );
  }
}
