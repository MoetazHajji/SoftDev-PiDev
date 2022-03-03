/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

import edu.SprintJava.services.AdminCRUD;

/**
 *
 * @author moete
 */
public class Session {
     private static int idAdmin;
     private static String Username;
   

    public static void start(int currentUserID) {
        idAdmin = currentUserID;
    }

    public static int getCurrentSession() throws Exception {
        if (idAdmin != -1) {
            return idAdmin;
        } else {
            throw new Exception("Session has not started yet!");
        }
    }

    public static void close() throws Exception {
        if (idAdmin != -1) {
            idAdmin = -1;
        } else {
            throw new Exception("Session has not started yet!");
        }
    }
    public static Admin get()
    {
        AdminCRUD adc = new AdminCRUD();
        
        Admin ad = adc.getAdmin(Username);
        return ad;
        
    }

    
}
