class ClasseDeBase
{
   ClasseDeBase()
    {
	System.out.println("Constructeur par défaut de la classe de base");
    }
    
    ClasseDeBase(int i)
    {
	System.out.println("Constructeur a 1 paramètre de la classe de base i = "+i);
    }
}

class ClasseDérivée extends ClasseDeBase
{
    ClasseDérivée()
    {}

    ClasseDérivée(int i)
    {
	super(i);
    }

    ClasseDérivée(int i, int j)
    {}
}

public class ConstructeurEtHeritage
{
    public static void main(String[] argv)
    {
	ClasseDérivée obj1 = new ClasseDérivée();
	ClasseDérivée obj2 = new ClasseDérivée(9);
	ClasseDérivée obj3 = new ClasseDérivée(1, 2);

    }
}
