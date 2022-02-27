/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Client;
import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author moete
 */
public class ClientCRUD {
    public void ajouterClient(Client cl){
        try {
            String requete = "insert into client(nom,prenom,date_naissance,pays_ville,mobile,email,username,password,genre)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,cl.getNom());
            pst.setString(2,cl.getPrenom());
            pst.setString(3,cl.getDate_naissance());
            pst.setString(4,cl.getPays_ville());
            pst.setInt(5,cl.getMobile());
            pst.setString(6,cl.getEmail());
            pst.setString(7,cl.getUsername());
            pst.setString(8,cl.getPassword());
            pst.setString(9,cl.getGenre());
            pst.executeUpdate();
            System.err.println("Client Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public ObservableList<Client> ListerClient(){
         ObservableList<Client> ClientList =FXCollections.observableArrayList();
        try {
            String requete ="Select * from client";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Client cl =new Client();
                cl.setId(rs.getInt(1));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                cl.setDate_naissance(rs.getString("date_naissance"));
                cl.setPays_ville(rs.getString("pays_ville"));
                cl.setMobile(rs.getInt(6));
                cl.setEmail(rs.getString("email"));
                cl.setPassword(rs.getString("password"));
                cl.setGenre(rs.getString("genre"));
                ClientList.add(cl);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
        return ClientList;
    }
    public void modifierClient(String nom_c,String prenom_c,String date_naissance_c,String pays_ville_c,int mobile_c,String email_c,String password_c,String genre_c){
        try {
            String requete="UPDATE client SET"
                    + "`nom`='"+nom_c+"' , `prenom`='"+prenom_c+"' , `date_naissance`='"+date_naissance_c+"',`pays_ville`='"+prenom_c+"'"
                    +  ", `mobile`='"+mobile_c+"' ,`email` ='"+email_c+"' , `password`='"+password_c+"',`genre`='"+genre_c+"' where `nom`='"+nom_c+"' ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerClient(Client cl){
        try {
            String requete="DELETE from client where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, cl.getId());
            pst.executeUpdate();
            System.err.println("Client deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}
