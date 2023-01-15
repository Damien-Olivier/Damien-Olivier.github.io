import java.io.*;
import java.util.zip.*;

public class UnZip {
   final static int BUFFER = 2048;
   public static void main (String argv[]) {
      try {
         BufferedOutputStream dest = null;
         FileInputStream fis = new 
	   FileInputStream(argv[0]);
         ZipInputStream zis = new 
	   ZipInputStream(new BufferedInputStream(fis));
         ZipEntry entry;
         while((entry = zis.getNextEntry()) != null) {
            System.out.println("Extraction: " +entry);
            int count;
            byte data[] = new byte[BUFFER];
            
	    // On ecrit le fichier dezippé	
            FileOutputStream fos = new 
	      FileOutputStream(entry.getName());
            dest = new 
              BufferedOutputStream(fos, BUFFER);
            while ((count = zis.read(data, 0, BUFFER)) != -1) {
               dest.write(data, 0, count);
            }
            dest.flush();
            dest.close();
         }
         zis.close();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
