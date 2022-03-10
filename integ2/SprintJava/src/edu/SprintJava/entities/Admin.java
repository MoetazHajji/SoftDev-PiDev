/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

import java.util.Objects;

/**
 *
 * @author moete
 */
public class Admin {
    private int id;
    private String nom;
    private String prenom;
    private int cin;
    private String avatar;
    private String username;
    private String email;
    private String pass ;
    private String role;
    private static int idd;
    private static String nomm;
    private static String prenomm;
    private static int cinn;
    private static String avatarr;
    private static String usernamee;
    private static String emaill;
    private static String passs ;
    private static String rolee;

    public static void setIdd(int idd) {
        Admin.idd = idd;
    }

    public static int getIdd() {
        return idd;
    }

    public static String getNomm() {
        return nomm;
    }

    public static void setNomm(String nomm) {
        Admin.nomm = nomm;
    }

    public static String getPrenomm() {
        return prenomm;
    }

    public static void setPrenomm(String prenomm) {
        Admin.prenomm = prenomm;
    }

    public static int getCinn() {
        return cinn;
    }

    public static void setCinn(int cinn) {
        Admin.cinn = cinn;
    }

    public static String getAvatarr() {
        return avatarr;
    }

    public static void setAvatarr(String avatarr) {
        Admin.avatarr = avatarr;
    }

    public static String getUsernamee() {
        return usernamee;
    }

    public static void setUsernamee(String usernamee) {
        Admin.usernamee = usernamee;
    }

    public static String getEmaill() {
        return emaill;
    }

    public static void setEmaill(String emaill) {
        Admin.emaill = emaill;
    }

    public static String getPasss() {
        return passs;
    }

    public static void setPasss(String passs) {
        Admin.passs = passs;
    }

    public static String getRolee() {
        return rolee;
    }

    public static void setRolee(String rolee) {
        Admin.rolee = rolee;
    }

    public Admin(String nom, String prenom,int cin, String username,String email,String pass,String avatar) {
        this.avatar = avatar;
        this.nom = nom;
        this.prenom = prenom;
        this.cin=cin;
        this.username=username;
        this.email = email;
        this.pass = pass;
    }

    public Admin(int id, String nom, String prenom, int cin, String username, String email, String pass, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public Admin(String nom, String prenom, int cin, String username, String email, String pass) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.username = username;
        this.email = email;
        this.pass = pass;
    }
    

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getCin() {
        return cin;
    }

    public Admin() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Admin(String email, String pass,String role) {
        this.email = email;
        this.pass = pass;
        this.role=role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Admin(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public Admin(String username) {
        this.username = username;
    }
    
    
    
    @Override
    public String toString() {
        return "Admin{" + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", username "+ username +", email=" + email + ", pass=" + pass + " , role= "+role+ '}'+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
}
