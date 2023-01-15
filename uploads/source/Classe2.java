public class Classe2 extends Classe1 implements Interface2 {

	public void p() {
		String affichage = "Implementation de la methode p() de Interface2";
		System.out.println(quiSuisJe() + affichage);
	}
	/*
	 * Bien que Interface2 hérite de Interface2, il n'est nécessaire de (re)définir
	 * la méthode m(), elle est héritée de Classe1
	 */
	public void m() { 
		System.out.println(quiSuisJe() + "methode m() de 2");
		super.m();
	}

}
