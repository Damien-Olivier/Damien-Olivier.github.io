public class TestPolynome {

    public static void verifie(Polynome p, Polynome q) {
        System.out.println("p(x)         = " + p);
        System.out.println("q(x)         = " + q);
        // Tester addition, soustraction, multiplication et reste ......
        System.out.println("p'(x)        = " + p.derivee());
        System.out.println("q'(x)        = " + q.derivee());
        System.out.println("p(x) + q(x)  = " + p.sommePolynome(q));
        System.out.println("p(x) - q(x)  = " + p.soustractPolynome(q));
        System.out.println("p(x) * q(x)  = " + p.produitPolynome(q));
        try {
            System.out.println("p(x) / q(x)  = " + p.divisionPolynome(q));
            System.out.println("p(x) % q(x)  = " + p.resteDivision(q));
        } catch (ExceptionDivPolyNul e) {
            e.printStackTrace();
        }
        System.out.println("PGCD(p,q)    = " + p.pgcdEuclide(q));
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        Polynome p1 = new Polynome(new double[] { -2, -1, 1, 8, 7.3, 1 });
        Polynome p2 = new Polynome(new double[] { -2, -1, -1, 6, -6.3, 1 });
        Polynome p3 = new Polynome(new double[] { -1, 3 });
        Polynome p4 = new Polynome(new double[] { +1, 3 });
        Polynome a = new Polynome(new double[] { 4, 1, -1, -3, 0, 1 });
        Polynome b = new Polynome(new double[] { 1, 0, -2, 1 });
        Polynome c = new Polynome(new double[] { 4 });
        Polynome d = new Polynome(new double[] { 8 });
        Polynome zero = new Polynome(new double[] { 0 });
        Polynome p5 = new Polynome(new double[] { -2, -1, 1, 0, -2, 1 });
        Polynome p6 = new Polynome(new double[] { -2, -1, -1, 1 });
        verifie(p1, p2);
        verifie(p1, p1);
        verifie(p3, p3);
        verifie(p3, p4);
        verifie(a, d);
        verifie(a, c);
        verifie(d, c);
        verifie(p1, zero);
        verifie(p5, p6);
        verifie(p6, p5);
    }
}