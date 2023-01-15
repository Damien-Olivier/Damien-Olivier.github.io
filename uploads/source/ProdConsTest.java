class MoniteurProdCons {
    String tampon;
    boolean estVide = true;

    synchronized void prod(String m) {
	if (!estVide) {
	    System.out.println("Producteur attend");
	    try { wait(); }
	    catch (InterruptedException e) {}
	}
	System.out.println("Produit : "+ m);
	tampon = m; estVide=false; notify();
    }

    synchronized void cons() {
	if (estVide) {
	    System.out.println("Consommateur attend");
	    try { wait(); }
	    catch (InterruptedException e) {}
	}
	System.out.println("Consomme : "+ tampon);
	estVide=true; notify();
    }
}

class Producteur extends Thread {
    MoniteurProdCons tampon;

    public Producteur (MoniteurProdCons t) {
	tampon = t;
    }

    public void run() {
	tampon.prod("message1"); tampon.prod("message2");
	try { sleep(100); }
	catch(InterruptedException e) {}
	tampon.prod("message3");
    }
}

class Consommateur extends Thread {
    MoniteurProdCons tampon;

    public Consommateur(MoniteurProdCons t) {
	tampon = t;
    }

    public void run() {
	tampon.cons(); tampon.cons(); tampon.cons();
    }
}

public class ProdConsTest {
    public static void main(String argv[]) {
	MoniteurProdCons tampon = new MoniteurProdCons();
	new Producteur(tampon).start();
	new Consommateur(tampon).start();
    }
}
