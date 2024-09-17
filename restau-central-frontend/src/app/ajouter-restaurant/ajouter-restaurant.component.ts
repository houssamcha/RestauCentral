import { Component } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant.services';
import { Restaurant } from 'src/app/Model/restaurant.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurant-add',
  templateUrl: './ajouter-restaurant.component.html',
  styleUrls: ['./ajouter-restaurant.component.css']
})
export class AjouterRestaurantComponent {
  restaurant: Restaurant = {
    name: '',
    address: '',
    phone: '',
    commandes: '',
    serviceLivraison: ''
  };

  constructor(private restaurantService: RestaurantService , private router : Router) {}

  
  onSubmit() {
    this.restaurantService.addRestaurant(this.restaurant).subscribe(
      (response) => {
        console.log('Restaurant ajouté avec succès !', response);

        this.router.navigate(['/restaurant-list']);

        this.restaurant = {
          name: '',
          address: '',
          phone: '',
          commandes: '',
          serviceLivraison: ''
        };
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du restaurant', error);
      }
    );
  }
}
