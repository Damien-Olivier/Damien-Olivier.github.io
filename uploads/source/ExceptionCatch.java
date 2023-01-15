class ExceptionCatch
{ static int moyenne (String[] liste)
    { 
	int somme=0, entier, nbNotes=0, i;
	for (i=0; i<liste.length; i++)
	    { try
		{ entier=Integer.parseInt(liste[i]);
		// convertion chaîne en valeur entière
		somme += entier; nbNotes++;
		}
	    catch (NumberFormatException e)
		{System.out.println("note:"+(i+1)+" invalide");} 
	    }
	return somme/nbNotes;
    }
    public static void main(String[]argv)
    { System.out.println("moyenne "+moyenne(argv));}
}
