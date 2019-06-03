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
                joueur = message.joueur;
                tuile = message.tuile;
                joueur.removePA(1);
                application.deplacement(joueur,tuile);
                vueIle.actualiser();                break;
                
            case ASSECHER: //Clic pour assécher
                joueur = message.joueur;
                tuile = message.tuile;
                joueur.removePA(1);
                joueur.getRoleJoueur().assecher(tuile);//La tuile selectionnée est assechée
                vueIle.actualiser();
                break;
            case DONNER:    //Clic pour donner une carte
                
                break;
            case TERMINER_TOUR: //Clic pour finir son tour
                joueur = message.joueur;
                joueur.initPointAction(); //Réinitialise les points d'action du joueur
                application.innonder(application.getNiveaudeau().getNiveauinondation()); //Innonde un nombre de case en fonction du niveau d'eau
                vueIle.actualiser();
                break;
                
                
            
        }
    }
}   