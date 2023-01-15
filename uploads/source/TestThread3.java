class TPrint3 extends Thread {

    String txt;

    public TPrint3(String t) {
	txt = t;
    }

    public void run() {
	for (int j=0; j<3; j++) {
	    for (int i=0; i<txt.length(); i++) {
		System.out.print(txt.charAt(i));
		try { sleep(100); }
		catch (InterruptedException e) {};
	    }
	}
    }
}

public class TestThread3 {
    static public void main(String args[]) {
	TPrint3 a = new TPrint3("bonjour ");
	TPrint3 b = new TPrint3("au revoir ");
	a.start();
	b.start();
    }
}

// resultat de l'exécution :
// baoun jroeuvro ibro najuo urre vbooinrj oauur  revoir 
