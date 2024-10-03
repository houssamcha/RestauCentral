import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterRestaurantComponent } from './ajouter-restaurant/ajouter-restaurant.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { RestaurantEditComponent } from './restaurant-edit/restaurant-edit.component';
import { OffreListComponent } from './offre-list/offre-list.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const routes: Routes = [
  { path: 'add-restaurant', component: AjouterRestaurantComponent },
  { path: 'restaurant-list', component: RestaurantListComponent },
  { path: '', component: RestaurantListComponent },
  { path: 'edit-restaurant/:id', component: RestaurantEditComponent },
  { path: 'restaurants/:id/offres', component: OffreListComponent },
  { path: 'restaurants/:id/details', component: RestaurantDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
