
package ile_interdite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Application {
	public Ile ile; //ile contenant les tuiles du jeu
	public Niveaudo niveaudeau = new Niveaudo(); //niveau de l'eau   
	public ArrayList<Tresor> trésors = new ArrayList<Tresor>(); //liste des trésors de l'ile
	public ArrayList<CarteInondation> cartesInondation = new ArrayList<CarteInondation>(); //liste des cartes inondation pouvant être piochées
        public ArrayList<CarteInondation> defausseInondation = new ArrayList<>(); //liste des cartes inondation défaussées
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>(); //liste des joueurs
	public ArrayList<CarteTresor> cartesTresor = new ArrayList<CarteTresor>(); //liste des cartes trésor poyvant être piochées
        public ArrayList<CarteTresor> defausseTresor = new ArrayList<>(); //liste des cartes trésor défaussées
        private boolean finTour = false;

        
        public void tourDeJeu(int x,int y,Joueur j){
            j.initPointAction(); //Point d'action du joueur réinitialisé
            //Le joueur fait trois actions
            
            //Le Joueur tire deux cartes trésor
            for (int i =0;i<2;i++){
                if(cartesTresor.size()>0){
                    piocherCarte(j);                    
                }
            }
            //Le joueur tire un nombre de carte innondation égale au nombre de niveau d'eau
                innonder(niveaudeau.getNiveauinondation());
        }
        
        public void initJoueurs(int nbJoueurs) {  //Initialisation du joueur==> Nom, Numéro, Couleur, Type d'aventurier et pile de cartes persos(vide)
            if(nbJoueurs>4){
                nbJoueurs=4;
            }
            Pilote pilote=new Pilote();
            Explorateur explorateur=new Explorateur();
            Ingénieur ingenieur=new Ingénieur();
            Navigateur navigateur=new Navigateur();
            Plongeur plongeur=new Plongeur();
            Messager messager=new Messager();
            ArrayList <Aventurier> roles=new ArrayList<Aventurier>();
            roles.add(pilote);
            roles.add(explorateur);
            roles.add(ingenieur);
            roles.add(navigateur);
            roles.add(plongeur);
            roles.add(messager);
            int j=0;
            while(j<nbJoueurs){
                int i=(int)((Math.random()*roles.size()));
                this.addJoueur(new Joueur(j+1,"J"+(j+1),roles.get(i)));
                this.getJoueurs().get(j).getRoleJoueur().setEmplacement(this.getIle().getTuile(this.getJoueurs().get(j).getRoleJoueur().getDepart()).getEmplacementX(),this.getIle().getTuile(this.getJoueurs().get(j).getRoleJoueur().getDepart()).getEmplacementY());
                roles.remove(i);
                j++;
            }
            
            for (Joueur js : this.getJoueurs()){
                js.getRoleJoueur().setPosition(this.getIle().getTuile(js.getRoleJoueur().getDepart()));
                for(int i=0;i<2;i++){
                    js.getCartesT().add(cartesTresor.get(i));
                    cartesTresor.remove(i);        
                }
            }
            
        }
        
        public void initCartes(){ //Initialisation des cartes inondations => Ajout de toutes les cartes en fonction du nom des tuiles dans l'ArrayList des cartes inondations
            ArrayList<String> noms = Utils.getNomsTuiles();
            for(int i=0;i<Utils.getNomsTuiles().size();i++){
                cartesInondation.add(new CarteInondation(noms.get(i)));                
            }
            
            int cal=5;
            int cri=5;
            int pie=5;
            int sta=5;
            for(int j=0;j<20;j++){
                int i=(int)((Math.random()*4));
                while(i==0 && cal==0 || i==1 && cri==0 || i==2 && pie==0 || i==3 && sta==0){
                    i=(int)((Math.random()*3));
                }
                if(i==0){
                    cartesTresor.add(new CarteTresor(TypeCT.calice));
                    cal--;
                }
                if(i==1){
                    cartesTresor.add(new CarteTresor(TypeCT.cristal));
                    cri--;
                }
                if(i==2){
                    cartesTresor.add(new CarteTresor(TypeCT.pierre));
                    pie--;
                }
                if(i==3){
                    cartesTresor.add(new CarteTresor(TypeCT.statue));
                    sta--;
                }
            }
        }
        
        public void initPartie(){ //Initialisation de la partie : 6 tuiles aléatoires deviennent inondées
            for(int j=0;j<6;j++){
                int i=(int)((Math.random()*cartesInondation.size()));
                if(this.getIle().getTuile(cartesInondation.get(i).getNomCarte()).getEtat()==EtatC.normale){
                    this.getIle().getTuile(cartesInondation.get(i).getNomCarte()).setEtat(EtatC.innondée);
                    defausseInondation.add(cartesInondation.get(i));
                    cartesInondation.remove(cartesInondation.get(i));
                }
            }
            niveaudeau.initNiveauDeau(); //Le niveau d'eau est initialisé 
            
            trésors.add(new Tresor(TypeT.calice,EtatT.nontrouvé));
            trésors.add(new Tresor(TypeT.cristal,EtatT.nontrouvé));
            trésors.add(new Tresor(TypeT.pierre,EtatT.nontrouvé));
            trésors.add(new Tresor(TypeT.statue,EtatT.nontrouvé));
        }
        
        public void innonder(int nbtuiles){ //Suivant le niveau de montée des eaux, permet de piocher aléatoirement un nombre de cartes inondations, qui inondent ou sombrent une case
            for(int j=0;j<nbtuiles;j++){
                int i=(int)((Math.random()*cartesInondation.size()));
                if(this.getIle().getTuile(cartesInondation.get(i).getNomCarte()).getEtat()==EtatC.normale){
                    this.getIle().getTuile(cartesInondation.get(i).getNomCarte()).setEtat(EtatC.innondée);
                    defausseInondation.add(cartesInondation.get(i));
                    cartesInondation.remove(cartesInondation.get(i));
                } else if(this.getIle().getTuile(cartesInondation.get(i).getNomCarte()).getEtat()==EtatC.innondée){
                    this.getIle().getTuile(cartesInondation.get(i).getNomCarte()).setEtat(EtatC.sombrée);    
                    cartesInondation.remove(cartesInondation.get(i));
                }
                if(cartesInondation.size()==0){
                    for(int k=0;k<defausseInondation.size();k++){
                        cartesInondation.add(defausseInondation.get(k));
                        defausseInondation.remove(defausseInondation.get(k));
                    }
                }
            }
        }
        
        
        
    public void deplacement(Joueur j, Tuile tuile){  //Deplacement d'un joueur
        j.getRoleJoueur().setEmplacement(tuile.getEmplacementX(), tuile.getEmplacementY());//On set l'emplacement du joueur à la nouvelle case
        j.getRoleJoueur().setPosition(tuile); 
        
        //Set la position du joueur
        /*for (int[] i: tuile.getTuilesAdj()) {
            System.out.println(tuile.getIledescases().getTuile(i[0], i[1]).getNom());
        }
        for (int[] i: j.getRoleJoueur().getPosition().getTuilesAdj()) {
            System.out.println(j.getRoleJoueur().getPosition().getIledescases().getTuile(i[0], i[1]).getNom());
        }*/
    }
    
    public void piocherCarte(Joueur j) { //Permet de piocher une carte trésor aléatoire
        int i = (int) (Math.random()*cartesTresor.size());
        j.addCarteToJoueur(cartesTresor.get(i));
        cartesTresor.remove(cartesTresor.get(i));
    }
        
    public void addJoueur(Joueur j) { //ajoute un joueur dans le jeu
            this.joueurs.add(j);
    }

    public Ile getIle() { //retourne l'ile du jeu
        return ile;
    }

    public Niveaudo getNiveaudeau() { //retourne le niveau d'eau
        return niveaudeau;
    }

    public ArrayList<Tresor> getTrésors() { //retourne les trésors
        return trésors;
    }

    public ArrayList<CarteInondation> getCartesInondation() { //retourne la pile de cartes inondation
        return cartesInondation;
    }
    
    public ArrayList<CarteInondation> getDefausseCartesInondation() { //retourne la defausse des cartes inondation
        return defausseInondation;
    }

    public ArrayList<Joueur> getJoueurs() { //retourne les joueurs de la partie
        return joueurs;
    }
    
    public Joueur getJoueur(String nomjoueur){ //Retourne le Joueur en fonction de son nom
        for (Joueur j : getJoueurs()){
            if(j.getNomJoueur().equals(nomjoueur)){
                return j;
            }
        } 
        return null;
    }

    public ArrayList<CarteTresor> getCartesTresor() { //retourne la pile des cartes trésor
        return cartesTresor;
    } 
    
    public ArrayList<CarteTresor> getDefausseCartesTresor() { //retourne la defausse des cartes trésor
        return defausseTresor;
    }

    public void setIle(Ile ile) { //associe une ile à la partie
        this.ile = ile;
    }

    public void setNiveaudeau(Niveaudo niveaudeau) { //permet de donner un niveau d'eau
        this.niveaudeau = niveaudeau;
    }

    public void setTrésors(ArrayList<Tresor> trésors) { //permet d'associer des trésors à la partie
        this.trésors = trésors;
    }

    public void setCartesInondation(ArrayList<CarteInondation> cartesInondation) { //permet d'associer des cartes inondation à la partie
        this.cartesInondation = cartesInondation;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) { //permet d'aasocier des joueurs à la partie
        this.joueurs = joueurs;
    }

    public void setCartesTresor(ArrayList<CarteTresor> cartesTresor) { //permet d'associer des cartes trésor à la partie
        this.cartesTresor = cartesTresor;
    }
    
    public void initMap(){ //initialise l'ile   
            ile = new Ile();

            int eR[][] = {{1,3},{1,4},{2,2},{2,3},{2,4},{2,5},{3,1},{3,2},{3,3},{3,4},{3,5},{3,6},{4,1},{4,2},{4,3},{4,4},{4,5},{4,6},{5,2},{5,3},{5,4},{5,5},{6,3},{6,4}}; //Emplacement à attribuer restant
            int i = 0;
            int j = 0;
            
            ArrayList<Integer> emplacements = new ArrayList<>();
            ArrayList<String> noms = Utils.getNomsTuiles();
            

            for (Tuile tuile:ile.getCase2ile()){ //Atribution des emplacements restants aux tuiles restantes et attribution d'un nom
                if (tuile.getEmplacementX()==0 && tuile.getEmplacementY()==0) {
                    i=(int)((Math.random()*24));
                    while(eR[i][0]==0){
                        i=(int)((Math.random()*24));
                    }
                    tuile.setEmplacement(eR[i][0],eR[i][1]);
                    tuile.setNom(noms.get(j));
                    j++;
                    eR[i][0]=0;
                }
            }
        }
    
    public int getNbCartesTresor() { //retourne le nombre de cartes trésor dans la pioche
        int i = 0;
        for(CarteTresor ct : this.getCartesTresor()) {
            i++;
        }
        return i;
    }
    
    public int getNbCartesInondation() { //retourne le nombre de cartes inondation dans la pioche
        int i = 0;
        for(CarteInondation ci : this.getCartesInondation()) {
            i++;
        }
        return i;
    }
    
    public void defausserCarteTresor(CarteTresor c) { //permet de defausser une carte trésor
        defausseTresor.add(c);
    }
    
    public void defausserCarteInondation(CarteInondation c) { //permet de defausser une carte inondation
        defausseInondation.add(c);
    }
    
    public void retournerDefausseTresor() { //permet de mélanger la défausse de cartes trésor et d'en faire la pioche
        Collections.shuffle(defausseTresor);
        for(CarteTresor ct : defausseTresor) {
            cartesTresor.add(ct);
            defausseTresor.remove(ct);
        }
    }
    
    public void retournerDefausseInondation(){ //permet de mélanger la défausse de cartes trésor et d'en faire la pioche
        Collections.shuffle(defausseInondation);
        for(CarteInondation ci : defausseInondation) {
            cartesInondation.add(ci);
            defausseInondation.remove(ci);
        }
    }
    
    public ArrayList<Tuile> getCasesDeplacementPilote(){
        ArrayList tuilesPilote= new ArrayList<Tuile>(); 
        tuilesPilote = this.getIle().getTuilesNonSombrees();
        Joueur j=null;
        for(Joueur joueur:this.getJoueurs()){
            if(joueur.getRoleJoueur().getType()==TypeAventurier.pilote){
                j=joueur;
            }
        }
        for(Tuile tu:j.getRoleJoueur().PossibleMouvement()){
            tuilesPilote.remove(tu);
        }
        tuilesPilote.remove(j.getRoleJoueur().getPosition());  
    
        return tuilesPilote;
        }
    
    public boolean getEtatTour(){
        return finTour;
    }
    
    public void setEtatTour(boolean tour){
        this.finTour = tour;
    }
}

