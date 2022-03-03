/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Session;
//import edu.SprintJava.entities.User;
import java.sql.PreparedStatement;
import edu.SprintJava.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author moete
 */
public class AdminCRUD {

    private Connection mc = MyConnection.getInstance().getCnx();

    public void ajouterAdmin(Admin a) {
        try {
            String requete = "insert into admin(nom,prenom,cin,username,email,pass)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setInt(3, a.getCin());
            pst.setString(4, a.getUsername());
            pst.setString(5, a.getEmail());
            pst.setString(6, a.getPass());
            pst.executeUpdate();
            System.err.println("Admin Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public ObservableList<Admin> ListerAdmin() {
        ObservableList<Admin> AdminList = FXCollections.observableArrayList();
        try {
            String requete = "Select * from Admin";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setNom(rs.getString("nom"));
                ad.setPrenom(rs.getString("prenom"));
                ad.setCin(rs.getInt(4));
                ad.setUsername(rs.getString("username"));
                ad.setEmail(rs.getString("email"));
                ad.setPass(rs.getString("pass"));
                ad.setRole(rs.getString("role"));
                AdminList.add(ad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AdminList;
    }

    public void modifierAdmin(String nom_a, String prenom_a, int cin_a, String username_a, String email_a, String pass_a, String role_a) {
        try {
            String requete = "UPDATE Admin SET"
                    + " `nom`='" + nom_a + "' , `prenom`='" + prenom_a + "' , `cin`='" + cin_a + "' "
                    + ",`username`='" + username_a + "',`email` ='" + email_a + "' ,`pass`='" + pass_a + "' , `role`='" + role_a + "'  where `nom`='" + nom_a + "' ";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerAdminById(Admin ad) {
        try {
            String requete = "DELETE from Admin where id=?";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setInt(1, ad.getId());
            pst.executeUpdate();
            System.err.println("Admin deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void SupprimerAdmin(String nom_a) {
        String requete = "DELETE FROM admin WHERE `nom`='" + nom_a + "' ";
        try {
            Statement st = mc.createStatement();
            st.executeUpdate(requete);
            System.out.println("Admin deleted");
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Admin getAdmin(String username) {
        String requete = "SELECT * FROM `admin` WHERE (username =" + String.valueOf(username) + ")";
        Admin ad = new Admin();
        try {
            Statement ps = mc.createStatement();
            ResultSet rs = ps.executeQuery(requete);

            while (rs.next()) {

                ad.setUsername(rs.getString("username"));
                return ad;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getAdmin2(String nom) {
        String requete = "SELECT * FROM `admin` WHERE (nom =" + nom + ")";
        String role = "";
        try {
            PreparedStatement ps = mc.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            role = rs.getString(8);
            return role;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());;
        }
        return role;
    }

    public ObservableList<Admin> rechercherAdminById(String esmElcolumn, String elibechtlawej3lih) {
        ObservableList<Admin> AdminList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM admin WHERE " + esmElcolumn + " LIKE '%" + elibechtlawej3lih + "%'";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Admin ad = new Admin();

                ad.setId(rs.getInt(1));
                ad.setNom(rs.getString("nom"));
                ad.setPrenom(rs.getString("prenom"));
                ad.setCin(rs.getInt(4));
                ad.setRole(rs.getString("username"));
                ad.setEmail(rs.getString("email"));
                ad.setPass(rs.getString("pass"));

                AdminList.add(ad);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return AdminList;
    }

    public List<Admin> rechercherAdmin(int id) {
        List<Admin> AdminList = new ArrayList<>();
        //AdminList=rechercherAdminById();
        return AdminList.stream().filter(t -> t.getId() == id).collect(Collectors.toList());
    }

    public void affecterAdminRolle(String nom_a, String role_a) {
        try {
            String requete = "update Admin SET `role`='" + role_a + "' Where `nom`='" + nom_a + "'  ";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.out.println("Admin Affecté !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public boolean Login1(String user, String password) throws Exception {
        boolean checkUser = false;
        Admin ad = new Admin();
        try {
            String requete = "SELECT * FROM admin where username=? AND pass=? ";
            PreparedStatement pst = mc.prepareStatement(requete);
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

}
