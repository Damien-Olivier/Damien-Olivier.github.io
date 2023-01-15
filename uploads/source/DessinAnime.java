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

/* Héritage de code et héritage de propriétés */ 
class Hero extends Personnage implements PeuVoler, PeuNager
{
    String quelCri;

    Hero(String c){quelCri = c;}
    public void vol(){}
    public void nage() {}
    public void cri() {super.cri(); System.out.println(quelCri);}
}

public class DessinAnime
{
    public static void main(String[] argv)
    {
	Hero donald = new Hero("Couincouin");
	donald.vol();
	donald.cri();
	donald.nage();
    }
}

