/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author moete
 */
public class Launcher extends Application {
    
    private Stage stage;
    private static Launcher instance;
    private Scene scene;

    public Launcher() throws IOException, InterruptedException {
        instance = this;

        scene = new Scene(FXMLLoader.load(getClass().getResource("LoginClient.fxml")));

        // System.out.println("");
    }

    public static Launcher getInstance() {
        return instance;

    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setScene(this.scene);
        stage.initStyle(StageStyle.DECORATED);// reduire et fermer decoredet* - 
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    public void changescene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    
    
    
    /*@Override
    public void start(Stage primaryStage) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("LoginClient.fxml"));
            Scene scene=new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("---Client Login---");
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
   
    
}
