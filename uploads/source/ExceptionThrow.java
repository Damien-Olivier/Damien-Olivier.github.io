class ExceptionRien extends Exception {
    public ExceptionRien(String s) {
        super(s);
    }
}

public class ExceptionThrow {
    static int moyenne(String[] liste) throws ExceptionRien {
        int somme = 0, entier, nbNotes = 0, i;
        for (i = 0; i < liste.length; i++) {
            try {
                entier = Integer.parseInt(liste[i]);
                // convertion chaîne en valeur entière
                somme += entier;
                nbNotes++;
            } catch (NumberFormatException e) {
                System.out.println("note:" + (i + 1) + " invalide");
            }
        }
        if (nbNotes == 0)
            throw new ExceptionRien("Aucune note n'est valide");
        return somme / nbNotes;
    }

    public static void main(String[] argv) {
        try {
            System.out.println("moyenne " + moyenne(argv));
        } catch (NumberFormatException | ExceptionRien e) {
            System.err.println(e);
        }
    }
}
