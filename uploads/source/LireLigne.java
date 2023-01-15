import java.io.*;
public class LireLigne
{
  public static void main(String[] args)
    {
      try
       {
         FileReader fr=new FileReader("/etc/fstab");
         BufferedReader br= new BufferedReader(fr);
         while (br.ready())
            System.out.println(br.readLine());
         br.close();
        }
     catch (Exception e)
        {System.out.println("Erreur "+e);}
    }
}
