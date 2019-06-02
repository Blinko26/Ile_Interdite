package Controleur;

import ile_interdite.Application;
import ile_interdite.Joueur;
import ile_interdite.Tuile;

public class Controleur implements Observateur {
    private VueIle vueIle;
    private Application application;
    
    public Controleur() {
        application = new Application();
        application.initMap();
        application.initJoueurs(6);
        application.initCartes();
        vueIle = new VueIle(application);
        
        vueIle.addObservateur(this);  
    }  
    @Override
    public void traiterMessage(Message message) {
        Joueur joueur;
        Tuile tuile;
        int no_joueur = 0, suivant;

        switch(message.type) {
            case DEMARRER_PARTIE: //Action pour démarrer la partie
                
                break;
            
            case DEPLACER:  //Clic sur deplacer
                System.out.println("Controleur");
                joueur = message.joueur;
                tuile = message.tuile;
                joueur.removePA(1);
                application.deplacement(joueur,tuile);
                vueIle.actualiser();
                System.out.println("2"+joueur.getRoleJoueur().getPosition().getNom());//Donne le nom de la position du joueur
                break;
                
            case ASSECHER: //Clic pour assécher
                
                break;
            case DONNER:    //Clic pour donner une carte
                
                break;
            case TERMINER_TOUR: //Clic pour finir son tour
                joueur = message.joueur;
                joueur.initPointAction(); //Réinitialise les points d'action du joueur
                vueIle.actualiser();
                break;
                
                
            
        }
    }
}   