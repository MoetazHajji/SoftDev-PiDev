/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

import java.sql.Date;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author khalil
 */
public class Evenement {
    private int id_event;
    private String nom_event;
    private int nbr_participant;
    private Date date_debut;
    private Date date_fin;
    private String emplacement;
    private String description;
    private String theme;
    private String image;
    private static int id;
    private static int nbr;
    private static String nom;
    private static String place;
    private static String descrip;
    private static String teme;
    private static Date d_deb;
    private static Date d_f;
    private static int ideee;

    public static int getIdeee() {
        return ideee;
    }

    public static void setIdeee(int ideee) {
        Evenement.ideee = ideee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public ImageView getImg() {
        ImageView img = null;
        try{
            Image new_image = new Image("file:" +image);      
            img = new ImageView();
            img.setImage(new_image); 
            img.setFitWidth(150);
            img.setFitHeight(150);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return img;
    }

    
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Evenement.id = id;
    }

    public static int getNbr() {
        return nbr;
    }

    public static void setNbr(int nbr) {
        Evenement.nbr = nbr;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Evenement.nom = nom;
    }

    public static String getPlace() {
        return place;
    }

    public static void setPlace(String place) {
        Evenement.place = place;
    }

    public static String getDescrip() {
        return descrip;
    }

    public static void setDescrip(String descrip) {
        Evenement.descrip = descrip;
    }

    public static String getTeme() {
        return teme;
    }

    public static void setTeme(String teme) {
        Evenement.teme = teme;
    }

    public static Date getD_deb() {
        return d_deb;
    }

    public static void setD_deb(Date d_deb) {
        Evenement.d_deb = d_deb;
    }

    public static Date getD_f() {
        return d_f;
    }

    public static void setD_f(Date d_f) {
        Evenement.d_f = d_f;
    }
    
    
    
//    private int prix;
//    private String type_ticket  //gold silver ..;

    @Override
    public String toString() {
        return "evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", nbr_participant=" + nbr_participant + ", date_debut=" + date_debut + ", date_fin=" + date_fin + 
                ", emplacement=" + emplacement + ", description=" + description + ", theme=" + theme +'}';
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

   

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public int getNbr_participant() {
        return nbr_participant;
    }

    public void setNbr_participant(int nbr_participant) {
        this.nbr_participant = nbr_participant;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    

    public Evenement(String nom_event, int nbr_participant, Date date_debut, Date date_fin, String emplacement, String description, String theme) {
        
        this.nom_event = nom_event;
        this.nbr_participant = nbr_participant;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.emplacement = emplacement;
        this.description = description;
        this.theme = theme;
        
    }

    public Evenement(String nom_event, int nbr_participant, Date date_debut, Date date_fin, String emplacement, String description, String theme, String image) {
        this.nom_event = nom_event;
        this.nbr_participant = nbr_participant;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.emplacement = emplacement;
        this.description = description;
        this.theme = theme;
        this.image = image;
    }
    public static String pathfile; 
    public static String filename="";

   

    public Evenement() {
    }
    
    
    
    
    
    
    
}
