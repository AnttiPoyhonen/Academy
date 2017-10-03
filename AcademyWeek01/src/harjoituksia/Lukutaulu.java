package harjoituksia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lukutaulu {

    static List<Integer> taulukko = new ArrayList<Integer>();
    private static int taulukonKoko = 30;
    private static int maksimi = 100;
    
    static void run(){
        
        try(Scanner in = new Scanner(System.in)){
            luoTaulu();
            laskeTiedot();
        } catch (Throwable t) {
            System.out.println(t);
        }      
    }
    
    private static void luoTaulu() {
        
        for(int i = 0; i < taulukonKoko; i++){
            taulukko.add((int) (Math.random()*maksimi + 1));
            // System.out.println(taulukko.get(i));
        }
        
    }
                
            
    private static void laskeTiedot() {
        int pienin, suurin, summa;
        double ka;
        
        Collections.sort(taulukko);
        pienin = taulukko.get(0);
        
        Collections.reverse(taulukko);
        suurin = taulukko.get(0);
        
        summa = 0;
        
        for(int i = 0; i < taulukko.size(); i++) {
            summa += taulukko.get(i);
        }
        
        ka = (double) summa / taulukko.size();
        
        System.out.println("Statistiikkaa luvuista:");
        System.out.println(taulukko.size() + " arvottua lukua, väliltä 1-" + maksimi);
        System.out.println("Pienin luku: " + pienin);
        System.out.println("Suurin luku: " + suurin);
        System.out.println("Lukujen summa: " + summa);
        System.out.println("Lukujen keskiarvo: " + ka);
                
    }
}
