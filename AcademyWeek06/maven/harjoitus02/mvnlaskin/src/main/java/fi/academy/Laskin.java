package fi.academy;

import java.util.Scanner;

public class Laskin {

    int laskeYhteen(int...luvut) {
        int tulos = 0;
        for (int i : luvut) {
            tulos += i;
        }
        return tulos;
    }

    /*
    static int laskeYhteen() {
	
	Scanner in = new Scanner (System.in);

	System.out.print("Give the first int: ");
	int luku1 = Integer.parseInt(in.nextLine());

	System.out.print("Give the second int: ");
	int luku2 = Integer.parseInt(in.nextLine());

	return luku1 + luku2;
	*/

    double laskeYhteen(double...luvut) {
        
        double tulos = 0;
        
        for (double d : luvut) {
            tulos += d;
        }
        
        return tulos;
        
    }

}