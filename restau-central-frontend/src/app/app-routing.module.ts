import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterRestaurantComponent } from './ajouter-restaurant/ajouter-restaurant.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';

const routes: Routes = [
  { path: 'add-restaurant', component: AjouterRestaurantComponent },
  { path: 'restaurant-list', component: RestaurantListComponent },
  { path: '', component: RestaurantListComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
