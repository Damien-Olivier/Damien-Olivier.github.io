class Animal
{
    String nom;
    Animal(String n)
    {
	nom = n;
    }

    void cri()
    {
	System.out.println("Cette méthode est ici pour permettre la compil");
    }
}
	
class Oiseau extends Animal
{
    Oiseau(String n)
    {
	super(n);
    }
    
    void cri()
    {
	System.out.println("CuiCui");
    }

    void vole()
    {
	System.out.println("...vvvvvvVVVVVVV");
    }
}

class Chat extends Animal
{
    Chat(String n)
    {
	super(n);
    }
    
    void cri()
    {
	System.out.println("Miaou");
    }
}


public class DessinAnime6
{
    public static void main(String[] argv)
    {
	Animal animaux[] = new Animal[2];

	animaux[0] = new Oiseau("Titi");
	animaux[1] = new Chat("RoMinet");
	for(int i = 0; i < 2; i++)
	    animaux[i].cri();
	((Oiseau)animaux[0]).vole();
    }
}









