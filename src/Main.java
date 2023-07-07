// Ceci est la 3ème version du projet

public class Main {
    public static void main(String[] args) {
        Test.test(3,true);

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
    int getNbFaces(int noDe) { // Afficher le nb de faces
        return nbFaces;
    }

    int getValeur(int noDe) { // Afficher la valeur du de
        return valeur;
    }

    int getNum(int noDe) { // Afficher le numero du de
        return num;
    }

    int lancer(int noDe) {
        // simule un lancer de de selon le nombre de faces
        return (int) (Math.random() * nbFaces + 1);
    }

    void toString(int noDe) {
        // renvoie un récapitulatif du tirage du dé dont le no est passé en paramètre
        System.out.println(" ==================== Début =============== ");
        System.out.println("le nombre de faces est : " + getNbFaces(num));
        System.out.println("Le numéro du dé est : " + getNum(num));
        System.out.println("la valeur du dé est : " + getValeur(num));
        System.out.println("============== C'est parti !! ==============");
        System.out.println("Le lancer de ce dé a donné : " + lancer(num));
    }

    boolean pipe(int noDe) {
        // lancé d'un dé pipé et retour d'un booléen
        int tirage = lancer(noDe);
        boolean dePipe = false;

        while (tirage != 1 && tirage != 2 && tirage != 4) {
            tirage = lancer(noDe);
            dePipe = true;
            System.out.println(" !!!!!!! Ce tirage a été modifié V3!!!!!!!!!!");
           }

        return dePipe;
    }
}

class Test {
    // Crée et lance 3 dés
    public static void test(int nbDe, boolean pipe) {
        for (int i = 0; i < nbDe; i++) {
            De de = new De(); // nouvelle instance
            if (pipe){
                de.pipe(de.num);}
            else {
                de.lancer(de.num);
            }
            de.toString(de.num);
        }
    }
}
