import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterRestaurantComponent } from './ajouter-restaurant/ajouter-restaurant.component';

// Déclaration du tableau de routes
const routes: Routes = [
  { path: 'add-restaurant', component: AjouterRestaurantComponent },
  // Autres routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
