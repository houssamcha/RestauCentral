package com.RestauCentral.RestauCentral.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant extends Client {

    private String name;
    private String address;
    private String phone;


    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Offre> offres;

//    @OneToMany(mappedBy = "restaurant")
//    private List<Commande> commandes;
}
