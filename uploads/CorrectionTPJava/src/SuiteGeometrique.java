public class SuiteGeometrique extends SuiteReccurente {
    private final double cste;

    public SuiteGeometrique() {
        super();
        cste = 0;
    }

    public SuiteGeometrique(double u0, double c) {
        super(u0);
        cste = c;
    }

    public double suivant(double d) {
        return d * cste;
    } 


    
}
