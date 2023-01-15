class Mec implements Cloneable
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


    public Object clone() 
	throws CloneNotSupportedException
    {
	Mec duplicata = (Mec) super.clone();
	duplicata.nom = new String(nom);
	duplicata.prenom = new String(prenom);
	return duplicata;
    } 

    boolean copieSurface(Mec m)
    {
	return m.prenom == prenom;
    }
}

public class Individu3
{
    public static void main(String[] argv)
	throws CloneNotSupportedException
    {
	Mec jumeau1 = new Mec("TACAISSE", "Alphonse");
	Mec jumeau2;
	jumeau2 = (Mec) jumeau1.clone();
	System.out.println("jumeau1 = " + jumeau1);
	System.out.println("jumeau2 = " + jumeau2);
	jumeau2.modifNom("PASTACAISSE");
	System.out.println("jumeau1 = " + jumeau1);
	System.out.println("jumeau2 = " + jumeau2);
	if (jumeau1.copieSurface(jumeau2))
	    System.out.println("C'est une copie de surface !");
	else  System.out.println("Ce n'est pas une copie de surface !");
    }
}


