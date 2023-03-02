public class App {
    public static void main(String[] args) throws Exception {
        double sommeInitiale = 5000;
        double taux = 0.025;
        int nbAnnee = 7;

        System.out.println("Quelques suites réccurentes");

        SuiteGeometrique u = new SuiteGeometrique(sommeInitiale, 1 + taux );
        System.out.println("u" + (nbAnnee - 1) + " = " + u.terme(nbAnnee - 1));
        System.out.println("Résultat = " + sommeInitiale * Math.pow(1+taux, nbAnnee-1));
        System.out.println("Somme de 0 à 20 : " + u.somme(20));

        SuiteFibonacci v = new SuiteFibonacci();
        System.out.println("F10 = " + v.terme(10));

        double nombreDOr = (1 + Math.sqrt(5)) /2;
        System.out.println("Nombre d'or = " + nombreDOr);

        double vSuivant, rapport, vn = v.terme(1);
        for(int i = 2; i < 20; i++) {
            vSuivant = v.terme(i);
            rapport = vSuivant / vn;
            System.out.println("v_n+1/v_n = " + rapport + " delta = " + Math.abs(rapport - nombreDOr));
            vn = vSuivant;
        }


    }
}
