/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.Commande;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.entities.Session;
import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariem
 */
public class CommandeCRUD {
  
     public List<Integer> recuperer_id()
    {
        List<Integer>listid = new ArrayList();
        int idd=0;
        
        for(int i=0;i<Produit.getPanier().size();i++)
       {
         listid.add(Produit.getPanier().get(i).getId_produit());
       }
    
    
        
        return listid;
    }
     public float calcule_totale()
     {
        float c=0.0f; 
      for(int i=0;i<Produit.getPanier().size();i++)
       {
          c= Produit.getPanier().get(i).getPrix();
         
       }
      return c;
     }
     public String sysdate()
     {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
               LocalDate date = java.time.LocalDate.now();
          return    date.toString();
     }
      public String affichernom(String username){
     String requete="SELECT mobile,nom FROM client where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              c.setMobile(re.getInt("mobile"));
               
                 c.setNom(re.getString("nom"));
                
               
                
                //per.setNo(re.getString("nom"));
                 
                 
               myList.add(c);
                 System.out.println(myList);
             
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(CommandeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     return myList.get(0).getNom();
     
     }
      
    public String afficheradresse(String username){
     String requete="SELECT mobile,nom,pays_ville FROM client where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              c.setMobile(re.getInt("mobile"));
               
                 c.setNom(re.getString("nom"));
                
               
                
                //per.setNo(re.getString("nom"));
                 
                 
               myList.add(c);
                 System.out.println(myList);
             
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(CommandeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     return myList.get(0).getPays_ville();
     
     }
                
       
   
       public int affichertel(String username){
     String requete="SELECT mobile FROM client where username = '"+username+"' ";
            List<Client>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
                Client c = new Client();
              c.setMobile(re.getInt("mobile"));
               
                
               
                
                //per.setNo(re.getString("nom"));
                 
                 
               myList.add(c);
                 System.out.println(myList);
             
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(CommandeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     return myList.get(0).getMobile();
     
     }
       
     
     
     
     public void ajouter_commande(Commande cc)
    {
        int tell=0;
          List<Integer>listid = new ArrayList();
           listid=recuperer_id();
          // tell=affichertel();
           
          float totale=Produit.getTotal();
         
   
        try {
            
           
            String requete="INSERT INTO commandeee(num,id_user,produit,nom,adresse,tel,etat,date_commande,total_prix)VALUES(?,?,?,?,?,?,?,?,?)";
             PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setInt(1,cc.getNum() );
             pst.setInt(2, Session.getUser().getId());
              for(int i=0;i<Produit.getPanier().size();i++)
             {
                 pst.setInt(3, Produit.getPanier().get(i).getId_produit());
             }
            
               pst.setString(4, affichernom(Session.getUser().getUsername()));
               pst.setString(5,Session.getUser().getUsername() );
               pst.setInt(6, affichertel(Session.getUser().getUsername()));
               pst.setString(7,"encours de traitement");
               pst.setString(8, sysdate());
               
               pst.setFloat(9,totale);
               
             
            
                pst.executeUpdate();
                System.out.println("produitajoutee");
             
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        
    
    
    }
             
          public List<Produit> recupererprod(){
     String requete="SELECT * from produit ";
            List<Produit>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                Produit per = new Produit();
                per.setId_produit(re.getInt("id_produit"));
                
                 per.setNom_produit(re.getString("nom"));
                
                
                 per.setPrix(re.getFloat("prix"));
                  per.setStock(re.getInt("stock"));
               myList.add(per);
               
             
             }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
     return myList;
     
     }
           public Produit recuperer(int id)
          {
              
              
              for(int i=0;i< recupererprod().size();i++)
              {
                  if(recupererprod().get(i).getId_produit()==id)
                      return recupererprod().get(i);
              
              
              }
              return null;
                 
          
          
          }
       
         public List<Commande> afficher(){
     String requete="SELECT * from commandeee";
            List<Commande>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
             Commande per = new Commande();
              per.setNum(re.getInt("num"));
                per.setId_user(re.getInt("id_user"));
                
                    Commande.setProduit(re.getInt("produit"));
                 
                
                 per.setNom(re.getString("nom"));
                
                per.setAdresse(re.getString("adresse"));
                 per.setTel(re.getInt("tel"));
                  
                per.setEtat(re.getString("etat"));
                per.setDate_commande(re.getString("date_commande"));
                
                 per.setPrix(re.getFloat("total_prix"));
                
               
                
                //per.setNo(re.getString("nom"));
                 
                 
               myList.add(per);
               
             
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(CommandeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     return myList;
     
     }
         public boolean supprimer(Commande p)
          {
          
                String requete = "DELETE from Commandeee where num=?";
       
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                  pst.setInt(1, p.getNum());
                 pst.executeUpdate();
                 System.out.println(" supp");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
             }
              
             
                return true;
            
       
        
      
       
            
          
          }
         
         
         public void etat(int id)
         {
               Commande c = new Commande();
             String requete= "update commandeee  set etat = 'valide' where num = '"+id+"' ; "  ;    
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                   //pst.setInt(1,id);
                
                  pst.executeUpdate();
            
                  
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        
         
         
         
         
         }
         public void  envoyersms(int tel)
         {
             TextMessage message = new TextMessage("Vonage APIs",
        "21656024165",
        "A text message sent using the Vonage SMS API"
             );
     VonageClient client = VonageClient.builder().apiKey("7a79c388").apiSecret("X5NC3urmGXBM0J1M").build();
    SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
    System.out.println("Message sent successfully.");
} else {
    System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
}
            
         }
}
        
         

   
               
        

    


