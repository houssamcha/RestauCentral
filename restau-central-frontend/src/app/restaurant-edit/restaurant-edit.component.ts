import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantService } from 'src/app/services/restaurant.services';
import { Restaurant } from 'src/app/Model/restaurant.model';

@Component({
  selector: 'app-restaurant-edit',
  templateUrl: './restaurant-edit.component.html',
  styleUrls: ['./restaurant-edit.component.css']
})
export class RestaurantEditComponent implements OnInit {
  restaurant: Restaurant = {
    id: 0,
    name: '',
    address: '',
    phone: '',
    commandes: '',
    serviceLivraison: ''
  };

  constructor(
    private restaurantService: RestaurantService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.restaurantService.getRestaurantById(id).subscribe(
      (data) => this.restaurant = data,
      (error) => console.error('Erreur lors de la récupération du restaurant', error)
    );
  }

  onSubmit() {
    this.restaurantService.updateRestaurant(this.restaurant).subscribe(
      (response) => {
        console.log('Restaurant mis à jour avec succès !', response);
        this.router.navigate(['/restaurant-list']);
      },
      (error) => console.error('Erreur lors de la mise à jour du restaurant', error)
    );
  }
}
