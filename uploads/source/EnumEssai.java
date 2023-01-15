 enum Feu {
    VERT(0), ORANGE(1), ROUGE(5);
    private int point;
    private Feu(int val) {point = val;}         // Le constructeur doit être privé
    public int getPoint() {return point;}
}

public class EnumEssai {

    public static void main(String[] s) {
        Feu tricolore = Feu.VERT;
        System.out.println(tricolore.toString());   // toString() retourne le nom de la constante
        System.out.println(tricolore.ordinal());    // Numéro d'ordre dans l'énumération
        tricolore = Feu.valueOf("ROUGE");           // Valeur énumérée à partir de la chaîne de kr
        System.out.println(tricolore);
        Feu[] couleurs = Feu.values();              // Tableau de toutes les valeurs
        for(int i = 0; i < couleurs.length ; i++)
            System.out.println(couleurs[i]);
        System.out.println(Feu.VERT.compareTo(tricolore)); // Compare les numéro d'ordre 
        System.out.println("Combien " + tricolore.getPoint());
    }
}