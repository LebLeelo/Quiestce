/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiestce;

/**
 *
 * @author leelo
 */

import java.util.ArrayList;




public class Question {

    String question;
    PersoFin listener;
    
    
    /**
     * Constructeur.
     **/
    
    public Question(String question, PersoFin listener) {
        this.question = question;
        this.listener=listener;
        
    }

    public void repondre(Perso p) {
        
        /*
         * Traitement des questions avec des attributs de qualité
        */
        // Création d'une liste avec les quatres attributs de qualité
        ArrayList<String> listeAtt = new ArrayList<>();     
        listeAtt.add("yeux");
        listeAtt.add("bouche");
        listeAtt.add("nez");
        listeAtt.add("peau");
        
        for (String att : listeAtt) {                                                                              //Yeux, Nez, Bouche, Peau
            if (this.question.contains(att))
                if(this.question.contains(p.getAtt(att))) {
                    listener.affiche("OUI");
                } else {
                    listener.affiche("NON");
                }
            
        }

        
        /*
         * Traitement des questions sur le genre
         */
        ArrayList<String> listeGenre = new ArrayList<>();  
        listeGenre.add("fille");
        listeGenre.add("garçon");
        
        for (String att : listeGenre) {  
        
            if (this.question.contains(att)){
                     if(p.getAtt("genre").equals(att)) {
                         listener.affiche("OUI");

                     } else {
                        listener.affiche("NON");
                 }

            }
        }
        
        
        /*
         * Traitement des attributs à booléens
         */
        // Création d'une liste des attributs à booléens
        ArrayList<String> listeBoo = new ArrayList<>();     
        listeBoo.add("boucles");
        listeBoo.add("lunettes");
        listeBoo.add("barbe");
        listeBoo.add("chapeau");
        
        for (String boo : listeBoo) {    
            if (this.question.contains(boo)){                                    
                if(Boolean.parseBoolean(p.getAtt(boo))){
                    listener.affiche("OUI");
                } else {
                    listener.affiche("NON");
                }
            }
        }

        
        /* 
         *Traitement des questions qui questionnent la gentillesse
         */
        if (this.question.contains("l'air gentil") ){          //Gentil                              
            if(Boolean.parseBoolean(p.getAtt("gentil"))){
                listener.affiche("OUI");
            } else {
                listener.affiche("NON");
            }
        }
        
        if (this.question.contains("l'air méchant") ){                                      
            if(Boolean.parseBoolean(p.getAtt("gentil"))){
               listener.affiche("NON");
            } else {
               listener.affiche("OUI");
            }
        }
        
        
        /* 
         *Traitement des questions sur les cheveux
         */
        if (this.question.contains("cheveux")){
            if(this.question.contains(p.getAtt("cheveux"))){
                listener.affiche("OUI");
            }
            if(this.question.contains(p.getAtt("couleurCheveux"))){
                listener.affiche("OUI");
            }
            if(!this.question.contains(p.getAtt("cheveux")) && !this.question.contains(p.getAtt("couleurCheveux")) ){
                listener.affiche("NON");
            }
        }
        
        if (this.question.contains("chauve")){
            if(p.getAtt("cheveux").equals("chauve")) {
                listener.affiche("OUI");
            } else {
                listener.affiche("NON");
            }
        }
        
        
        /* 
         * Traitement des questions sur le nom et prénom
         */
        if (this.question.contains(p.getAtt("nom"))){
            listener.affiche("OUI");   
        }
        
        if (this.question.contains(p.getAtt("prenom"))){
            listener.affiche("OUI");  
        }
        
        
        /* 
         * Traitement des questions sur l'âge
         */
        if(this.question.contains("ans")){
            String[] phrase = question.split(" ");
            for (String mot : phrase) {
                for(char c : mot.toCharArray()){
                    if(Character.isDigit(c)){
                        int age = Integer.parseInt(mot);
                        int a = Integer.parseInt(p.getAtt("age1"));
                        int b =Integer.parseInt(p.getAtt("age2"));
                        if ((a<age) && (age<b)){
                            listener.affiche("OUI");
                        } else {
                            listener.affiche("NON");
                        }
                    }
            
                }   
            } 
        }
           
}

}
        


