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
import edu.SprintJava.entities.Sponsor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author khalil
 */
public class SponsorCRUD {

    private Connection mc = MyConnection.getInstance().getCnx();

    public void ajouterSponsor(Sponsor p) {
        try {
            String requete = "INSERT INTO sponsor (nom_sponsor,idAdmin ,prenom_sponsor, num_sponsor, type_sponsor, id_event)"
                    + " VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = mc.prepareStatement(requete);

            pst.setString(1, p.getNom_sponsor());
            pst.setInt(2, Sponsor.getId_e());
            pst.setString(3, p.getPrenom_sponsor());
            pst.setInt(4, p.getNum_sponsor());
            pst.setString(5, p.getType_sponsor());
            pst.setInt(6, Evenement.getIdeee());

            pst.executeUpdate();
            System.out.println("sponsor ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierSponsor(int id_sponsor,String nom_sponsor, String prenom_sponsor, int num_sponsor, String type_sponsor) {
        try {
            String requete = "UPDATE sponsor SET"
                    + "`nom_sponsor`='" + nom_sponsor + "' ,`prenom_sponsor`='" + prenom_sponsor + "' , `num_sponsor`='" + num_sponsor
                    + "' , `type_sponsor`='" + type_sponsor
                    + "'  where id_sponsor='" + id_sponsor + "' ";

            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Modification avec succes !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerSponsor(String nom) {
        try {
            String requete = "DELETE from sponsor where nom_sponsor='" + nom + "'";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("sponsor supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList<Sponsor> listerSponsor() {
        ObservableList<Sponsor> TicketList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM sponsor";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                Sponsor sp = new Sponsor();
                sp.setId_sponsor(rs.getInt("id_sponsor"));
                sp.setNom_sponsor(rs.getString("nom_sponsor"));
                sp.setPrenom_sponsor(rs.getString("prenom_sponsor"));
                sp.setNum_sponsor(rs.getInt("num_sponsor"));
                sp.setType_sponsor(rs.getString("type_sponsor"));
                sp.setId_event(rs.getInt("id_event"));
                TicketList.add(sp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return TicketList;

    }

}
