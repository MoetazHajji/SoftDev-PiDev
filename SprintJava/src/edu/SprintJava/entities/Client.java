/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

/**
 *
 * @author moete
 */
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String pays_ville;
    private int mobile;
    private String email;
    private String password;
    private String genre;

    public Client(int id, String nom, String prenom, String date_naissance, String pays_ville,int mobile, String email, String password, String genre) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.pays_ville = pays_ville;
        this.mobile = mobile;
        this.email = email;
        this.password=password;
        this.genre = genre;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String getPays_ville() {
        return pays_ville;
    }

    public String getEmail() {
        return email;
    }

    public int getMobile() {
        return mobile;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setPays_ville(String pays_ville) {
        this.pays_ville = pays_ville;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + 
                ", pays_ville=" + pays_ville + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", genre=" + genre +'}'+"\n";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
