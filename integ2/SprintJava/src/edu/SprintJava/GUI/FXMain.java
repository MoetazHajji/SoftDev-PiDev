/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.mailing;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author moete
 */
public class FXMain extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        try {
          //  mailing m=new mailing();
      //  m.send("asmaoudherfi91@gmail.com","esmaesprit2000", "moetaz.hajji@esprit.tn", "qsddqsdq", "sdqdqs");
            Parent root=FXMLLoader.load(getClass().getResource("produitfront.fxml"));
            Scene scene=new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("---Admin Login---");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
