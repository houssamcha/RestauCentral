import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { AjouterRestaurantComponent } from './ajouter-restaurant/ajouter-restaurant.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantEditComponent } from './restaurant-edit/restaurant-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    AjouterRestaurantComponent,
    RestaurantEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
