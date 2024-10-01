import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/services/restaurant.services';
import { Restaurant } from 'src/app/Model/restaurant.model';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
  restaurantId: number | null = null;
  restaurant: Restaurant | null = null;

  constructor(
    private route: ActivatedRoute,
    private restaurantService: RestaurantService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.restaurantId = +params['id'];
      this.loadRestaurantDetails();
    });
  }

  loadRestaurantDetails(): void {
    if (this.restaurantId) {
      this.restaurantService.getRestaurantById(this.restaurantId)
        .subscribe(restaurant => this.restaurant = restaurant);
    }
  }
}
