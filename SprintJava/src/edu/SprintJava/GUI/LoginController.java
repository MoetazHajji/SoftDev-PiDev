/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Session;
import edu.SprintJava.entities.User;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.services.User_service;
import edu.SprintJava.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class LoginController implements Initializable {
    @FXML
    private TextField TFUsername;
    @FXML
    private PasswordField PFPassword;
    @FXML
    private Label LBError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) throws IOException{
         User_service us = new User_service();
        User u = new User();
        u.setUsername(TFUsername.getText());
        u.setPass(PFPassword.getText());
        int attempt = 1;
        if (us.Authentification(u)) {
            Parent home_page_parent;
            System.err.println(us.checkRole(TFUsername.getText()));
            if (us.checkRole(TFUsername.getText()).equals("Admin") && attempt < 4) {
               
                    Session.getFirstInstance(Session.getUser());
                    home_page_parent = FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                

            } else if (us.checkRole(TFUsername.getText()).equals("Client") && attempt < 4) {
                home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();

            } else if (us.checkRole(TFUsername.getText()).equals("Owner") && attempt < 4) {
                Session.getFirstInstance(Session.getUser());
                int ide = Session.getUser().getId();
                System.out.println(ide);
                home_page_parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();

            } else if (attempt != 4) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Denied!" + attempt);
                alert.showAndWait();
                attempt--;

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("attempt exceed!" + attempt);
                alert.showAndWait();

                PFPassword.setDisable(true);
                TFUsername.setEditable(false);
            }

            attempt++;

        }

    

//        try {
//            String username = TFUsername.getText();
//            String pass = PFPassword.getText();
//
//            String requete = "Select * from user where   email=? AND password=?";
//            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
//            pst.setString(1, username);
//            pst.setString(2, pass);
//            ResultSet rs=pst.executeQuery();
//            if(!rs.next()){
//               LBError.setTextFill(Color.RED);
//                LBError.setText("login Denied ..."
//                        + "\nENTER CORRECT USERNAME/PASSWORD !!");
////                showDialog("login Denied", null, "ENTER CORRECT USERNAME/PASSWORD !!");
//            }
//            else{
////               LBError.setTextFill(Color.GREEN);
////                LBError.setText("login Successful ...Redirecting");
//                showDialog("login Successful", null, "Successful");
//                Session.getInstance(userConnected);
//                closeStage();
//                loadMain();
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
//    private void showDialog(String info ,String header ,String title ){
//        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText(info);
//        alert.setHeaderText(header);
//        alert.showAndWait();
//    }
//
//    void loadMain() {
//        try {
//            Parent parent = FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
//            Stage stage = new Stage(StageStyle.DECORATED);
//            stage.setTitle("CULTUN");
//            stage.setScene(new Scene(parent));
//            stage.show();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
    private void closeStage() {
        ((Stage) TFUsername.getScene().getWindow()).close();
    }
//
//    @FXML
//    private void CloseLoginClient(ActionEvent event) {
//    }
//
//    String getUsername() {
//        return TFUsername.getText();
//    }
//
//    @FXML
//    private void CloseLoginAdmin(ActionEvent event) {
//        closeStage();
//    }

    @FXML
    private void CloseLoginClient(ActionEvent event) {
        closeStage();
    }

    @FXML
    private void CloseLoginAdmin(ActionEvent event) {
        closeStage();
    }
}
