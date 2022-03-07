/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Session;
import edu.SprintJava.entities.User;
import edu.SprintJava.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author sa3do
 */
public class User_service {
    private Connection c = MyConnection.getInstance().getCnx();
    private Statement ste;
    public void ajouterUser(User A) {
        String requete = "insert into user (username,password,role,avatar) values('" + A.getUsername()+ "','" + A.getPass()+ "','" + A.getRole()+ "' , '"+A.getAvatar()+"' )";
        try {
            ste = c.createStatement();
            ste.executeUpdate(requete);
            System.out.println("user ajouté avec sucée");
        } catch (SQLException ex) {
            Logger.getLogger(User_service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public User get_User(int id) {
        String requete = "SELECT * FROM `user` WHERE (id =" + String.valueOf(id) + ")";

        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User us = new User(rs.getInt("id"),rs.getString("username"),rs.getString("Password"), rs.getString("role"));
                return us;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public String get_User2(int id )
    {
    String requete = "SELECT username FROM `user` WHERE (id =" + String.valueOf(id) + ")";
    String username="";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
             username= rs.getString(1);
            return username;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   return username;
    }
   public boolean Authentification(User u) {
        boolean status = false;
        
        try {
            String req = "select * from user where username=?";
            PreparedStatement ste = MyConnection.getInstance().getCnx().prepareStatement(req);
            ste.setString(1, u.getUsername());
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                System.out.println(u.getPass()+ "/" + rs.getString("password"));
                if (u.getPass().equals(rs.getString("password"))) {
                    status = true;
                    u = this.findById(rs.getInt("id"));
                    Session.setUser(u);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("username or Password incorrect");
                    alert.showAndWait();
                    status = false;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(status);
        return status;
    }
    public User findById(int idconnected) {
        User p = null;
        try {
            String req = "select  id,username,password,role from user where id=? ";
            PreparedStatement ste;
            ste = MyConnection.getInstance().getCnx().prepareStatement(req);
            ste.setInt(1, idconnected);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                p = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
        return p;
    }
    public String checkRole(String username) {
        String default_return = "ND";
        try {
            String req = "select role from user where username=?";
            PreparedStatement ste = MyConnection.getInstance().getCnx().prepareStatement(req);
            ste.setString(1, username);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                if (rs.getString("role").equals("Admin")) {

                    return "Admin";
                } else if (rs.getString("role").equals("Livreur")) {
                    return "Livreur";
                } else if (rs.getString("role").equals("Client")) {
                    return "Client";
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return default_return;
    }
   
}
