package Controleur;

import Vue.VueDefaite;
import ile_interdite.Application;
import ile_interdite.EtatT;
import ile_interdite.Joueur;
import ile_interdite.Tresor;
import ile_interdite.Tuile;
import ile_interdite.TypeT;
import ile_interdite.CarteTresor;
import java.io.IOException;
import Vue.VueIle;
import Vue.VueNiveauDo;
import Vue.VuedébutV3;
import ile_interdite.TypeAventurier;
import ile_interdite.TypeCT;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controleur implements Observateur {
    private VueIle vueIle;
    private VuedébutV3 vueDebut;
    private VueNiveauDo vueNiveauDo;
    private VueDefaite vueDef;
    private Application application;
    
    public Controleur() {
        vueDebut = new VuedébutV3();
        vueDebut.addObservateur(this);
    }  
    @Override
    public void traiterMessage(Message message) {
        Joueur joueur;
        Tuile tuile;
        CarteTresor carte;
        int no_joueur = 0, suivant;

        switch(message.type) {
            case DEMARRER_PARTIE:
                application = new Application();
                application.initMap();
                application.initCartes();
                application.initJoueurs(6);
                vueIle = new VueIle(application);
                vueIle.addObservateur(this);
                vueIle.start();
                break;
            case REJOUER:
                new Controleur(); 
                System.out.println("REJOUEr");
                break;
          
            case DEPLACER:  //Clic sur deplacer
                joueur = message.joueur;
                tuile = message.tuile;
                if(joueur.getRoleJoueur().getType() == TypeAventurier.ingénieur && joueur.getRoleJoueur().getAAsseche() == true) {
                    joueur.removePA(2);
                }
                
                //else if(joueur.getRoleJoueur().getType() == ile_interdite.TypeAventurier.plongeur){
                //    switch(tuile.getEtat()){
                //        case innondée : 
                //            joueur.removePA(0);
                //            break;
                //            
                //        case sombrée :
                //            joueur.removePA(0);
                //            break;
                //            
                //        case normale :
                //            joueur.removePA(1);
                //            break;
                //    }
                //}
                else{
                    joueur.removePA(1);
                }
                
                application.deplacement(joueur,tuile);
                vueIle.actualiser();                
                break;
                
            case ASSECHER: //Clic pour assécher
                joueur = message.joueur;
                tuile = message.tuile;
                boolean assecher = message.aasseche;
                if(joueur.getRoleJoueur().getType() == TypeAventurier.ingénieur && !assecher) {
                    joueur.removePA(0);
                }
                else if(joueur.getRoleJoueur().getType() != TypeAventurier.ingénieur || assecher){
                    joueur.removePA(1);
                }
                joueur.getRoleJoueur().assecher(tuile);//La tuile selectionnée est assechée
                vueIle.actualiser();
                break;            
            case DONNER:    //Clic pour donner une carte
                joueur=message.joueur;
                Joueur joueur2=message.receveur;
                int index = 0;
                if(joueur.getRoleJoueur().getType() == TypeAventurier.ingénieur && joueur.getRoleJoueur().getAAsseche() == true) {
                    index=-1;
                for(int i=0;i<joueur.getCartesT().size();i++){
                    if(joueur.getCartesT().get(i)== message.carte){
                        joueur.removePA(2);
                        index=i;
                        break;
                    }
                }
                }
                else {
                    index=-1;
                for(int i=0;i<joueur.getCartesT().size();i++){
                    if(joueur.getCartesT().get(i)== message.carte){
                        joueur.removePA(1);
                        index=i;
                        break;
                    }
                }
                }
                joueur2.getCartesT().add(joueur.getCartesT().get(index));
                joueur.getCartesT().remove(index);
                vueIle.deck();
                vueIle.actualiser();
                break;
            case CARTE_SPE:
                joueur=message.joueur;
                carte=message.carte;
                tuile=message.tuile;
                if (carte.getType()==TypeCT.hélicoptère) {
                    application.deplacement(joueur, tuile);
                }
                if (carte.getType()==TypeCT.sac2sable) {
                    joueur.getRoleJoueur().assecher(tuile);
                }
                vueIle.actualiser();
                break;             
            case GAGNER_TRESOR:
                tuile=message.tuile;
                if(tuile==application.getIle().getTuile("Le Palais de Corail") 
                || tuile==application.getIle().getTuile("Le Palais des Marees")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.calice){
                            t.setEtat(EtatT.trouvé);
                        }
                    }
                } else if(tuile==application.getIle().getTuile("La Caverne du Brasier") 
                || tuile==application.getIle().getTuile("La Caverne des Ombres")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.cristal){
                            t.setEtat(EtatT.trouvé);
                        }
                    }
                } else if(tuile==application.getIle().getTuile("Le Temple de La Lune") 
                || tuile==application.getIle().getTuile("Le Temple du Soleil")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.pierre){
                            t.setEtat(EtatT.trouvé);
                        }
                    }
                } else if(tuile==application.getIle().getTuile("Le Jardin des Murmures") 
                || tuile==application.getIle().getTuile("Le Jardin des Hurlements")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.statue){
                            t.setEtat(EtatT.trouvé);
                        }
                    }
                }
                vueIle.deck();
                break;
                
            case DEFAUSSER:
                joueur = message.joueur;
                carte = message.carte;
                application.defausserCarteTresor(carte);
                joueur.removeCarte(carte);
                vueIle.deck();
                vueIle.actualiser();
                break;
                
            case TERMINER_TOUR: //Clic pour finir son tour
                joueur = message.joueur;
                joueur.initPointAction(); //Réinitialise les points d'action du joueur
                application.innonder(application.getNiveaudeau().getNiveauinondation()); //Innonde un nombre de case en fonction du niveau d'eau
                vueIle.bonhommeSurSombrée();
                if (application.getEtatTour()){
                    application.getNiveaudeau().monterEau();
                    application.setEtatTour(false);
                }
                vueIle.conditionDefaite();
                vueIle.listeAssecher();
                vueIle.deck();
                vueIle.actualiser();
                break;
            case FIN_PARTIE:
                System.out.println("Vous avez PERDU");
                vueIle.fermerFenetre();
                vueDef = new VueDefaite();
                vueDef.addObservateur(this);
                break;
                
                
            
        }
    }
}   
