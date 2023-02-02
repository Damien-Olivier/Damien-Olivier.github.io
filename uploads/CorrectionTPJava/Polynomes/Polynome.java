import java.util.Scanner;

/**
 * @author Damien Olivier
 *         Classe de calcul sur des polynômes à coefficients réels.
 */
public class Polynome {
    /**
     * Le tableau des coef du polynôme
     */
    private double coef[];
    /**
     * Le degré du polynôme
     */
    private int degre;

    /**
     * Constructeur par défaut
     * On crée un polynôme 0
     */
    public Polynome() {
        degre = 0;
        coef = new double[1];
        coef[0] = 0;
    }

    /**
     * Constructeur par recopie
     * 
     * @param aRecopier polynôme
     */
    public Polynome(Polynome aRecopier) {
        degre = aRecopier.degre;
        coef = new double[degre + 1];
        for (int i = 0; i <= degre; i++)
            coef[i] = aRecopier.coef[i];
    }

    /**
     * Constructeur qui reçoit un tableau de double et retourne un polynôme
     * 
     * @param tabDouble représente les coefficients
     */
    public Polynome(double[] tabDouble) {
        degre = tabDouble.length - 1;
        coef = tabDouble.clone();
    }

    /**
     * Contructeur qui crée un polynome de degré deg dont les coef sont nuls.
     * 
     * @param deg
     */
    public Polynome(int deg) {
        degre = deg;
        coef = new double[degre + 1];
    }

    /**
     * Crée un monôme sous la forme d'un polynôme avec un unique coefficient non nul
     * 
     * @param coef
     * @param d
     * @return le monôme sous la forme d'un polynôme
     */
    private Polynome creeMonome(double coef, int d) {
        Polynome m = new Polynome(d);
        m.coef[d] = coef;
        return m;
    }

    // --------------------------------------------------------------------
    /**
     * On considère que deux nombres sont égaux si leur différence en valeur absolue
     * est voisine de 0.
     * 
     * @param a
     * @param b
     * @return vrai si a est voisin de b
     */
    private boolean egalite(double a, double b) {
        final double EPSILON = 1E-6;
        return ((a - b) * (a - b) < EPSILON * EPSILON);
    }

    /**
     * Teste si this est le polynôme null
     * 
     * @return vrai si this est le polynôme null
     */
    private boolean estNull() {
        return degre == 0 && egalite(coef[0], 0.);
    }

    /**
     * Retourne le coefficient associé à un degré s'il existe. Zéro sinon.
     * 
     * @param n degré du coefficient du polynome
     * @return le coeefficient de degré n s'il existe, 0 sinon
     */
    private double coefficient(int n) {
        if (n >= coef.length)
            return 0;
        else
            return coef[n];
    }

    /**
     * Suppression de coefficients de plus haut degré lorsqu'il sont nuls.
     * Attention ne crée pas de polynôme !
     * 
     * @return le polynome réduit
     */
    private Polynome reduction() {
        int i = degre;
        while (i > 0 && egalite(coef[i], (double) 0)) {
            i--;
            degre--;
        }
        return this;
    }

    /**
     * Normalisation du polynôme
     * Attention ne crée pas de polynôme !
     * 
     * @return this normalisé
     */
    private Polynome normalise() {
        double coefDominant = coef[degre];
        if (!egalite(coefDominant, 1)) {
            for (int i = 0; i <= degre; i++)
                coef[i] /= coefDominant;
        }
        return this;
    }

    /**
     * Saisie d'un polynôme au clavier
     * 
     * @return le polynôme lu
     */
    public static Polynome litPolynome() {
        Polynome polyLu;
        System.out.println("Degré du polynôme : ");
        Scanner entree = new Scanner(System.in);
        polyLu = new Polynome(entree.nextInt());
        for (int i = polyLu.degre; i >= 0; i--) {
            System.out.println("Coefficient de degré " + i + " : ");
            polyLu.coef[i] = entree.nextDouble();
        }
        // entree.close();
        return polyLu;
    }

    /**
     * Coefficient du monôme vers String
     * 
     * @param ai
     * @param d
     * @return
     */
    private String toStringMonome(double ai, int d) {
        String aiToString = String.format("%.2f", ai);
        if (d == 0)
            return "" + aiToString;
        else if (d == 1)
            return aiToString + "*x ";
        else
            return aiToString + "*x^" + d + " ";
    }

    /**
     * Représentation du polynome sous forme d'une chaîne de caractère.
     */
    @Override
    public String toString() {
        String poly = "";
        boolean affichePlus = false;
        if (degre == 0 && egalite(coef[0], (double) 0))
            return "0";
        for (int i = degre; i >= 0; i--) {
            double ai = coefficient(i);
            if (!egalite(ai, (double) 0))
                if (ai > 0 && affichePlus)
                    poly = poly + "+" + toStringMonome(ai, i);
                else {
                    poly = poly + toStringMonome(ai, i);
                    affichePlus = true;
                }
        }
        return poly;
    }

