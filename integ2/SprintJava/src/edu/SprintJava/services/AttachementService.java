/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import com.mysql.jdbc.Statement;
import edu.SprintJava.entities.Attachement;
import edu.SprintJava.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moete
 */
public class AttachementService {
    Connection conn;
    PreparedStatement ste;

    public AttachementService() {
        conn = MyConnection.getInstance().getCnx();
    }

      public int ajouterAttachement(Attachement a) {
        int id = 0;
        String sql = "insert into attachement(name,path) Values(?,?)";
        try {
            ste = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ste.setString(1, a.getName());
            ste.setString(2, a.getPath());
            ste.executeUpdate();
            System.out.println("Attachement Ajoutée");
            ResultSet rs=ste.getGeneratedKeys();
           if(rs.next()){
                  id=rs.getInt(1);
                         }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return id;
    }
    
        public void SupprimerAttachement(Attachement a){
             String sql = "delete from attachement where Id=?";
        try {
           ste = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
           ste.setInt(1, a.getId());
           ste.executeUpdate(); 
            System.out.println("Attachement Supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());  
        }
    }
        
        
   public Attachement findById(int id) {
        Attachement a = null;
        try {
            String req = "select * from Attachement where id=? ";
            ste = conn.prepareStatement(req);
            ste.setInt(1, id);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                a = new Attachement(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

      public Attachement findByPath(String Path) {
        Attachement a = null;
        try {
            String req = "select path from Attachement where path=? ";
            ste = conn.prepareStatement(req);
            ste.setString(1, Path);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                a = new Attachement(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
}
