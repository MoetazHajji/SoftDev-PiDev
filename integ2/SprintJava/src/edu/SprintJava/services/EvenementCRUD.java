/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author khalil
 */
public class EvenementCRUD {

    private Connection mc = MyConnection.getInstance().getCnx();

    public void ajouterEvenement(Evenement e) {
        try {
            String requete = "INSERT INTO evenement(nom_event,nbr_participant, date_debut, date_fin, emplacement, description, theme,image)"
                    + " VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setString(1, e.getNom_event());
            pst.setInt(2, e.getNbr_participant());
            pst.setDate(3, e.getDate_debut());
            pst.setDate(4, e.getDate_fin());
            pst.setString(5, (String) e.getEmplacement());
            pst.setString(6, (String) e.getDescription());
            pst.setString(7, (String) e.getTheme());
            pst.setString(8, (String) e.getImage());

            pst.executeUpdate();
            System.out.println("evenement ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierEvenement(int id_event, String nom_event, int nbr_participant, Date date_debut, Date date_fin, String emplacement, String description, String theme) {
        try {
            String requete = "UPDATE evenement SET"
                    + "`nom_event`='" + nom_event + "' ,`nbr_participant`='" + nbr_participant + "' ,`date_debut`='" + date_debut + "' , `date_fin`='" + date_fin
                    + "' , `emplacement`='" + emplacement + "' , `description`='" + description
                    + "' , `theme`='" + theme + "'  where id_event='" + id_event + "' ";

            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Modification avec succes !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerEvenement(Evenement e) {
        try {
            String requete = "DELETE from evenement where id=?";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setInt(1, e.getId_event());
            pst.executeUpdate();
            System.err.println("evenement supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerEvenementByName(String nom_event) {
        try {
            String requete = "DELETE FROM evenement WHERE nom_event='" + nom_event + "' ";
            PreparedStatement pst = mc.prepareStatement(requete);

            pst.executeUpdate();

            System.out.println("evenement supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList<Evenement> listerEvenement() {
        ObservableList<Evenement> EvenementList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT*FROM evenement";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                Evenement even = new Evenement();
                even.setId_event(rs.getInt("id_event"));
                even.setNom_event(rs.getString("nom_event"));
                even.setNbr_participant(rs.getInt("nbr_participant"));
                even.setDate_debut(rs.getDate("date_debut"));
                even.setDate_fin(rs.getDate("date_fin"));
                even.setEmplacement(rs.getString("emplacement"));
                even.setDescription(rs.getString("description"));
                even.setTheme(rs.getString("theme"));
                even.setImage(rs.getString("image"));
                EvenementList.add(even);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return EvenementList;

    }

    public boolean listeevent1 (String Nom_event, String Emplacement, int Nbr_participant ) {
        ObservableList<Evenement> EvenementList = FXCollections.observableArrayList();
         EvenementList = listerEvenement();
      return    EvenementList.stream().anyMatch(p -> p.getNom_event().equals(Nom_event) &&
              p.getEmplacement().equals(Emplacement) &&
              p.getNbr_participant()==(Nbr_participant));
      
      

    }
    public ObservableList<Evenement> listerEvent2() {
        ObservableList<Evenement> ActiviteList = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM evenement";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {

                Evenement act = new Evenement();
                act.setId_event(rs.getInt("id_event"));
                act.setNom_event(rs.getString("nom_event"));
                act.setDate_debut(rs.getDate("date_debut"));
                act.setDate_fin(rs.getDate("date_fin"));
                
                act.setEmplacement(rs.getString("emplacement"));
                act.setDescription(rs.getString("description"));
                act.setImage(rs.getString("image"));
               
                //act.setImage(rs.getString("image"));
                ActiviteList.add(act);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ActiviteList;
    }
}
