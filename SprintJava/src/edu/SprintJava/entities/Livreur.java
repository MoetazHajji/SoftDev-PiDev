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
public class Livreur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String password;
    private static int idd;
    private static String nomm;
    private static String prenomm;
    private static String emaill;
    private static String usernamee;
    private static String passwordd;

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Livreur.idd = idd;
    }

    public static String getNomm() {
        return nomm;
    }

    public static void setNomm(String nomm) {
        Livreur.nomm = nomm;
    }

    public static String getPrenomm() {
        return prenomm;
    }

    public static void setPrenomm(String prenomm) {
        Livreur.prenomm = prenomm;
    }

    public static String getEmaill() {
        return emaill;
    }

    public static void setEmaill(String emaill) {
        Livreur.emaill = emaill;
    }

    public static String getUsernamee() {
        return usernamee;
    }

    public static void setUsernamee(String usernamee) {
        Livreur.usernamee = usernamee;
    }

    public static String getPasswordd() {
        return passwordd;
    }

    public static void setPasswordd(String passwordd) {
        Livreur.passwordd = passwordd;
    }
    

    public Livreur(int id, String nom, String prenom,String email,String username,String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public Livreur( String nom, String prenom,String email,String username,String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Livreur() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public String toString() {
        return "Livreur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +", Email=" + email +", Username=" + username +", Password=" + password + '}'+"\n";
    }
    
    
}
