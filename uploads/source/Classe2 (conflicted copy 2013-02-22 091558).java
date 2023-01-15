public class Classe2 extends Classe1 implements Interface2 {

	public void p() {
		String affichage = "Implementation de la methode p() de Interface2";
		System.out.println(quiSuisJe() + affichage);
	}
	public void m() {
		System.out.println(quiSuisJe() + "methode m() de 2");
		super.m();
	}

}
