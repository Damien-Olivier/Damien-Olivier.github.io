class Mec
{
    private String nom, prenom;
    Mec(String n, String p)
    {
	nom = n;
	prenom = p;
    }

    void modifNom(String n)
    {
	nom = n;
    }

    public String toString()
    {
	return prenom + nom;
    }
}

public class Individu
{
    public static void main(String[] argv)
    {
	Mec jumeau1 = new Mec("TACAISSE", "Alphonse");
	Mec jumeau2;
	jumeau2 = jumeau1;
	System.out.println("jumeau1 = " + jumeau1);
	System.out.println("jumeau2 = " + jumeau2);
	jumeau2.modifNom("PASTACAISSE");
	System.out.println("jumeau1 = " + jumeau1);
	System.out.println("jumeau2 = " + jumeau2);
    }
}
