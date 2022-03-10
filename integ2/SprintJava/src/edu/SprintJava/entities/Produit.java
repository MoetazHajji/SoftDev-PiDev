/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariem
 */
public class Produit {
     private static int id_courant ;
     private static int iddd;
     private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static int getIddd() {
        return iddd;
    }

    public static void setIddd(int iddd) {
        Produit.iddd = iddd;
    }
     
public static final String REGEX = "[a-zA-Z]";
public static final String REGEXnumber = "[1-9]";
    public static int getId_courant() {
        return id_courant;
    }

    public static void setId_courant(int id_courant) {
        Produit.id_courant = id_courant;
    }
     public  int id_produit;
  
    String nom_produit;
    String type;
    String image;
    int stock;
    float prix;
    int qantitee;

    public int getQantitee() {
        return qantitee;
    }

    public void setQantitee(int qantitee) {
        this.qantitee = qantitee;
    }
   static int quantite;
     static int idpr;
     static int idd;

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Produit.idd = idd;
    }
     
     
     int qttt;

    public int getQttt() {
        return qttt;
    }

    public void setQttt(int qttt) {
        this.qttt = qttt;
    }
     

    public static int getIdpr() {
        return idpr;
    }

    public static void setIdpr(int idpr) {
        Produit.idpr = idpr;
    }

    static float prixx;
     static int stockk;
     static String nomm;
static float total;

    public static float getTotal() {
        return total;
    }

    public static void setTotal(float total) {
        Produit.total = total;
    }
    public static float getPrixx() {
        return prixx;
    }

    public static void setPrixx(float prixx) {
        Produit.prixx = prixx;
    }

    public static int getStockk() {
        return stockk;
    }

    public static void setStockk(int stockk) {
        Produit.stockk = stockk;
    }

    public static String getNomm() {
        return nomm;
    }

    public static void setNomm(String nomm) {
        Produit.nomm = nomm;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
    

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*@Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", type=" + type + ", image=" + image + ", prix=" + prix + '}';
    }*/

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", type=" + type + ", image=" + image + ", stock=" + stock + ", prix=" + prix + '}';
    }

   
    

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public float getPrix() {
        return prix;
    }

    public static void setQuantite(int quantite) {
        Produit.quantite = quantite;
    }

   

    public Produit() {
    }

    public Produit(String nom_produit, String type, String image, float prix) {
        this.nom_produit = nom_produit;
        this.type = type;
        this.image = image;
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Produit(String nom_produit, String type, String image, int stock, float prix) {
        this.nom_produit = nom_produit;
        this.type = type;
        this.image = image;
        this.stock = stock;
        this.prix = prix;
    }
    public int getid(int id)
    {
        this.id_produit=id;
        return id;
    
    }
    public static ObservableList<Produit> getPanier() {
        return Panier;
    }

    public static void setPanier(ObservableList<Produit> Panier) {
        Produit.Panier = Panier;
    }
    public static ObservableList<Produit> Panier = FXCollections.observableArrayList();  
    
     public static class getPanier {

        public getPanier() {
        }
    }
     

 /*    public static boolean setPanier(Produit P) {
      /*  Boolean Test=true;
        
    	for (int i = 0; i < Panier.size(); i++) {
        if(Panier.get(i).getId_produit()==P.getId_produit())
        {
                        Test=false;
                        Panier.get(i).setQuantite(Panier.get(i).getQuantite()+1);
                        P.setQuantite(P.getQuantite()+1);
                      //  System.out.println( Panier.get(i));
                     
        }
		}
       if(Test==true)
            {
             P.setQuantite(P.getQuantite()+1);
           Panier.add(P);
           
            }
    
    }*/
      List<Produit>panierr= new ArrayList();
    
    
    public static ObservableList<Produit> ajouter_dans_un_panier(int id)
    {
        
        
        String requete="SELECT id_produit,nom,prix from produit where id_produit='"+id+"'";
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                Produit per = new Produit();
                per.setId_produit(re.getInt("id_produit"));
                
                per.setNom_produit(re.getString("nom"));
               per.setPrix(re.getFloat("prix"));
                              
                 
                
               
                
         
                 Panier.add(per);
                  
                
              
               
             
             }
           
        } catch (SQLException ex) {
            ex.getMessage();
        }
       
       return Panier; 
    
    }

    public static int getQuantite() {
        return quantite;
    }
    public void afficherpanierr()
    {
         System.out.println(panierr);
    
    }
    public float calcule_totale()
    {
        float totale=0.0f ;
        
        for(int i=0 ;i<panierr.size();i++)
        {
            totale = totale+panierr.get(i).getPrix();
        
        }
    
         return totale;
    }
    public float totale()
   {
     
       float qt=0;
        
        for(int i=0;i<Panier.size();i++)
       {
           String requete="SELECT SUM(prix) AS totale from produit where id_produit='"+Panier.get(i).getId_produit()+"'" ;
       
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
               
                qt=re.getFloat("totale");
                 
                
              
               
             
             }
            
             
           
        } catch (SQLException ex) {
           ex.getMessage();
        }
        
       
    
       } 
        
        return qt;
        
        
        
        
        
        
    
    
  
    }
     public int recupererstock(int id)
    {
        int stockk=0;
    
    String requete="SELECT stock from produit where id_produit='"+id+"'";
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                
                
         
                  stockk=re.getInt("stock");
                 
                
              
               
             
             }
           
        } catch (SQLException ex) {
           ex.getMessage();
        }
       
       return stockk; 
    
    
    
    }
    
     public void decrementerstock(int id,int qt)
    {
        int nouveaustock=0;
        int s= recupererstock(id);
         nouveaustock=s-qt;
        
        String requete= "update produit  set stock = '"+nouveaustock+"'  where id_produit = '"+id+"' ; "  ;    
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                
                 
                  
                 // pst.setInt(5,nouveaustock);
                  pst.executeUpdate(requete);
            
                  
                 
             } catch (SQLException ex) {
                 ex.getMessage();
             }
    
    
    
    }
     public void unicite(int id)
     {
        for(int i=0;i<Panier.size();i++)
        {
           if(Panier.get(i).getid(id)!=id)
           
            ajouter_dans_un_panier(id);
           
           

                
        
        }
       
        
     
     
     }
     
  
            
   
  
            
}

