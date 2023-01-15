class MoniteurImpression {
    synchronized public void imprime(String t) {
	for (int i=0; i<t.length(); i++) {
	    System.out.print(t.charAt(i));
	    try { Thread.currentThread().sleep(10); }
	    catch (InterruptedException e) {};
	}
    }
}

class TPrint4 extends Thread {

    String txt;
    static MoniteurImpression mImp = new MoniteurImpression();

    public TPrint4(String t) {
	txt = t;
    }

    public void run() {
	for (int j=0; j<3; j++) 
	    mImp.imprime(txt);
    }
}

public class TestThread4 {
    static public void main(String args[]) {
	TPrint4 a = new TPrint4("bonjour ");
	TPrint4 b = new TPrint4("au revoir ");
	a.start();
	b.start();
    }
}

// résultat de l'exécution :
// bonjour au revoir bonjour au revoir bonjour au revoir 




