package com.RestauCentral.RestauCentral.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;       // Identifiant unique du client
    private String nom;          // Nom du client
    private String adresse;      // Adresse du client
    private String contact;      // Contact du client (numéro de téléphone ou email)
    private int pointsFidelite;  // Points de fidélité du client
    // private List<Commande> commandes; // Liste des commandes passées par le client


    // Méthode pour effectuer une opération, par exemple passer une commande
    public void operation() {

    }
}
