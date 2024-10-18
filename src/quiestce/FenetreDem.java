/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiestce;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.geometry.Pos;

/**
 *
 * @author leelo
 */
public class FenetreDem {
    
    Stage primaryStage;
    Button cestParti;
    
    
    /**
     * Constructeur.
     **/

    public FenetreDem(Stage primaryStage){
        
        // Image titre
        Urlimage titre = new Urlimage("QuiEstce.png");
        ImageView titreView = new ImageView(titre.getImage());
        
        titreView.setFitHeight(480);
        titreView.setFitWidth(645);
        
        // Création de région d'espace à mettre dans la VBox
        Region spacer1 = new Region();
        Region spacer2 = new Region(); 
        Region spacer3 = new Region();
        Region spacer4 = new Region();
        spacer1.setMinHeight(20); 
        spacer2.setMinHeight(200); 
        spacer3.setMinHeight(20); 
        spacer4.setMinHeight(100); 
        
        //Labels pour les règles
        Label  regles1 = new Label("Règles du jeu : ");
        regles1.getStyleClass().add("titre");
        Label  regles2 = new Label("Il vous suffit juste de trouver le personnage de votre adversaire en lui posant les questions que vous voulez");
        Label  regles3 = new Label(" mais attention il ne pourra répondre que par OUI ou par NON !");
        regles2.getStyleClass().add("regles");
        regles3.getStyleClass().add("regles");
      
        //Boutton qui appele la fenêtre de jeu
        this.cestParti = new Button("C'est parti ! ");
        cestParti.getStyleClass().add("newPartie");
        
            cestParti.setOnMouseEntered(e ->  
                cestParti.setStyle(cestParti.getStyle()+"-fx-background-color: #ff0000;"));

            cestParti.setOnMouseExited(e -> 
                cestParti.setStyle(cestParti.getStyle()+"-fx-background-color: #b22222;"));

            cestParti.setOnMousePressed(e -> {
                cestParti.setStyle(cestParti.getStyle()+"-fx-background-color: #8b0000;");
                System.out.println("change");
                FenetreJeu fenetre = new FenetreJeu(primaryStage);  
            });
                    
            cestParti.setOnMouseReleased(e -> 
                cestParti.setStyle(cestParti.getStyle()+"-fx-background-color: #ff0000;"));
        
        // organisation verticale générale
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: white;");
        vb.getChildren().addAll(titreView,spacer1,regles1, spacer3,regles2, regles3,spacer4,cestParti, spacer2);
        
        //Création de la scène 
        Scene scene = new Scene(vb, 1712, 1000);
        scene.getStylesheets().add("quiestce/StyleSheet.css");
        
        //Création du stage
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Qui est-ce ?");
        primaryStage.setScene(scene);
        
        //démarrage et affichage de la fenêtre
        primaryStage.show();
        
    }
    
    
}
