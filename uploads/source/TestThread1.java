class TPrint1 extends Thread {

    String txt;
    int attente;

    public TPrint1(String t, int p) {
	txt = t;
	attente = p;
    }

    public void run() {
	for (int i=0; i<8; i++) {
	    System.out.print(txt+i+" ");
	    try {
		sleep(attente);
	    }
	    catch(InterruptedException e) {};
	}
    }
}

public class TestThread1 {
    static public void main(String args[]) {
	TPrint1 a = new TPrint1("A", 0);
	TPrint1 b = new TPrint1("B", 20);
	a.start();
	b.start();
    }
}

// résultat de l'exécution :
// A0 B0 A1 B1 A2 A3 B2 A4 A5 B3 A6 A7 B4 B5 B6 B7 
