/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Ticket;
import edu.SprintJava.utils.MyConnection;
import java.sql.Connection;
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
 * @author khalil
 */
public class TicketCRUD {

    private Connection mc = MyConnection.getInstance().getCnx();

    public void ajouterTicket() {
        try {
            String requete = "INSERT INTO ticket(packet,prix, id_event, id_c)"
                    + " VALUES(?,?,?,?)";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setString(1, Ticket.getType());
            pst.setFloat(2, Ticket.getPrixx());
            pst.setInt(3, Ticket.getId_evv());
            pst.setInt(4, Ticket.getId_usss());
            pst.executeUpdate();
            System.out.println("ticket ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierTicket(int id_ticket, String packet, int prix) {
        try {
            String requete = "UPDATE ticket SET"
                    + " `packet`='" + packet + "' , `prix`='" + prix
                    + "'  where id_ticket='" + id_ticket + "' ";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Modification avec succes !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerTicket(int id_ticket) {
//        Ticket t = new Ticket();
        try {
//            String requete = "DELETE from ticket where id_ticket=?";
            String requete = "DELETE FROM ticket WHERE id_ticket='" + id_ticket + "' ";

            PreparedStatement pst = mc.prepareStatement(requete);
//            pst.setInt(1, t.getId_ticket());
            pst.executeUpdate();
            System.err.println("ticket supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList<Ticket> listerTicket() {
        ObservableList<Ticket> TicketList = FXCollections.observableArrayList();

//        List<Ticket> mylist = new ArrayList();
        try {
            String requete = "SELECT * FROM ticket";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                Ticket tick = new Ticket();
                tick.setId_ticket(rs.getInt("id_ticket"));
                tick.setPacket(rs.getString("packet"));
                tick.setPrix(rs.getInt("prix"));
                tick.setId_event(rs.getInt("id_event"));
                tick.setId_c(rs.getInt("id_c"));

                TicketList.add(tick);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return TicketList;

    }

}
