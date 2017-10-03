package harjoituksia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sanalaskuri {

    public static void main (String [] args) {
        
        String tiedosto;
        
        if(args.length > 0) {
            tiedosto = args[0];
        } else {
            System.out.println("Käytetään oletustiedostona .java-tiedostoa.");
            tiedosto = "src/harjoituksia/Sanalaskuri.java";
        }
        
        Sanalaskuri sl = new Sanalaskuri();
        sl.kasitteleTiedosto(tiedosto);
        
    }
    
    private void kasitteleTiedosto(String nimi) {
        
        int sanat = 0, merkit = 0, rivit = 0;
        
        try (BufferedReader lukija = new BufferedReader(new FileReader(nimi))) {
            
            for(String rivi = lukija.readLine() ; rivi != null; rivi = lukija.readLine()) {
                
                rivit++; // rivit = rivit + 1; rivit += 1
                merkit += rivi.length() + 1;
                
                String [] sanatRivilla = rivi.split("\\W");                
                int sanoja = sanatRivilla.length;
                sanat += sanoja;
                
            }
            
            System.out.println("\nTiedosto: " + nimi);
            System.out.println("\nrivit\t" + rivit + "\nsanat\t" + sanat + "\nmerkit\t" + merkit + "\n");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();            
        }
    }
    
}
