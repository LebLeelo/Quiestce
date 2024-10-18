/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiestce;



import java.net.URL;
import javafx.scene.image.Image;


/**
 *
 * @author leelo
 */
public class Urlimage {
    
    //Nom de l'image que l'on veut obtenir
    String adresse;
            
    
    public Urlimage(String adresse){
        
        this.adresse = adresse;
            
    }
    
    /*
     * Créer une image à partir du nom de l'image
     */
    public Image getImage(){
        URL imageUrl = this.getClass().getClassLoader().getResource(adresse);

        if (imageUrl != null) {
            return new Image(imageUrl.toExternalForm());
        } else {
            System.out.println("Image resource not found.");
            return null;
        }
        
    }
    
}