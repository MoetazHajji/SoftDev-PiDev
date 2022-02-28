/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Livreur;
import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author moete
 */
public class LivreurCRUD {
    public void ajouterLivreur(Livreur a){
        try {
            String requete = "insert into livreur(nom,prenom,email,username,password)"
                    + "values(?,?,?,?,?)";
            PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,a.getNom());
            pst.setString(2,a.getPrenom());
            pst.setString(3,a.getEmail());
            pst.setString(4,a.getPrenom());
            pst.setString(5,a.getPassword());
            pst.executeUpdate();
            System.err.println("Livreur Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    public ObservableList<Livreur> ListerLivreur(){
         ObservableList<Livreur> LivreurList=FXCollections.observableArrayList();
        try {
            String requete ="Select * from livreur";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Livreur li =new Livreur();
                li.setNom(rs.getString("nom"));
                li.setPrenom(rs.getString("prenom"));
                li.setEmail(rs.getString("email"));
                li.setUsername(rs.getString("username"));
                li.setPassword(rs.getString("password"));
                LivreurList.add(li);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
        return LivreurList;
    }
    
    public void modifierLivreur(String nom_l,String prenom_l,String email_l,String username_l,String password_l){
        try {
            String requete="UPDATE livreur SET `nom`='"+nom_l+"' , `prenom`='"+prenom_l+"'  "
                    + ", `prenom`='"+email_l+"' , `prenom`='"+username_l+"' , `prenom`='"+password_l+"'  where `nom`='"+nom_l+"' ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerLivreur(Livreur li){
        try {
            String requete="DELETE from livreur where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, li.getId());
            pst.executeUpdate();
            System.err.println("livreur deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public ObservableList<Livreur> rechercherLivreurById(String esmElcolumn,String elibechtlawej3lih) {
        ObservableList<Livreur> LivreurList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM livreur WHERE "+esmElcolumn+" LIKE '%"+elibechtlawej3lih+"%'";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livreur li = new Livreur();
                
                li.setId(rs.getInt(1));
                li.setNom(rs.getString("nom"));
                li.setPrenom(rs.getString("prenom"));
                li.setEmail(rs.getString("email"));
                li.setUsername(rs.getString("username"));
                li.setPassword(rs.getString("password"));

                LivreurList.add(li);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return LivreurList;
    }
}
