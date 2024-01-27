package com.example.depotcolis.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_colis;
    private String numero, adresse_livraison, nom_destinataire, prenom_destinataire, tel_destinataire;
    private int id_depot;

    public Colis(){

    }

    public Colis(int id_colis, String numero, String adresse_livraison, String nom_destinataire, String prenom_destinataire, String tel_destinataire, int id_depot) {
        this.id_colis = id_colis;
        this.numero = numero;
        this.adresse_livraison = adresse_livraison;
        this.nom_destinataire = nom_destinataire;
        this.prenom_destinataire = prenom_destinataire;
        this.tel_destinataire = tel_destinataire;
        this.id_depot = id_depot;
    }

    public Colis(String numero, String adresse_livraison, String nom_destinataire, String prenom_destinataire, String tel_destinataire, int id_depot) {
        this.numero = numero;
        this.adresse_livraison = adresse_livraison;
        this.nom_destinataire = nom_destinataire;
        this.prenom_destinataire = prenom_destinataire;
        this.tel_destinataire = tel_destinataire;
        this.id_depot = id_depot;
    }

    public int getId_colis() {
        return this.id_colis;
    }

    public void setId_colis(int id_colis) {
        this.id_colis = id_colis;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAdresse_livraison() {
        return this.adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public String getNom_destinataire() {
        return this.nom_destinataire;
    }

    public void setNom_destinataire(String nom_destinataire) {
        this.nom_destinataire = nom_destinataire;
    }

    public String getPrenom_destinataire() {
        return this.prenom_destinataire;
    }

    public void setPrenom_destinataire(String prenom_destinataire) {
        this.prenom_destinataire = prenom_destinataire;
    }

    public String getTel_destinataire() {
        return this.tel_destinataire;
    }

    public void setTel_destinataire(String tel_destinataire) {
        this.tel_destinataire = tel_destinataire;
    }

    public int getId_depot() {
        return this.id_depot;
    }

    public void setId_depot(int id_depot) {
        this.id_depot = id_depot;
    }

}
