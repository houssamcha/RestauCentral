import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from 'src/app/services/restaurant.services';
import { Restaurant } from 'src/app/Model/restaurant.model';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent {
  restaurants: Restaurant[] = [];

  constructor(private restaurantService: RestaurantService, private router: Router) {}

  ngOnInit(): void {
    this.loadRestaurants();
  }

  loadRestaurants(): void {
    this.restaurantService.getRestaurants().subscribe(
      (data) => {
        this.restaurants = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des restaurants', error);
      }
    );
  }

  navigateToAdd(): void {
    this.router.navigate(['/add-restaurant']);
  }
  
  deleteRestaurant(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce restaurant ?')) {
      this.restaurantService.deleteRestaurant(id).subscribe(
        () => {
          console.log('Restaurant supprimé avec succès');
          this.loadRestaurants();  // Recharger la liste après suppression
        },
        (error) => {
          console.error('Erreur lors de la suppression du restaurant', error);
        }
      );
    }
  }

}

