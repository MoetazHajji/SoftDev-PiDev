/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

import java.sql.Date;

/**
 *
 * @author moete
 */
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String pays_ville;
    private int mobile;
    private String email;
    private String username;
    private String password;
    private String genre;
   
    private static int idd;
    private static String nomm;
    private static String prenomm;
    private static Date date_naissancee;
    private static String pays_villee;
    private static int mobilee;
    private static String emaill;
    private static String usernamee;
    private static String passwordd;
    private static String genree;

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Client.idd = idd;
    }

    public static String getNomm() {
        return nomm;
    }

    public static void setNomm(String nomm) {
        Client.nomm = nomm;
    }

    public static String getPrenomm() {
        return prenomm;
    }

    public static void setPrenomm(String prenomm) {
        Client.prenomm = prenomm;
    }

    public static Date getDate_naissancee() {
        return date_naissancee;
    }

    public static void setDate_naissancee(Date date_naissancee) {
        Client.date_naissancee = date_naissancee;
    }

    public static String getPays_villee() {
        return pays_villee;
    }

    public static void setPays_villee(String pays_villee) {
        Client.pays_villee = pays_villee;
    }

    public static int getMobilee() {
        return mobilee;
    }

    public static void setMobilee(int mobilee) {
        Client.mobilee = mobilee;
    }

    public static String getEmaill() {
        return emaill;
    }

    public static void setEmaill(String emaill) {
        Client.emaill = emaill;
    }

    public static String getUsernamee() {
        return usernamee;
    }

    public static void setUsernamee(String usernamee) {
        Client.usernamee = usernamee;
    }

    public static String getPasswordd() {
        return passwordd;
    }

    public static void setPasswordd(String passwordd) {
        Client.passwordd = passwordd;
    }

    public static String getGenree() {
        return genree;
    }

    public static void setGenree(String genree) {
        Client.genree = genree;
    }

    public Client(String nom, String prenom, Date date_naissance, String pays_ville,int mobile, String email,String username, String password, String genre) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.pays_ville = pays_ville;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public String getPays_ville() {
        return pays_ville;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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

    public void setDate_naissance(Date date_naissance) {
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
                ", pays_ville=" + pays_ville + ", mobile=" + mobile + ", email=" + email +", username=" + username + ", password=" + password + ", genre=" + genre +'}'+"\n";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
