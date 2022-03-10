/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

/**
 *
 * @author khalil
 */
public class Ticket {
    private int id_ticket;
    private String packet;
    private int prix;
    private int id_event;
    private static int id_usss;
     private static int id_evv;
     private static String nom_event;
     private static String type;
      private static int prixx;

    public Ticket(int id_ticket, String packet, int prix, int id_event, int id_c) {
        this.id_ticket = id_ticket;
        this.packet = packet;
        this.prix = prix;
        this.id_event = id_event;
        this.id_c = id_c;
    }

    public static int getPrixx() {
        return prixx;
    }

    public static void setPrixx(int prixx) {
        Ticket.prixx = prixx;
    }
     

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Ticket.type = type;
    }

    public static String getNom_event() {
        return nom_event;
    }

    public static void setNom_event(String nom_event) {
        Ticket.nom_event = nom_event;
    }

    public static int getId_evv() {
        return id_evv;
    }

    public static void setId_evv(int id_evv) {
        Ticket.id_evv = id_evv;
    }
    

    public static int getId_usss() {
        return id_usss;
    }

    public static void setId_usss(int id_usss) {
        Ticket.id_usss = id_usss;
    }

    public Ticket(  int prix,String packet) {
        this.packet = packet;
        this.prix = prix;
        
    }

    public Ticket( int id_event , int prix,String packet) {
        this.packet = packet;
        this.prix = prix;
        this.id_event = id_event;
    }
    
    private int id_c;
    private static int pr;
        private static int id_t;
                private static int id_e;
                private static int id_cl;
                private static String pac;
                

    public static int getId_e() {
        return id_e;
    }

    public static void setId_e(int id_e) {
        Ticket.id_e = id_e;
    }

    public static int getId_cl() {
        return id_cl;
    }

    public static void setId_cl(int id_cl) {
        Ticket.id_cl = id_cl;
    }

    public static String getPac() {
        return pac;
    }

    public static void setPac(String pac) {
        Ticket.pac = pac;
    }


    public static int getId_t() {
        return id_t;
    }

    public static void setId_t(int id_t) {
        Ticket.id_t = id_t;
    }

    

    public static int getPr() {
        return pr;
    }

    public static void setPr(int pr) {
        Ticket.pr = pr;
    }
    

//    public Ticket(int parseInt, String text, int parseInt0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    

    @Override
    public String toString() {
        return "ticket{" + "id_ticket=" + id_ticket + ", packet=" + packet + ", prix=" + prix + ", id_event=" + id_event + ", id_c=" + id_c + '}';
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public Ticket(String packet, int prix, int id_event, int id_c) {
        
        this.packet = packet;
        this.prix = prix;
        this.id_event = id_event;
        this.id_c = id_c;
    }

    public Ticket() {
    }
    
}
