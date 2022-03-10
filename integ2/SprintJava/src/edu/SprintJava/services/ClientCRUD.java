/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Client;
import edu.SprintJava.utils.MyConnection;
import java.sql.Date;
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
import javax.swing.JOptionPane;

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
            pst.setDate(3,cl.getDate_naissance());
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
                cl.setDate_naissance(rs.getDate("date_naissance"));
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
    public void modifierClient(String nom_c,String prenom_c,int mobile_c,String email_c,String username_c,String password_c){
        try {
            String requete="UPDATE client SET"
                    + "`nom`='"+nom_c+"' , `prenom`='"+prenom_c+"'  , `mobile`='"+mobile_c+"' ,`email` ='"+email_c+"' , `username`='"+username_c+"', `password`='"+password_c+"' where `username`='"+username_c+"' ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerClient(String nom_cl){
        String requete="DELETE from client where `nom`='"+nom_cl+"'";
        try {
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Client deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public ObservableList<Client> rechercherClientById(String esmElcolumn,String elibechtlawej3lih) {
        ObservableList<Client> ClientList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM client WHERE "+esmElcolumn+" LIKE '%"+elibechtlawej3lih+"%'";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Client cl = new Client();
                
                cl.setId(rs.getInt(1));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                cl.setDate_naissance(rs.getDate("date_naissance"));
                cl.setPays_ville(rs.getString("pays_ville"));
                cl.setMobile(rs.getInt(6));
                cl.setUsername(rs.getString("usercvname"));
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
    
    public boolean Login1(String user, String password) throws Exception {
        boolean checkUser = false;
        Client ad = new Client();
        try {
            String requete = "SELECT * FROM client where username=? AND password=? ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, user);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "USERNAME AND PASSWORD MATCHED :)");
            } else {
                checkUser = false;
                JOptionPane.showMessageDialog(null, "USERNAME OR PASSWORD DO NOT MATCH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return checkUser;
    }
    public List<Client> afficherClient(String username){
     String requete="SELECT nom,prenom,date_naissance,mobile,email FROM client where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              c.setMobile(re.getInt("mobile"));
              c.setNom(re.getString("prenom"));
              c.setPrenom(re.getString("nom"));
              c.setDate_naissance(re.getDate("date_naissance"));
              c.setEmail(re.getString("email"));
              
              myList.add(c);
                
             
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(CommandeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     return myList;
     
     }
    public List<Client> afficherEmail(String username) throws SQLException{
     String requete="SELECT email,password FROM client where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              
              c.setEmail(re.getString("email"));
              c.setPassword(re.getString("password"));
              
              
              myList.add(c);
                
             
             }
     return myList;
     
     }

    
    
}
