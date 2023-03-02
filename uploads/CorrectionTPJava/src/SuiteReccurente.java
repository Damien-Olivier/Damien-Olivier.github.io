public abstract class SuiteReccurente {
    private double u0;

    public SuiteReccurente() {
        u0 = 0;
    }

    public SuiteReccurente(double d) {
        u0 = d;
    }

    /**
     * Calcul du terme suivant de la suite récurrente
     * @param d valeur du terme précédent
     * @return un (terme suivant)
     */
    public abstract double suivant(double d);

    /**
     * Calcul du terme d'un rang donné 
     * @param rang le rang 
     * @return le terme de rang rang 
     */
    public double terme(int rang) {
        double un;

        un = u0;
        for(int i = 1; i <= rang; i++) un = suivant(un);        
        return un;
    }

/**
 * Somme des n premiers termes
 * @param n
 * @return somme des n premiers termes
 */
    public double somme(int n) {
        double total, un;
        un = u0;
        total = u0;
        for(int i = 1; i <= n; i++) {
            un = suivant(un);
            total += un;
        }
        return total;
    }
}