    /**
     * Somme de 2 polynomes
     * 
     * @param q
     * @return un nouveau polynôme this + q
     */
    public Polynome sommePolynome(Polynome q) {
        Polynome resultat = (degre > q.degre) ? new Polynome(degre) : new Polynome(q);
        for (int i = 0; i <= resultat.degre; i++) {
            resultat.coef[i] = coefficient(i) + q.coefficient(i);
        }
        return resultat.reduction();
    }

    /**
     * Soustraction de 2 polynomes
     * 
     * @param q
     * @return un nouveau polynôme this - q
     */
    public Polynome soustractPolynome(Polynome q) {
        Polynome resultat = (degre > q.degre) ? new Polynome(degre) : new Polynome(q);
        for (int i = 0; i <= resultat.degre; i++) {
            resultat.coef[i] = coefficient(i) - q.coefficient(i);
        }
        return resultat.reduction();
    }

    /**
     * Produt de 2 polynomes
     * 
     * @param q
     * @return un nouveau polynôme this * q
     */
    public Polynome produitPolynome(Polynome q) {
        Polynome resultat = new Polynome(degre + q.degre);
        for (int i = 0; i <= degre; i++)
            for (int j = 0; j <= q.degre; j++)
                resultat.coef[i + j] += coefficient(i) * q.coefficient(j);
        return resultat;
    }

    /**
     * Dérivée du polynome
     * 
     * @return un nouveau polynôme this'(x)
     */
    public Polynome derivee() {
        if (degre > 0) {
            Polynome resultat = new Polynome(degre - 1);
            for (int i = 0; i <= resultat.degre; i++)
                resultat.coef[i] = (i + 1) * coef[i + 1];
            return resultat;
        }
        return new Polynome();
    }

    /**
     * Division de deux polynomes
     * 
     * @param b le deuxième polynome
     * @return un nouveau polynôme this / b
     * @throws ExceptionDivPolyNul
     */
    public Polynome divisionPolynome(Polynome b) throws ExceptionDivPolyNul {/* a/b */
        // a = b * q + r
        // b doit être non nul, sinon lever une exception
        // Initialisation q = 0 r = a
        Polynome q = new Polynome();
        Polynome r = new Polynome(this);
        Polynome m;
        if (b.estNull())
            throw new ExceptionDivPolyNul("Division par zéro");
        if (b.degre > degre)
            return new Polynome();
        if (b.degre > 0) {
            while (r.degre >= b.degre) {
                m = creeMonome(r.coefficient(r.degre) / b.coefficient(b.degre), r.degre - b.degre);
                q = q.sommePolynome(m);
                r = r.soustractPolynome(b.produitPolynome(m));
            }
        } else {
            q = this.produitPolynome(creeMonome(1 / b.coef[0], 0));
        }
        return q.normalise();
    }

    /**
     * Reste de le division de deux polynômes
     * @param b
     * @return
     * @throws ExceptionDivPolyNul
     */
    public Polynome resteDivision(Polynome b) throws ExceptionDivPolyNul {/* a/b */
        // a = b * q + r
        // b doit être non nul, sinon lever une exception
        // Initialisation q = 0 r = a
        Polynome q = new Polynome();
        Polynome r = new Polynome(this);
        Polynome m;
        if (b.estNull())
            throw new ExceptionDivPolyNul("Division par zéro");
        if (b.degre > 0) {
            while (r.degre >= b.degre) {
                m = creeMonome(r.coefficient(r.degre) / b.coefficient(b.degre), r.degre - b.degre);
                q = q.sommePolynome(m);
                r = r.soustractPolynome(b.produitPolynome(m));
            }
            return (r.estNull() ? new Polynome() : r.normalise());
        } else
            return new Polynome();
    }

    /**
     * PGCD de deux polynômes. Algorithme d'Euclide.
     * @param q
     * @return
     */
    public Polynome pgcdEuclide(Polynome q) {
        Polynome a = new Polynome(this); // recopie du polynôme
        Polynome b = new Polynome(q);
        Polynome r = null;
        // pgcd(a, b) = pgcd(b, r), r le reste de a/b
        // On itére et à chaque itération a qui devient b et r devient b
        while (b.degre > 0) {
            try {
                r = a.resteDivision(b);
            } catch (ExceptionDivPolyNul e) {
                e.printStackTrace();
            }
            a = b;
            b = r;
        }
        if (r != null) // On est rentré dans la boucle
            return a;
        else
            return creeMonome(1, 0); // Le PGCD est 1
    }
}