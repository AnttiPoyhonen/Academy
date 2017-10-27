package harjoitukset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class TiedostonSanat {
    
    public static void sanoja (String polku) {
                
        
        // open the file
        
        BufferedReader br;
        
        try {
            br = new BufferedReader(new FileReader(polku));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file! Quitting...");
            return;
        }
        
        
        // read the file to a StringBuilder
        
        StringBuilder tiedosto = new StringBuilder();
        
        try {
            while(br.ready()) {
                tiedosto.append(br.readLine());
            }
        } catch (IOException ex) {
            System.out.println("Could not read the file! Quitting...");
            return;
        }
        
        
        // words to a String array        
        String [] sanat = tiedosto.toString().split("[^A-Za-z0-9]");
        
        // sort words according to word length
        Arrays.sort(sanat, new comparePituus());
                
        
        // count avg and take away all "" items by adding non-empty to another array
       
        String [] sanat2 = new String[sanat.length];
        int counter = 0;
        
        double sum = 0, avg;
        
        for (int i = 0; i < sanat.length; i++) {
            if (!("".equals(sanat[i]))) {
                sanat2[counter] = sanat[i];
                counter++;
                
                sum += sanat[i].length();
            }
        }
        
        avg = sum / sanat2.length;
        
        
        // print info
        System.out.println("Shortest word is -- " + sanat2[0]);
        System.out.println("Longest word is -- " + sanat[sanat2.length - 1]);
        System.out.println("There are -- " + sanat2.length + " -- words in the file.");
        
        
        // count and print avg, if divide by 0, return because no elements
        
        if (sanat2.length == 0) {
            System.out.println("The average length of the words is 0.");
            return;
        }
        
        System.out.println("The average length of the words in the file is -- " + avg);
        
    }

    // comparator override to compare the lengths
    private static class comparePituus implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }
           
}
