class ClasseDeBase
{
    ClasseDeBase()
    {
	System.out.println("Constructeur par d�faut de la classe de base");
    }
    
    ClasseDeBase(int i)
    {
	System.out.println("Constructeur a 1 param�tre i = "+i);
    }
}

class ClasseD�riv�e extends ClasseDeBase
{
    ClasseD�riv�e()
    {
    }
}

public class ConstructeurEtHeritage
{
    public static void main(String argv)
    {
	ClasseD�riv�e obj = new ClasseD�riv�e();
    }
}
