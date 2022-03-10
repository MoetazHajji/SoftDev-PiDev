/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.utils;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

/**
 *
 * @author moete
 */
public class Notification {
    public static void main(String sujet ,String contenu ) throws AWTException{
        if(SystemTray.isSupported()){
            Notification td =new Notification();
            td.displayTray(sujet,contenu);
        }else{
            System.err.println("System Tray is not Supported!!");
        }
    }
    public void  displayTray(String sujet ,String contenu ) throws AWTException{
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.gif");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage(sujet, contenu, TrayIcon.MessageType.INFO);
    }
}
