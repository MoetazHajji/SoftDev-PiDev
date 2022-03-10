/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

/**
 *
 * @author khalil
 */
public class Sponsor {

    private int id_sponsor;
    private int id_admin;
    private String nom_sponsor;
    private String prenom_sponsor;
    private int num_sponsor;
    private String type_sponsor;
    private int id_event;
    private static int id_s;
    private static int n_s;
    private static int id_e;
    private static String nom_s;
    private static String prenom_s;
    private static String type_s;

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    
    public static int getId_s() {
        return id_s;
    }

    public static void setId_s(int id_s) {
        Sponsor.id_s = id_s;
    }

    public static int getN_s() {
        return n_s;
    }

    public static void setN_s(int n_s) {
        Sponsor.n_s = n_s;
    }

    public static int getId_e() {
        return id_e;
    }

    public static void setId_e(int id_e) {
        Sponsor.id_e = id_e;
    }

    public static String getNom_s() {
        return nom_s;
    }

    public static void setNom_s(String nom_s) {
        Sponsor.nom_s = nom_s;
    }

    public static String getPrenom_s() {
        return prenom_s;
    }

    public static void setPrenom_s(String prenom_s) {
        Sponsor.prenom_s = prenom_s;
    }

    public static String getType_s() {
        return type_s;
    }

    public static void setType_s(String type_s) {
        Sponsor.type_s = type_s;
    }

    @Override
    public String toString() {
        return "sponsor{" + "id_sponsor=" + id_sponsor + ", nom_sponsor=" + nom_sponsor + ", prenom_sponsor=" + prenom_sponsor + ", num_sponsor=" + num_sponsor
                + ", type_sponsor=" + type_sponsor + ", id_event=" + id_event + '}';
    }

    public int getId_sponsor() {
        return id_sponsor;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public String getNom_sponsor() {
        return nom_sponsor;
    }

    public void setNom_sponsor(String nom_sponsor) {
        this.nom_sponsor = nom_sponsor;
    }

    public String getPrenom_sponsor() {
        return prenom_sponsor;
    }

    public void setPrenom_sponsor(String prenom_sponsor) {
        this.prenom_sponsor = prenom_sponsor;
    }

    public int getNum_sponsor() {
        return num_sponsor;
    }

    public void setNum_sponsor(int num_sponsor) {
        this.num_sponsor = num_sponsor;
    }

    public String getType_sponsor() {
        return type_sponsor;
    }

    public void setType_sponsor(String type_sponsor) {
        this.type_sponsor = type_sponsor;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public Sponsor(String nom_sponsor, String prenom_sponsor, int num_sponsor, String type_sponsor, int id_event) {

        this.nom_sponsor = nom_sponsor;
        this.prenom_sponsor = prenom_sponsor;
        this.num_sponsor = num_sponsor;
        this.type_sponsor = type_sponsor;
        this.id_event = id_event;
    }

    public Sponsor() {
    }

    public Sponsor(int id_sponsor, int id_admin, String nom_sponsor, String prenom_sponsor, int num_sponsor, String type_sponsor, int id_event) {
        this.id_sponsor = id_sponsor;
        this.id_admin = id_admin;
        this.nom_sponsor = nom_sponsor;
        this.prenom_sponsor = prenom_sponsor;
        this.num_sponsor = num_sponsor;
        this.type_sponsor = type_sponsor;
        this.id_event = id_event;
    }
    

}
