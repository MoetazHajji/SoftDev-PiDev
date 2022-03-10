/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Produit;
import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariem
 */
public class ProduitCRUD {
    List<Produit> listeproduit =new ArrayList();
         public int ajouterproduit(Produit p)
    {
             String requete="INSERT INTO produit(nom,type,image,prix,stock,rating)VALUES(?,?,?,?,?,?)";
       
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                 pst.setString(1, p.getNom_produit());
                  pst.setString(2, p.getType());
                  pst.setString(3, p.getImage());
                  pst.setFloat(4, p.getPrix());
                  pst.setInt(5, p.getStock());
                   pst.setInt(6, 0);
                  
                  pst.executeUpdate();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
             }
             return p.getStock();
            
           
       
       
    }
                public void modifier(int id,String nom, float prix, int stock)
    {
                 Produit p = new Produit(); 
             String requete= "update produit  set nom = ?,  prix = ?, stock = ? where id_produit = '"+id+"' ; "  ;    
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                   //pst.setInt(1,id);
                  pst.setString(1, nom);
                  
                  
                  pst.setFloat(2, prix);
                  pst.setInt(3,stock);
                  pst.executeUpdate();
            
                  
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        
       
    }
         
          public List<Produit> afficher(){
     String requete="SELECT * from produit";
            List<Produit>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                Produit per = new Produit();
                per.setId_produit(re.getInt("id_produit"));
                
                 per.setNom_produit(re.getString("nom"));
                 per.setType(re.getString("type"));
                per.setImage(re.getString("image"));
                
                 per.setPrix(re.getFloat("prix"));
                  per.setStock(re.getInt("stock"));
               myList.add(per);
               
             
             }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
     return myList;
     
     }
        public boolean supprimer(Produit p)
          {
          
                String requete = "DELETE from produit where id_produit=?";
       
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                  pst.setInt(1, p.getId_produit());
                 pst.executeUpdate();
                 System.out.println("produit supp");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
             }
              
             
                return true;
            
       
        
      
       
            
          
          }
        
        
        
        
        
         public List<Produit> recuperer_produit(int id)
    {
        
        
        String requete="SELECT * from produit where id_produit='"+id+"'";
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                Produit per = new Produit();
                per.setId_produit(re.getInt("id_produit"));
                
                per.setNom_produit(re.getString("nom"));
                 
                 per.setPrix(re.getFloat("prix"));
                 listeproduit.add(per);
                
              
               
             
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
       
       return listeproduit; 
    
    }
        public String getimage(int id)
         {
             String a="";
             for(int i=0;i<recuperer_produit(id).size();i++)
             {
                  a= recuperer_produit(id).get(i).getImage();
             
             }
             return a;
         
         
         }
        public boolean getnom(String nom)
         {
             List<Produit>l1=new ArrayList();
             l1=afficher();
             String a="";
             for(int i=0; i<l1.size();i++)
             {
                  if(l1.get(i).getNom_produit().equals(nom))
                      return true;
             
             }
             return false;
         
         
         }
         
         
         
         
         
         
         public List<Produit> afficherproduitdetypevetement(){
     String requete="SELECT * from produit where type = 'vetement' ";
            List<Produit>myList = new ArrayList();
    
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                Produit per = new Produit();
                per.setId_produit(re.getInt("id_produit"));
                
                per.setNom_produit(re.getString("nom"));
                 per.setType(re.getString("type"));
        //         per.setImage(re.getString("image"));
                 per.setPrix(re.getFloat("prix"));
               myList.add(per);
               
             
             }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
     return myList;
     
     }
       /*  public List<Produit> rechercher_produit(int id)
         {
             
             listeproduit=recuperer_produit();
           
         return listeproduit.stream().filter(t ->t.getId_produit()== id).collect(Collectors.toList());
         
         
            
         
         }*/
         public void calculetotalestock()
         {
             
         
             
          
              String requete="SELECT sum(stock) as totale from produit ";
        try {
             
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet re=  st.executeQuery(requete);
             while(re.next())
             {
            
                 System.out.println(re.getFloat("totale "));
                
              
               
             
             }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
    
         
         
         }
         

       public List<Produit> RechercheProduitParNom(String recherche) {

        List ALLproducts = new ArrayList();
        try {
            String requete = "select * from produit WHERE nom LIKE '%" + recherche + "%' AND stock > 0 OR stock=null;";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rest=  st.executeQuery(requete);
            while (rest.next()) {
                Produit pr = new Produit();
      
                pr.setId_produit(rest.getInt("id_produit"));
                pr.setNom_produit(rest.getString("nom"));
               
                pr.setStock(rest.getInt("stock"));
                pr.setImage(rest.getString("image"));
                 pr.setPrix(rest.getInt("prix"));
              
                ALLproducts.add(pr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ALLproducts;

    }
       public int AfficherRating(int id) throws SQLException
    {  int rate = 0;
//             Statement st = MyConnection.getInstance().getCnx().createStatement();
//            
//           
//
//          //  ResultSet rs = st.executeQuery("select avg(rating) from rating where idproduit='"+id+"'");
//   
//        while (rs.next()) {
//            rate= rs.getInt(1);
//            
//        }
            return rate;
   }
           public void AjouterRating(int r, int id)
    {
            
      
              Produit p = new Produit(); 
             String requete= "update produit  set rating = ? where id_produit = '"+id+"' ; "  ;    
             try {
                 PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
                   //pst.setInt(1,id);
              
                  
                  
                
                  pst.setInt(1,r);
                  pst.executeUpdate();
            
                  
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ProduitCRUD.class.getName()).log(Level.SEVERE, null, ex);
             }
            
           
       
            
       
    }
       
  
    
}

