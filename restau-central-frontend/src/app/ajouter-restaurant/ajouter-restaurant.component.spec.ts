import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterRestaurantComponent } from './ajouter-restaurant.component';

describe('AjouterRestaurantComponent', () => {
  let component: AjouterRestaurantComponent;
  let fixture: ComponentFixture<AjouterRestaurantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AjouterRestaurantComponent]
    });
    fixture = TestBed.createComponent(AjouterRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
