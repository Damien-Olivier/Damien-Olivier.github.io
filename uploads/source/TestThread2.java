class TPrint2 implements Runnable {

    String txt;
    int attente;

    public TPrint2(String t, int p) {
	txt = t;
	attente = p;
    }

    public void run() {
	for (int i=0; i<8; i++) {
	    System.out.print(txt+i+" ");
	    try {
		Thread.currentThread().sleep(attente);
	    }
	    catch(InterruptedException e) {};
	}
    }
}

public class TestThread2 {
    static public void main(String args[]) {
	TPrint2 a = new TPrint2("A", 10);
	TPrint2 b = new TPrint2("B", 20);
	new Thread(a).start();
	new Thread(b).start();
    }
}

// résultat de l'exécution :
// A0 B0 A1 B1 A2 A3 B2 A4 A5 B3 A6 A7 B4 B5 B6 B7 




