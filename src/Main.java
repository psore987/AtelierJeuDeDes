// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        Test.test(9, true);

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

    void lancer() {
        // simule un lancer de dé
        // et modifie la valeur du dé
        valeur = (int) (Math.random() * nbFaces + 1);
    }

    void toString2() {
        // renvoie un récapitulatif du tirage du dé dont le no est passé en paramètre
       System.out.println("Le lancer de ce dé a donné : " + valeur);
    }

    void pipe() {
        // lancé d'un dé pipé et modification de sa valeur
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
