import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
      //  TestSimulateur.testSimulateur();
        Joueur.initJoueurs();
        Joueur.afficherJoueurs();
    }
}

// Classe De
class De {
    // déclaration des attributs
    int num;
    int nbFaces;
    int valeur;

    // constructeur secondaire de la classe De
    De() {
        this(0, 6, 3); // valeurs par defaut
    }

    // constructeur principal de la classe De
    De(int num, int nbFaces, int valeur) {
        // pour nouvelle instanciation
        this.num = num;
        this.nbFaces = nbFaces;
        this.valeur = valeur;
    }

    // Accesseurs de la classe De
    int getNbFaces() { // Afficher le nb de faces
        return nbFaces;
    }

    int getValeur() { // Afficher la valeur du de
        return valeur;
    }

    int getNum() { // Afficher le numero du de
        return num;
    }

    int lancer() {
        // simule un lancer de de
        // et modifie la valeur du de
        valeur = (int) (Math.random() * nbFaces + 1);
        return valeur;
    }

    void toString2() {
        // renvoie un récapitulatif du tirage du dé dont le no est passe en parametre
        System.out.println("Le lancer de ce dé a donné : " + valeur);
    }

    void pipe() {
        // lancer d'un dé pipe et modification de sa valeur
        lancer();
        boolean tricher = false;
        while (valeur != 1 && valeur != 2 && valeur != 4) {
            lancer();
            System.out.println(" triche ! ");
            tricher = true;
        }
        System.out.println(tricher);
    }
}

class Test {
    // Crée et lance 3 dés
    public static void test(int nbDe, boolean pipe) {
        for (int i = 0; i < nbDe; i++) {
            De de = new De(); // nouvelle instance
            if (pipe) {
                de.pipe();
            } else {
                de.lancer();
            }
            de.toString2();
        }
    }
}

class Simulateur {
    int nbLignes = 11; // = nb de joueurs + 1 la 1ere ligne ne sera pas remplie

        int nbColonnes = 20;
    int[][] tab;

    // constructeur
    Simulateur() {
        this.tab = new int[nbLignes][nbColonnes];
        initialiser();
    }

    public void simuler() {
        remplir();
        afficherMatrice();
        }

    private void initialiser() { // initialiser la matrice à 0
        for (int i = 1; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                tab[i][j] = 0;
            }
        }
        System.out.println("initialisation ok ! ");
    }

    private void afficherMatrice() {
        for (int i = 1; i < nbLignes; i++) {
            afficherLancersJoueur(i);
        }
    }

    int afficherTotalJoueur(int nbJ){
        int j;
        int somme = 0;
        for (j = 0; j<nbColonnes;j++){
            somme += tab[nbJ][j];
        }
        return somme;
    }
    private void remplir() {
        for (int i = 1; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                De de = new De();
                tab[i][j] = de.lancer();
            }
        }
    }

    private void afficherLancersJoueur(int numJ) {
        int nbSix = 0;
        System.out.print("Lancers du joueur " + numJ + ": ");
        for (int j = 0; j < nbColonnes; j++) {
            System.out.print(tab[numJ][j] + " ");
            if (tab[numJ][j] == 6) {
                nbSix += 1;
            }
        }
        System.out.print("Total : " + afficherTotalJoueur(numJ) + " dont " + nbSix +" six");

        System.out.println();
    }
}

class TestSimulateur {
    public static void testSimulateur() {
        Simulateur simulateur = new Simulateur();
        simulateur.simuler();
    }
}

class Joueur {
    String nomJ;
    String prenomJ;
    int[] tiragesJ;
    int totalJ;

    // constructeur
    Joueur(String nomJ, String prenomJ, int[] tiragesJ, int totalJ) {
        this.nomJ = nomJ;
        this.prenomJ = prenomJ;
        this.tiragesJ = tiragesJ;
        this.totalJ = totalJ;
    }

    // methodes
    public static ArrayList<Joueur> initJoueurs() {
        ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();

        // Création des joueurs
        Joueur joueur1 = new Joueur("Nom1", "Prenom1", new int[20], 0);
        Joueur joueur2 = new Joueur("Nom2", "Prenom2", new int[20], 0);
        Joueur joueur3 = new Joueur("Nom3", "Prenom3", new int[20], 0);
        Joueur joueur4 = new Joueur("Nom4", "Prenom4", new int[20], 0);
        Joueur joueur5 = new Joueur("Nom5", "Prenom5", new int[20], 0);
        Joueur joueur6 = new Joueur("Nom6", "Prenom6", new int[20], 0);
        Joueur joueur7 = new Joueur("Nom7", "Prenom7", new int[20], 0);
        Joueur joueur8 = new Joueur("Nom8", "Prenom8", new int[20], 0);
        Joueur joueur9 = new Joueur("Nom9", "Prenom9", new int[20], 0);
        Joueur joueur10 = new Joueur("Nom10", "Prenom10", new int[20], 0);


        // Ajout des joueurs à la liste
        listeJoueurs.add(joueur1);
        listeJoueurs.add(joueur2);
        listeJoueurs.add(joueur3);
        listeJoueurs.add(joueur4);
        listeJoueurs.add(joueur5);
        listeJoueurs.add(joueur6);
        listeJoueurs.add(joueur7);
        listeJoueurs.add(joueur8);
        listeJoueurs.add(joueur9);
        listeJoueurs.add(joueur10);


        return listeJoueurs;
    }

    public static void afficherJoueurs() {
        ArrayList<Joueur> listeJoueurs = initJoueurs();

        for (Joueur joueur : listeJoueurs) {
            System.out.println("Joueur : " + joueur.nomJ + " " + joueur.prenomJ);
            System.out.println("Score total : " + joueur.totalJ);
            System.out.println();
        }
    }
}
