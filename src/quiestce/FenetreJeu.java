/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiestce;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;



/**
 *
 * @author leelo
 */

public class FenetreJeu implements PersoFin{
    
    Stage primaryStage;
    HBox espaceReponse;
    //Grille de disposition des personnages
    GridPane gp;
    //Liste des personnages
    ArrayList<Perso> perso;
    //Personnage à deviner
    Perso choisi;
    //Nombre de cartes retournées
    int cartesRetournees;
    //Zone de traitement de texte
    TextField  tNom;
    
    
    /**
     * Constructeur.
     **/
    
    public FenetreJeu(Stage primaryStage) {   
        
        //Liste des personnages
        perso=creerLaListe();
        
        //Grille de disposition des personnages
        this.gp = creerLaGrille();
        
        //Initialisation du nombre de cartes retournées
        cartesRetournees=0;
        
        //Choix aléatoire du personnage à retourner
        Random random=new Random();
        this.choisi=perso.get(random.nextInt(perso.size()));
        
        //Image titre
        Urlimage titre = new Urlimage("QuiEstce.png");
        ImageView titreView = new ImageView(titre.getImage());
        titreView.setFitHeight(270);
        
        //Zone de traitement de texte 
        //Appele la classe Question pour traiter le texte
        tNom = new TextField();
        tNom.getStyleClass().add("tNom");
        tNom.setPrefWidth(700);
        
        tNom.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Question question = new Question(tNom.getText(),this);
                System.out.println("entré");    
                question.repondre(choisi); 
            }
        }); 
        
        //Label question
        Label question = new Label("Posez votre question : ");
        question.getStyleClass().add("question");
        
        // Création de région d'espace à mettre dans la HBox
        Region spacer1 = new Region();
        Region spacer2 = new Region();
        spacer1.setMinWidth(200);
        spacer2.setMinWidth(40); 
        
        //Espace sous forme de HBox où la réponse OUI/NON s'affiche
        espaceReponse = new HBox();
        espaceReponse.setAlignment(Pos.CENTER);
        Region spacer = new Region();
        spacer.setMinHeight(20); 
        espaceReponse.getChildren().addAll(spacer);
        
        //Organisation horizontale qui rassemble la zone de texte et le label "posez une question"
        HBox petitehb = new HBox();
        petitehb.setAlignment(Pos.CENTER);
        petitehb.getChildren().addAll(question, spacer2,tNom);
        
        //Organisation verticale qui rassemble la zone de question (petitehb) et la zone de réponse
        VBox petitevb = new VBox();
        petitevb.setAlignment(Pos.CENTER);
        petitevb.getChildren().addAll(petitehb, espaceReponse);
        petitevb.setSpacing(40);
        
        //Organisation horizontale pour le haut de la fenêtre
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(titreView,spacer1,petitevb);
        
        //Organisation verticale générale
        VBox vb = new VBox();
        vb.getChildren().addAll(hb,spacer,gp);
        vb.setStyle("-fx-background-color: white;");
        
        //Création de la scène 
        Scene sceneJeu = new Scene(vb);
        sceneJeu.getStylesheets().add("quiestce/StyleSheet.css");
        
        //Création du stage
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Qui est-ce ?");
        primaryStage.setScene(sceneJeu);
        
        //démarrage et affichage de la fenêtre
        primaryStage.show();
    }
    
    
    /*
     *Créer une liste de 24 personnages
     */
    
    public ArrayList<Perso> creerLaListe(){
        
        ArrayList<Perso> p= new ArrayList();
            p.add(new Perso("Aufourneau", "Arnaud", "courts", "blonds", "bleus", false, true, 15, 25, true, false, "petite", "normal", false, "garçon", "blanche","1.png",this));
            p.add(new Perso("Biker", "Stephane", "courts", "bleus", "bleus", true, false, 35, 45, false, true, "normale", "normal", true, "garçon", "blanche","2.png",this));
            p.add(new Perso("Aufruits", "Charlotte", "longs", "roses", "roses", false, false, 7, 15, true, false, "petite", "petit", true, "fille", "blanche","3.png",this));
            p.add(new Perso("Turlu", "Hector", "chauve", "chauve", "rouges", false, false, 0, 999999999, false, false, "petite", "retroussé", false, "garçon", "bleue","4.png",this));
            p.add(new Perso( "Garçon-vache", "John", "longs", "bruns", "verts", false, true, 25, 40, false, true, "normale", "normal", false, "garçon", "verte","5.png",this));
            p.add(new Perso( "Intello", "Elodie", "longs", "bruns", "marrons", true, false, 10, 20, false, false, "petite", "petit", false, "fille", "blanche","6.png",this));
            p.add(new Perso("Classe", "Titi", "longs", "bruns", "marrons", false, false, 5, 10, true, false, "petite", "petit", false, "garçon", "noire","7.png",this));
            p.add(new Perso( "Chambord", "Natalie", "longs", "bruns", "marrons", false, false, 20, 30, false, false, "petite", "normal", true, "fille", "mate","8.png",this));
            p.add(new Perso( "Legard", "Berenice", "bouclés", "bruns", "marrons", true, false, 7, 14, true, false, "normale", "gros", false, "fille", "noire","9.png",this));
            p.add(new Perso( "Longlois", "Yvette", "courts", "blancs", "marrons", true, false, 70, 90, false, false, "normale", "normal", true, "fille", "blanche","10.png",this));
            p.add(new Perso( "Courtin", "Charline", "longs", "blancs", "verts", false, false, 17, 27, true, false, "normale", "normal", false, "fille", "blanche","11.png",this));
            p.add(new Perso( "Bicoque", "Bernadette", "courts", "blancs", "marrons", false, false, 80, 105, true, false, "normale", "normal", false, "fille", "mate","12.png",this));
            p.add(new Perso( "Colonel", "Moutarde", "courts", "blancs", "verts", false, true, 40, 60, false, true, "normale", "gros", false, "garçon", "blanche","13.png",this));
            p.add(new Perso( "Dupuis", "Emilie", "longs", "bleus", "marrons", false, true, 7, 15, true, false, "normale", "normal", false, "fille", "blanche","14.png",this));
            p.add(new Perso( "Massias", "Rodrigue", "longs", "rouges", "rouges", false, false, 20, 35, false, true, "normale", "normal", true, "garçon", "mate","15.jpeg",this));
            p.add(new Perso( "Poncho", "Octave", "longs", "violets", "marrons", false, false, 10, 20, false, false, "normale", "normal", false, "garçon", "blanche","16.jpeg",this));
            p.add(new Perso( "Zen", "Zulie", "longs", "blancs", "marrons", false, true, 90, 120, false, false, "normale", "normal", true, "fille", "blanche","17.jpeg",this));
            p.add(new Perso( "Extra", "Olivia", "chauve", "chauve", "verts", false, true, 20, 35, false, false, "normale", "normal", false, "fille", "blanche","18.jpeg",this));
            p.add(new Perso( "Sage", "Samia", "longs", "bruns", "marrons", false, true, 25, 35, true, false, "normale", "normal", true, "fille", "noire","19.png",this));
            p.add(new Perso( "Grangier", "Hedwige", "longs", "chatains", "marrons", false, false, 12, 18, true, false, "grande", "normal", false, "fille", "blanche","20.png",this));
            p.add(new Perso( "Laclasse", "Elena", "longs", "noirs", "bleus", false, false, 20, 35, true, false, "normale", "normal", false, "fille", "blanche","21.png",this));
            p.add(new Perso( "Lecron", "Manuel", "longs", "blonds","bleus", false, false, 27, 40, false, false, "normale", "normal", false, "garçon", "blanche","22.png",this));
            p.add(new Perso( "Gosse", "Beau", "courts", "chatains", "bleus", false, false, 20, 30, true, false, "normale", "normal", true, "garçon", "blanche","23.png",this));
            p.add(new Perso("Violette", "Tulipe", "longs", "violets", "violets", false, false, 25, 35, false, false, "normale", "gros", true, "fille", "blanche","24.jpeg",this));

        return p;
    }
 
    
    /*
     *Créer la grille qui affcihe chacun des personnage et leur nom, prénom
     */
    
    public GridPane creerLaGrille(){
        
        GridPane g =new GridPane();
        g.setAlignment(Pos.CENTER);
        
        int i = 0;
        int j = 0;

        for (Perso p : perso) {
            g.add(p.getBoxPerso(), j, i);
            g.setMargin(p.getBoxPerso(), new Insets(7, 7, 7, 7));
            
            // Incrémente le numéro de la colone et la ligne si on arrive à la fin de la ligne
            j = (j + 1) % 8;
            if (j == 0) {
                i++;
            }
        }
        return g;
    }
    
    
    /*
     * Retourne le nombre de cartes retournées
     */
    public int getNombreRetourne(){
        return cartesRetournees;
    }
    
    
    /*
     * Supprime un personnage de la liste des personnages et implémente le nombre de cartes retournées
     */
    public void supprime(String adresse){
        boucleExterieure:
        for(Perso p:perso){
            if(p.getAdresse()==adresse){
                perso.remove(p);
                break boucleExterieure;
            }
        }
        cartesRetournees++;
    }
    
    
    /*
     * Affiche un message dans la zone de réponse
     */
    public void affiche(String label){
        
        Label reponse = new Label(label);
        reponse.getStyleClass().add("reponse");

        espaceReponse.getChildren().setAll(reponse);
        
        //Le message se retire si on clique dessus
        espaceReponse.setOnMouseClicked(event -> {
                Region spacer = new Region();
                spacer.setMinHeight(20); 
                espaceReponse.getChildren().setAll(spacer);
                tNom.clear();
        });
    }

    
    /*
     * Affiche une fenêtre de fin de jeu
     */
    
    public void thisIsTheEnd(){
        
        //On s'assure que toutes les cartes sauf une ont été retournées
        if(cartesRetournees==23){     
            
            //Cas ou le joueur a gagné
            if(choisi.getAdresse() == perso.get(0).getAdresse()){
                primaryStage.setScene(gagne());
                primaryStage.show();
            
            //Cas ou le joueur a perdu
            }else{
                primaryStage.setScene(perdu());
                primaryStage.show();
                
            }
        }
    }
    
    
    /*
     * Crée un bouton qui lance une nouvelle fenêtre jeu
    */
    public Button bouton(){
        
        Button newPartie = new Button("Une autre partie ? ");
        newPartie.getStyleClass().add("newPartie");
                    
        newPartie.setOnMouseEntered(e ->  
            newPartie.setStyle(newPartie.getStyle()+"-fx-background-color: #ff0000;"));

        newPartie.setOnMouseExited(e -> 
            newPartie.setStyle(newPartie.getStyle()+"-fx-background-color: #b22222;"));

        newPartie.setOnMousePressed(e -> {
            newPartie.setStyle(newPartie.getStyle()+"-fx-background-color: #8b0000;");
            FenetreJeu fenetre = new FenetreJeu(primaryStage);
        });
                    
        newPartie.setOnMouseReleased(e -> 
            newPartie.setStyle(newPartie.getStyle()+"-fx-background-color: #ff0000;"));
        
        return newPartie;
    }
    
    
    /*
     *Crée la scène qui sera montrée si le joueur a gagné
     */
    
    public Scene gagne(){
        
        //Label titre
        Label cestGagne = new Label("C'est gagné ! ");
        cestGagne.getStyleClass().add("titre");
        
        //Boutton qui ouvre une nouvelle fenêtre de jeu
        Button newPartie = bouton();
                    
        //Image du personnage à deviner
        Urlimage gagne = new Urlimage(perso.get(0).getAdresse());
        ImageView youwon = new ImageView(gagne.getImage());
        
        youwon.setFitWidth(512);
        youwon.setFitHeight(512);
        
        //Organisation verticale générale
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.getChildren().addAll(youwon,cestGagne,newPartie);
        vbox.setSpacing(50);
                 
        //Création de la scène
        Scene newScene = new Scene(vbox,1712, 1000);//, 1712, 1000);
        newScene.getStylesheets().add("quiestce/StyleSheet.css");
                    
        return newScene;  
        
    }


    /*
     *Crée la scène qui sera montrée si le joueur a perdu
     */
    
    public Scene perdu(){
    
        //Gif à afficher au milieu de la scène
        Urlimage over = new Urlimage("giphy.gif");
        ImageView gameOver = new ImageView(over.getImage());
        
        gameOver.setFitWidth(960);
        gameOver.setFitHeight(540);
                
        //Bouton qui ouvre une nouvelle fenêtre de jeu
        Button newPartie = bouton();
                
        //Organisation verticale générale
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(gameOver,newPartie);
        box.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
           
        //Création de la scène
        Scene newScene = new Scene(box,1712, 1000);//, 1712, 1000);
        newScene.getStylesheets().add("quiestce/StyleSheet.css");
                
        return newScene;
    }
    
}
    
    