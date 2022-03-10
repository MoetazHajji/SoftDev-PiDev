/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

/**
 *
 * @author mariem
 */
public class Commande {
     int num;
    int id_user;
static int tell;

    public static int getTell() {
        return tell;
    }

    public static void setTell(int tell) {
        Commande.tell = tell;
    }
   
   public static int produit;
    String id_produit;
    String nom_commande;
    String adresse ;
    String date_commande;
    int tel=0;
    String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public static int getProduit() {
        return produit;
    }

    public static void setProduit(int produit) {
        Commande.produit = produit;
    }
 
    
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    Float prix;
    String etat;
    int id_livreur;

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Float getPrix() {
        return prix;
    }

    public Commande(int num, int id_user) {
        this.num = num;
        this.id_user = id_user;
    }

    public Commande(int num, int id_user, String id_produit) {
        this.num = num;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    @Override
    public String toString() {
        return "Commande{" + "num=" + num + ", id_user=" + id_user + ", id_produit=" + id_produit + ", nom_commande=" + nom_commande + '}';
    }

    public Commande() {
    }

    public Commande(int num, int id_user, String id_produit, String nom_commande) {
        this.num = num;
        this.id_user = id_user;
        this.id_produit = id_produit;
        this.nom_commande = nom_commande;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }

    public void setNom_commande(String nom_commande) {
        this.nom_commande = nom_commande;
    }

    public int getNum() {
        return num;
    }

    public int getId_user() {
        return id_user;
    }

    public String getId_produit() {
        return id_produit;
    }

    public String getNom_commande() {
        return nom_commande;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
   
    
    
}

