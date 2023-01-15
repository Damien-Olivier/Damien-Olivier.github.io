class ClasseDeBase
{
    ClasseDeBase()
    {
	System.out.println("Constructeur par défaut de la classe de base");
    }
    
    ClasseDeBase(int i)
    {
	System.out.println("Constructeur a 1 paramètre i = "+i);
    }
}

class ClasseDérivée extends ClasseDeBase
{
    ClasseDérivée()
    {
    }
}

public class ConstructeurEtHeritage
{
    public static void main(String argv)
    {
	ClasseDérivée obj = new ClasseDérivée();
    }
}
