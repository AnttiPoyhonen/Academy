package harjoituksia;

import java.util.Scanner;

// TODO, suuremmilla luvuilla kertominen, esim 52
public class Kertoma {
    
    public static long kertoma (long a){
        
        long tulos = 1;
        
        for(int i=1; i<=a; i++){
            tulos *= i;
        }
        
        return tulos;
    }
    
    public static void main (String[] Args) {
        
        long luku;
        
        // try with resources
        
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Anna luku, jolle kertoma lasketaan: ");
            luku = in.nextLong();            
        } catch (Exception e){
                System.err.println("Ongelma lukemisessa " + e.getMessage());
                System.err.println("Lopetetaan..");
                return;
        }
        System.out.println(String.format("%d! on: %d", luku, kertoma(luku)));
       
        
        /*
        Scanner in = new Scanner(System.in);
        System.out.print("Anna luku, jolle kertoma lasketaan: ");
        luku = in.nextLong();
        System.out.println(String.format("%d! on: %d", luku, kertoma(luku)));
*/
    }
}
