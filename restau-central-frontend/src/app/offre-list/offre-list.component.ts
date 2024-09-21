import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-offre-list',
  templateUrl: './offre-list.component.html',
  styleUrls: ['./offre-list.component.css']
})

export class OffreListComponent implements OnInit {
  restaurantId: number;
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
    this.offreService.getOffresByRestaurant(this.restaurantId)
      .subscribe(offres => this.offres = offres);
  }
}