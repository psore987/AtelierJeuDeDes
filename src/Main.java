public class Main {
    public static void main(String[] args) {
        TestSimulateur.testSimulateur();
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
    int nbLignes = 21; // = nb de joueurs + 1 la 1ere ligne ne sera pas remplie
    int nbColonnes = 30;
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

