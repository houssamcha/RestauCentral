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
  restaurant: Restaurant | null = null;  // Objet pour stocker les détails du restaurant

  constructor(
    private route: ActivatedRoute,
    private restaurantService: RestaurantService
  ) {}

  ngOnInit() {
    // Récupérer l'ID du restaurant à partir de l'URL
    this.route.params.subscribe(params => {
      this.restaurantId = +params['id'];  // Convertir l'ID en nombre
      this.loadRestaurantDetails();
    });
  }

  loadRestaurantDetails() {
    if (this.restaurantId !== null) {
      this.restaurantService.getRestaurantById(this.restaurantId).subscribe(
        (data: Restaurant) => {
          this.restaurant = data;  // Stocker les détails du restaurant
        },
        error => {
          console.error('Error fetching restaurant details', error);
        }
      );
    }
  }
}
