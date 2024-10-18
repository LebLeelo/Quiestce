/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiestce;

//on ne peut cliquer qu'une suele fois sur une carte
//il faut prendre l'adresse d'une carte qu'on ne retourne pas


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;



/**
 *
 * @author leelo
 */

public class Perso {
    
    Boolean retournee;
    VBox boxPerso;
    //Ajout d'une interface
    PersoFin listener;
    
    //Liste des attributs
    String adresse;
    String nom;
    String prenom;
    String couleurYeux;
    String cheveux;
    String couleurCheveux;
    boolean lunettes;
    boolean chapeau;
    int age1;
    int age2;
    boolean barbe;
    String bouche;
    String nez;
    boolean boucles;
    boolean gentil;
    String genre;
    String couleurPeau;
    
    
    /**
     * Constructeur.
     **/
    
    public Perso(String nom, String prenom, String cheveux, String couleurCheveux, String couleurYeux, boolean lunettes, boolean chapeau, int age1, int age2, boolean gentil, boolean barbe, String bouche, String nez, boolean boucles, String genre, String couleurPeau, String adresse, PersoFin listener){
        this.adresse=adresse;
        this.nom=nom;
        this.prenom=prenom;
        this.retournee=false;
        this.couleurYeux = couleurYeux;
        this.cheveux = cheveux;
        this.couleurCheveux = couleurCheveux;
        this.lunettes = lunettes;
        this.chapeau =  chapeau;
        this.age1 = age1;
        this.age2 = age2;
        this.barbe = barbe;
        this.bouche = bouche;
        this.nez = nez;
        this.boucles = boucles;
        this.gentil=gentil;
        this.genre=genre;
        this.couleurPeau=couleurPeau;
        this.listener=listener;
                    
        
        this.boxPerso = boxPersonnage();
        
    }
    
    
    /*
     * Crée une organisation verticale qui rassemble l'image et le nom du personnage
     */
    
    public VBox boxPersonnage(){
        
        //Image du personnage
        
        Urlimage image = new Urlimage(adresse);
        ImageView imageView = new ImageView(image.getImage());
        
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        //Label du nom et prénom du personnage
        Label nomPrenom = new Label(nom + " " + prenom);
        
        //Orgnisation verticale qui rassemble l'image et le nom
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(imageView, nomPrenom);
        box.setSpacing(5);
        //Si on clique sur la vbox, une nouvelle image s'affiche
        box.addEventHandler(MouseEvent.MOUSE_PRESSED,
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                changer(m);
            }
        });
        
        return box;
    }

    
    /*
     * Change l'image dans la boxPerso car la carte est retournée
     * Indique qu'une carte est retournée à FenetreJeu
     */
       
    public void changer(MouseEvent m) {
        
        //On s'assure que la carte n'a pas déjà été retournée
        if (! retournee){
               
            //Image qui s'affichera
            Urlimage nouv = new Urlimage("qpoint.png");
            ImageView updatedImageView = new ImageView(nouv.getImage());
            
            updatedImageView.setFitWidth(200);
            updatedImageView.setFitHeight(200);
            
            //On efface le nomPrenom en affichant un label vide
            Label newNomPrenom = new Label("");

            //Actualise la boxPerso
            boxPerso.getChildren().setAll(updatedImageView,newNomPrenom);
            
            //Modifie le booléen qui indique que la carte est retounée
            retournee=true;
            
            //Par l'intermédiaire de l'interface, on indique à FenetreJeu que la carte est retounée
            //Supprime le personnage de la liste de personnages et implémente le nombre de cartes retournées
            listener.supprime(adresse);
            //Appele la fin du jeu
            listener.thisIsTheEnd();
            
        }       
    }
    
    
    /*
     * Retourne la box du personnage (image et nomPrenom)
     */
    public VBox getBoxPerso() {
        return boxPerso;
    }
    
    
    /*
     * Retourne l'adresse du personnage
     */
    public String getAdresse(){
        return adresse;
    }
    
    
    /*
     * Indique si la carte est retournée ou non
     */
    public boolean getRetournee(){
        return retournee;
    }
    
    
    /*
     * Retourne le qualificatif lié à l'attribut pour le personnage
     */
    
    public String getAtt(String att){
        
        String a =null;
        
        if(att=="prenom"){
            a=prenom;
        }
        
        if(att=="nom"){
            a=nom;
        }
        
        if(att=="cheveux"){
            a=cheveux;
        }
        
        if(att=="couleurCheveux"){
            a=couleurCheveux;
        }
        
        if(att=="yeux"){
            a=couleurYeux;
        }
        
        if(att=="lunettes"){
            a=String.valueOf(lunettes);
        }
        
        if(att=="chapeau"){
            a=String.valueOf(chapeau);
            
        }
        
        if(att=="age1"){
            a=String.valueOf(age1);
        }
        
        if(att=="age2"){
            a=String.valueOf(age2);
        }
        
        if(att=="gentil"){
            a=String.valueOf(gentil);
        }
        
        if(att=="barbe"){
            a=String.valueOf(barbe);
        }
        
        if(att=="bouche"){
            a=bouche;
        }
        
        if(att=="nez"){
            a=nez;
        }
        
        if(att=="boucles"){
            a=String.valueOf(boucles);
        }
        
        if(att=="genre"){
            a=genre;
        }
        
        if(att=="peau"){
            a=couleurPeau;
        }
        
        if(att=="adresse"){
            a=adresse;
        }
        
        return a;
    }  
    
}
    
