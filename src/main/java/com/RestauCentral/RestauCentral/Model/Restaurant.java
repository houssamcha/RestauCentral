package com.RestauCentral.RestauCentral.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue()
    private int id;
    private String name;
    private String address;
    private String phone;

    
}
