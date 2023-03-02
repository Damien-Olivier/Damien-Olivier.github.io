public class SuiteFibonacci extends SuiteReccurente {
    private double unMoins2;

    public SuiteFibonacci() {
        super(1);       // T0 = 1
        unMoins2 = 1;   // T1 = 1
    }

    public double terme(int n) {
        unMoins2 = 1;
        return super.terme(n);
    }

    public double suivant (double unMoins1) {
        double calcul = unMoins1 + unMoins2;
        unMoins2 = unMoins1;
        return calcul;
    }
    
}
