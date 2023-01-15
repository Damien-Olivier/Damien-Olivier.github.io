class Complexe
{
    private double reel, imaginaire;

    Complexe(double r, double i)
    {
	reel = r;
	imaginaire = i;
    }
    
    public boolean equals(Object o)
    {
	return (o instanceof Complexe) && (((Complexe)o).reel == reel) 
	    && (((Complexe) o).imaginaire == imaginaire);
    }
}

public class UtilComplexe2
{
    public static void main(String[] argv)
    {
	Complexe z1 = new Complexe(7,7);
	Complexe z2 = new Complexe(7,7);
	Complexe z3 = z1;

	if (z1 == z3)
	    System.out.println("z1 et z3 contiennent la même référence");
	if (z1 != z2)
	    {
		System.out.println("Ce n'est pas la même référence");
		if (z1.equals(z2))
		    System.out.println("C'est le même contenu");
	    }
    }
}
