interface Animal
{
    void cri();
}

interface PeuVoler extends Animal
{
    void vol();
}

interface PeuNager extends Animal
{
    void nage();
}

class Personnage
{
    public void cri(){System.out.println("Je crie");};
}

class Hero extends Personnage implements PeuVoler, PeuNager
{
    String quelCri;

    Hero(String c){quelCri = c;}
    public void vol(){}
    public void nage() {}
    public void cri() {System.out.println(quelCri);}
}

public class DessinAnime2
{
    public static void main(String[] argv)
    {
	Personnage donald = new Hero("Couincouin");
	donald.vol(); //Crée une erreur de compilation
	donald.cri();
	//donald.nage();
	Personnage p = new Personnage();
	p.cri();
    }
}
