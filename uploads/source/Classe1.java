
public class Classe1 implements Interface1{
	public String quiSuisJe()
	{
		Class c = getClass();
		return "Classe : " + c.getName() + " === ";
	}
	
	public void m() {
		String affichage = "Implementation de la methode m() de Interface1";
		System.out.println(quiSuisJe() + affichage);
	}

}
