import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OffreService } from 'src/app/services/OffreService';  // Assure-toi d'avoir défini ce service
import { Offre } from 'src/app/Model/Offre.model';  // Import du modèle Offre

@Component({
  selector: 'app-offre-list',
  templateUrl: './offre-list.component.html',
  styleUrls: ['./offre-list.component.css']
})
export class OffreListComponent implements OnInit {
  restaurantId: number | null = null;
  offres: Offre[] = [];

  constructor(
    private route: ActivatedRoute,
    private offreService: OffreService
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.restaurantId = +params['id'];
      this.loadOffres();
    });
  }

  loadOffres() {
    if (this.restaurantId) {
      this.offreService.getOffresByRestaurantId(this.restaurantId)
        .subscribe(offres => this.offres = offres);
    }
  }
}
