/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Client;
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
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author moete
 */
public class AdminCRUD {

    private Connection mc = MyConnection.getInstance().getCnx();

    public void ajouterAdmin(Admin a) {
        try {
            String requete = "insert into admin(nom,prenom,cin,username,email,pass,avatar)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setInt(3, a.getCin());
            pst.setString(4, a.getUsername());
            pst.setString(5, a.getEmail());
            pst.setString(6, a.getPass());
            pst.setString(7, a.getAvatar());
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
                ad.setId(rs.getInt("id"));
                ad.setNom(rs.getString("nom"));
                ad.setPrenom(rs.getString("prenom"));
                ad.setCin(rs.getInt("cin"));
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

    public void modifierAdmin(int id_a,String nom_a, String prenom_a, int cin_a, String username_a, String email_a, String pass_a) {
        try {
            String requete = "UPDATE Admin SET"
                    + " `nom`='" + nom_a + "' , `prenom`='" + prenom_a + "' , `cin`='" + cin_a + "' "
                    + ",`username`='" + username_a + "',`email` ='" + email_a + "' ,`pass`='" + pass_a + "'  where `id`='" + id_a + "' ";
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

    public List<Admin> rechercherAdmin(String nom) {
        List<Admin> AdminList = new ArrayList<>();
        //AdminList=rechercherAdminById();
        return AdminList.stream().filter(t -> t.getNom()== nom).collect(Collectors.toList());
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
     public Admin getAdmin (String mail)
    {
    Admin e = new Admin();
    String requete="select * from admin where email ='"+mail+"'";
        try {
            Statement st =mc.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
           
            
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setCin(rs.getInt(4));
                e.setUsername(rs.getString("username"));
                e.setEmail(rs.getString("email"));
                e.setPass(rs.getString("pass"));
                e.setRole(rs.getString("role"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    return e;
    
    }
     public Admin Login(String user, String password) {
        Admin ad = new Admin();
        try {
            String requete = "SELECT username , pass  FROM admin "
                    + "where username=? AND `pass`=? ";
            PreparedStatement st = mc.prepareStatement(requete);
            ResultSet rs = st.executeQuery();
            if (user.equals(rs.getString("username")) && password.equals(rs.getString("pass"))) {

                System.out.println("LOGIN accepté :)");

            } else {
                System.out.println("LOGIN refusé :( \n"
                        + "Vérifier vos données");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ad;
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
    public Admin loginAccount(String username){
        String requete="select username,pass from admin where username="+username+"";
        Admin ad = new Admin();

        try { 
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            ad.setEmail(rs.getString("username"));
            ad.setCin(rs.getInt("pass"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }
      public List<Admin> getAll() {
        List<Admin> list = new ArrayList<>();
       
        try {
            String req = "Select (nom,prenom,cin,username,email,pass) from admin";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Admin R = new Admin(rs.getString("nom"),rs.getString("prenom"),rs.getInt("cin"),rs.getString("username"),rs.getString("email"),rs.getString("pass"));
                list.add(R);
            }
                System.out.println("Admin List");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
       
    }
      public String afficherClient(String username) throws SQLException{
     String requete="SELECT email FROM admin where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              
              c.setEmail(re.getString("email"));
              
              
              myList.add(c);
                
             
             }
     return myList.get(0).getEmail();
     
     }
      public String afficherRole(String username) throws SQLException{
     String requete="SELECT role FROM admin where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              
              c.setEmail(re.getString("role"));
              
              
              myList.add(c);
                
             
             }
     return myList.get(0).getEmail();
     
     }
   
}
