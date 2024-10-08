import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // Importez ReactiveFormsModule ici
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { AjouterRestaurantComponent } from './ajouter-restaurant/ajouter-restaurant.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantEditComponent } from './restaurant-edit/restaurant-edit.component';
import { OffreListComponent } from './offre-list/offre-list.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    AjouterRestaurantComponent,
    RestaurantEditComponent,
    OffreListComponent,
    RestaurantDetailsComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule, // Ajoutez ReactiveFormsModule ici
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
