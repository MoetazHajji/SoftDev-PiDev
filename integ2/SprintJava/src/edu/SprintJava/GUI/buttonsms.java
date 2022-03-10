/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.sun.prism.impl.Disposer;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import edu.SprintJava.entities.Commande;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.CommandeCRUD;
import edu.SprintJava.services.ProduitCRUD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;

/**
 *
 * @author mariem
 */
public class buttonsms extends TableCell<Disposer.Record, Boolean> {
   
    Stage primaryStage;
      private Stage stage;
     private static Launcher instance;
      private Scene scene;
        final Button cellButton = new Button("envoyer un sms");
        
         ProduitCRUD service_pr=new ProduitCRUD();
        buttonsms(){
         cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                
   



TextMessage message = new TextMessage("cultun",
        "21656024165",
        "votre commande a ete bien enregistrer"
);

SmsSubmissionResponse response =  VonageClient.builder().apiKey("7a79c388").apiSecret("X5NC3urmGXBM0J1M").build().getSmsClient().submitMessage(message);

if(response.getMessages().get(0).getStatus() == MessageStatus.OK) {
    System.out.println("Message sent successfully.");
} else {
    System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
}

                
                
                
                }
                   
            });
        
                    }
        
        

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
               // setGraphic(cellButton2);
                setGraphic(cellButton);
            }
        }
         
    }
    
