import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { HttpClientModule } from '@angular/common/http';
import { AjouterRestaurantComponent } from './ajouter-restaurant/ajouter-restaurant.component';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    AjouterRestaurantComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
