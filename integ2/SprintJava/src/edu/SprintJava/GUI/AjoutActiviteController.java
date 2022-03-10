/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Activite;
import edu.SprintJava.services.ActiviteCRUD;
import edu.SprintJava.utils.ControleSaisie;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Soulaymen
 */
public class AjoutActiviteController implements Initializable {
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
     final FileChooser fileChooser = new FileChooser();

    ObservableList<String> Horaires = FXCollections.observableArrayList("00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00");

    ObservableList<String> types = FXCollections.observableArrayList("Patrimoniale", "Ecotouristique", "Educatif", "Traditionnels", "Spirituels et religieux");
    @FXML
    private TextField tfNom;
    private TextField tfPrix;
    @FXML
    private TextField tfLocalisation;

    @FXML
    private ChoiceBox<String> cbType;
    private Slider sNombreplaces;
    @FXML
    private Button btnAjouter;
    @FXML
    private TextField tfDuree;
    @FXML
    private ChoiceBox<String> cbHoraire;
    private TextField tfDate;
    private TextField tfNbre_place;
    @FXML
    private DatePicker dpDate;
    @FXML
    private Spinner<Integer> snbr;
    @FXML
    private Spinner<Integer> sPrix;
    private Path pathfrom;
    private Path pathto;
    private File Current_file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SpinnerValueFactory<Integer> ValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 80);
        ValueFactory.setValue(1);
        snbr.setValueFactory(ValueFactory);
        SpinnerValueFactory<Integer> ValueFactoryprix = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 200);
        ValueFactoryprix.setValue(1);
        sPrix.setValueFactory(ValueFactoryprix);
        cbType.setItems(types);
        cbType.setValue("Patrimoniale");
        cbHoraire.setItems(Horaires);
        cbHoraire.setValue("00:00");
    }

    @FXML
    private void AjouterActivite(ActionEvent event) throws IOException {
        //String pattern = "MM/dd/yyyy";
       // DateFormat df = new SimpleDateFormat(pattern);

       // String datepickerAsString = df.format(dpDate.getValue());
       
       ControleSaisie cs = new ControleSaisie();
        if(!cs.testAdr(tfLocalisation.getText())){
            JOptionPane.showMessageDialog(null,"Insérer une adresse correct");
 
        }
        else{
         ActiviteCRUD pcd = new ActiviteCRUD();
        Activite a = new Activite();
        
        a.setNom(tfNom.getText());
        a.setType(cbType.getValue());
        a.setPrix(sPrix.getValue());
String date = dpDate.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        a.setDate(date);
        a.setTemp(cbHoraire.getValue());
        a.setDuree(tfDuree.getText());
        a.setLocalisation(tfLocalisation.getText());
        a.setNbre_places(snbr.getValue());
           a.setImage(Activite.pathfile);

//        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
//        pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\imgproj\\images\\" + Current_file.getName());
//        Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\imgproj\\images\\");
//
//        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);

        pcd.ajouterActivite(a);

       

        
            
            Parent root=FXMLLoader.load(getClass().getResource("AfficherActivite.fxml"));
            Scene scene=new Scene(root);

            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        
        
/*
        ActiviteCRUD pcd = new ActiviteCRUD();
        Activite a = new Activite();
        
        a.setNom(tfNom.getText());
        a.setType(cbType.getValue());
        a.setPrix(Integer.parseInt(tfPrix.getText()));
        a.setDate(tfDate.getText());
        a.setTemp(cbHoraire.getValue());
        a.setDuree(tfDuree.getText());
        a.setLocalisation(tfLocalisation.getText());
        a.setNbre_places(Integer.parseInt(tfNbre_place.getText()));

        pcd.ajouterActivite(a);

        //  System.out.println(pcd.trierActivite("VisiteColisee"));*/
    }

}

    @FXML
    private void back(ActionEvent event) throws IOException {
           
                Parent root = FXMLLoader.load(getClass().getResource("AfficherActivite.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
          
    }
     public static String pathfile; 
    public static String filename="";
    @FXML
    private void uploadImage(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("imgR", ".jpeg",".png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            String img = f.getAbsoluteFile().toURI().toString();
            Image imgR = new Image(img);
            //imgviewRestau.setImage(imgR);
            Activite.pathfile = f.getAbsolutePath();
            Activite.filename = f.getAbsolutePath();
            String path = "C:\\Users\\moete\\OneDrive\\Desktop\\3eme\\Semester 2\\integ2\\SprintJava\\src\\edu\\SprintJava\\uploads";
            File uploads = new File(path);
            String imagecomp = f.getAbsolutePath();
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                  pathfile = imagecomp.substring(index + 1);
            }          
            File sf = null;
            sf = new File(filename);
            File dest = null;
            Random rand = new Random();
            int n = rand.nextInt(50);
            String newpath =  path + pathfile ;
            dest = new File(newpath);
            Files.copy(sf.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            pathfile =  newpath ;
            System.out.println(pathfile);
        } 
    }
}
