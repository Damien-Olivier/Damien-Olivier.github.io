import java.util.*;
import java.io.*;

public class TestFileOutputStream { 
    
    public static void main(String args[]){
	TestFileOutputStream tfos = new TestFileOutputStream();
	tfos.cree_file(args[0]); 
    } 
    
    
    void cree_file(String nomf){  
       	File fic = new File(nomf); 
	System.out.print("Entrez votre texte : ");
        Scanner sc = new Scanner(System.in);
	String s = sc.next();
	try{ 
	    FileOutputStream fos= new FileOutputStream(fic); 
	    int l; 
	    byte b[] = new byte[l=s.length()]; 
	    for (int i=0; i<l; i++) b[i]= (byte) s.charAt(i); 
	    fos.write(b); 
	    fos.close(); 
	} catch(IOException e2){System.out.println("Err I/O "+e2);} 
    }
}// Fin de la class TestFileOutputStream
