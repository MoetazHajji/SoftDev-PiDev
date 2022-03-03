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
import edu.SprintJava.services.AdminCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class LoginController implements Initializable {

    @FXML
    private TextField TFUsername;
    @FXML
    private TextField TFPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
        try {
            AdminCRUD adc = new AdminCRUD();
            Admin ad =new Admin();
            adc.Login1(TFUsername.getText(), TFPassword.getText());
            closeStage();
            loadMain();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("CULTUN");
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void closeStage() {
        ((Stage) TFUsername.getScene().getWindow()).close();
    }
    /*private void detailParent(ActionEvent event) throws IOException {
        Admin data = new Admin();
        FXMLLoader loader =new FXMLLoader(getClass().getResource("HomeAdminPannelController")) ;
        HomeAdminPannelController hapc = Loader.getController();
        hapc.lo.ge
//        data = (Admin) table.getSelectionModel().getSelectedItem();
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageDetailParent.fxml"));
//                                
//                                 Parent root;
//                                root = loader.load();
//                                tfNom.getScene().setRoot(root);
//                                AffichageDetailParentController aca = loader.getController();
//                                aca.setId(data.getId());
//                                aca.setNom(data.getNom());
//                                aca.setPrenom(data.getPrenom());
                                //System.out.println(data.getIdClasse());
                                //System.out.println(data.getNomClasse());
        
        
    }*/
}
