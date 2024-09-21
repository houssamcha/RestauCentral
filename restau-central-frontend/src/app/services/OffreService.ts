import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Offre } from './offre.model';

@Injectable({
  providedIn: 'root'
})
export class OffreService {
  private baseUrl = 'http://localhost:8080/offres';

  constructor(private http: HttpClient) {}

  getOffresByRestaurantId(restaurantId: number): Observable<Offre[]> {
    return this.http.get<Offre[]>(`${this.baseUrl}/restaurant/${restaurantId}`);
  }

  getOffreById(id: number): Observable<Offre> {
    return this.http.get<Offre>(`${this.baseUrl}/${id}`);
  }
}
