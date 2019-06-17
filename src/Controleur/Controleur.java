package Controleur;

import Vue.VueIle;
import ile_interdite.Application;
import ile_interdite.Joueur;
import ile_interdite.Tuile;
import ile_interdite.CarteTresor;

public class Controleur implements Observateur {
    private VueIle vueIle;
    private Application application;
    
    public Controleur() {
        application = new Application();
        application.initMap();
        application.initCartes();
        application.initJoueurs(6);
        vueIle = new VueIle(application);
        
        vueIle.addObservateur(this);  
    }  
    @Override
    public void traiterMessage(Message message) {
        Joueur joueur;
        Tuile tuile;
        CarteTresor carte;
        int no_joueur = 0, suivant;

        switch(message.type) {
            case DEMARRER_PARTIE: //Action pour démarrer la partie
                
                break;
            
            case DEPLACER:  //Clic sur deplacer
                joueur = message.joueur;
                tuile = message.tuile;
               /* if(joueur.getRoleJoueur().getType() == ile_interdite.TypeAventurier.plongeur){
                    switch(tuile.getEtat()){
                        case innondée : 
                                if(message.type != message.type.DEPLACER){
                                    joueur.removePA(1);
                                }
                            joueur.removePA(0);
                             
                            break;
                            
                        case sombrée :
                            joueur.removePA(0);
                            break;
                            
                        case normale :
                            joueur.removePA(1);
                            break;
                    }*/
                //}else{
                    joueur.removePA(1);
                //}
                
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
                joueur=message.joueur;
                Joueur joueur2=message.receveur;
                int index=-1;
                for(int i=0;i<joueur.getCartesT().size();i++){
                    if(joueur.getCartesT().get(i)== message.carte){
                        joueur.removePA(1);
                        index=i;
                        break;
                    }
                }
                joueur2.getCartesT().add(joueur.getCartesT().get(index));
                joueur.getCartesT().remove(index);

                vueIle.actualiser();
                break;
            case DEFAUSSER:  //Clic pour défausser une carte
                joueur = message.joueur;
                carte = message.carte;
                
                for (int i = joueur.getCartesT().size(); i>5; i--) {
                    application.defausserCarteTresor(carte);
                    joueur.removeCarte(carte);
                }
                
                vueIle.actualiser();
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