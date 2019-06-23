package Controleur;

import Vue.VueFinPartie;
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
import Vue.Vuedébut;
import ile_interdite.TypeAventurier;
import ile_interdite.TypeCT;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Controleur implements Observateur {
    private VueIle vueIle;
    private Vuedébut vueDebut;
    private VueNiveauDo vueNiveauDo;
    private VueFinPartie vueDef;
    private Application application;
    
    public Controleur() {
        vueDebut = new Vuedébut();
        vueDebut.addObservateur(this);
    }  
    @Override
    public void traiterMessage(Message message) {
        Joueur joueur;
        Tuile tuile;
        CarteTresor carte;
        boolean assecher;
        
        int no_joueur = 0, suivant;
        boolean victoire;
        int difficulté;
        int nbJoueurs;
        ArrayList<String> pseudos;

        switch(message.type) {
            case DEMARRER_PARTIE:
                pseudos = new ArrayList<>();
                difficulté = message.difficulté;
                nbJoueurs = message.nbJoueurs;
                System.out.println("Nombre de Joueur : "+nbJoueurs);
                pseudos.add(message.nj1);
                pseudos.add(message.nj2);
                pseudos.add(message.nj3);
                pseudos.add(message.nj4);
                application = new Application();
                application.initMap();
                application.getNiveaudeau().initNiveauDeau(difficulté+1);
                application.initCartes();
                application.initJoueurs(nbJoueurs);
                
                for (Joueur j: application.getJoueurs()){
                    j.setPseudo(pseudos.get(0));
                    pseudos.remove(0);
                }
                
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
                assecher = message.aasseche;
                if(joueur.getRoleJoueur().getType() == TypeAventurier.ingénieur && assecher && joueur.getPA()>1) {
                    joueur.removePA(2);
                    vueIle.aasseche=false;
                }
                else{
                    joueur.removePA(1);
                }
                
                application.deplacement(joueur,tuile);
                vueIle.actualiser();                
                break;
                
            case ASSECHER: //Clic pour assécher
                joueur = message.joueur;
                tuile = message.tuile;
                assecher = message.aasseche;
                if (joueur.getPA()>1) {
                    if(joueur.getRoleJoueur().getType() == TypeAventurier.ingénieur && !assecher) {
                        joueur.removePA(0);
                    }
                    else if(joueur.getRoleJoueur().getType() != TypeAventurier.ingénieur || assecher){
                        joueur.removePA(1);
                    }
                }
                else if (joueur.getPA()==1){
                    joueur.removePA(0);
                }
                
                joueur.getRoleJoueur().assecher(tuile);//La tuile selectionnée est assechée
                
                vueIle.actualiser();
                break;      
            case ASSECHER2: //Clic pour assécher une deuxième case si PA=1 et ingénieur
                joueur=message.joueur;
                tuile=message.tuile;
                boolean annule=message.annule;
                if (annule==false){
                    joueur.getRoleJoueur().assecher(tuile);
                }
                System.out.println(joueur.getPA());
                joueur.removePA(1);
                System.out.println(joueur.getPA());
                vueIle.actualiser();
                                System.out.println(joueur.getPA());

                break;
            case DONNER:    //Clic pour donner une carte
                joueur=message.joueur;
                Joueur joueur2=message.receveur;
                assecher = message.aasseche;
                int index = 0;
                if(joueur.getRoleJoueur().getType() == TypeAventurier.ingénieur && assecher && joueur.getPA()>1) {
                    index=-1;
                    for(int i=0;i<joueur.getCartesT().size();i++){
                        if(joueur.getCartesT().get(i)== message.carte){
                            joueur.removePA(2);
                            vueIle.aasseche=false;
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
                else if (carte.getType()==TypeCT.sac2sable) {
                    joueur.getRoleJoueur().assecher(tuile);
                }
                joueur.removeCarte(carte);
                
                vueIle.actualiser();
                break;             
            case GAGNER_TRESOR:
                tuile=message.tuile;
                joueur= message.joueur;
                CarteTresor carteT; 
                if(tuile==application.getIle().getTuile("Le Palais de Corail") 
                || tuile==application.getIle().getTuile("Le Palais des Marees")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.calice){
                            t.setEtat(EtatT.trouvé);
                            carteT= new CarteTresor(TypeCT.calice);
                            for (int i =0; i<4;i++){
                                joueur.removeCarte(carteT);
                            }
                        }
                    }
                } else if(tuile==application.getIle().getTuile("La Caverne du Brasier") 
                || tuile==application.getIle().getTuile("La Caverne des Ombres")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.cristal){
                            t.setEtat(EtatT.trouvé);
                            carteT= new CarteTresor(TypeCT.cristal);
                            for (int i =0; i<4;i++){
                                joueur.removeCarte(carteT);
                            }
                        }
                    }
                } else if(tuile==application.getIle().getTuile("Le Temple de La Lune") 
                || tuile==application.getIle().getTuile("Le Temple du Soleil")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.pierre){
                            t.setEtat(EtatT.trouvé);
                            carteT= new CarteTresor(TypeCT.pierre);
                            for (int i =0; i<4;i++){
                                joueur.removeCarte(carteT);
                            }
                        }
                    }
                } else if(tuile==application.getIle().getTuile("Le Jardin des Murmures") 
                || tuile==application.getIle().getTuile("Le Jardin des Hurlements")){
                    for(Tresor t:application.getTrésors()){
                        if(t.getNom()==TypeT.statue){
                            t.setEtat(EtatT.trouvé);
                            carteT= new CarteTresor(TypeCT.statue);
                            for (int i =0; i<4;i++){
                                joueur.removeCarte(carteT);
                            }
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
                vueIle.conditionVictoire();
                vueIle.conditionDefaite();

                vueIle.listeAssecher();
                vueIle.deck();
                vueIle.actualiser();
               
                break;
                /////////////////////////////ya myen d'opti (avec un changeListener dansVueDefaite ?)////////////////////
            case FIN_PARTIE:
                victoire = message.victoire;
                String messageMort = message.raisonMort;
                vueDef = new VueFinPartie();
                vueDef.addObservateur(this);
                //On verifie si on a gagne ou perdu
                //Si on gagne alors message et fenetre victoire ?
                if(victoire){
                    vueDef.vueDefChangeTitreFenetre("Victoire");
                    vueDef.vueDefChangeTexteVictoireOuDefaite("Vous avez gagné");
                    //sinon on a donc perdu Fermeture fenetre + fenetre VueDefaite();
                }else{
                    vueDef.vueDefChangeTitreFenetre("Défaite");
                    vueDef.vueDefChangeTailleEcritureFenetreFinJeu(30);
                    vueDef.vueDefChangeTexteVictoireOuDefaite("Vous avez perdu : " +messageMort);
                   // vueDef.perdu.setText("Vous avez Perdu :");
                    
                }
                vueIle.fermerFenetre();  
                break;
        }
    }
}   
