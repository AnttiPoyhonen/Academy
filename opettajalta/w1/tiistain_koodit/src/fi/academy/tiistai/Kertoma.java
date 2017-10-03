package fi.academy.tiistai;

import java.math.BigInteger;
import java.util.Scanner;

public class Kertoma {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		long luku;
		// halutaan sulkea Scanner, joten try with resources
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Anna luku, jolle kertoma lasketaan: ");
			luku = in.nextLong();
		} catch (Exception e) {
			System.err.println("Ongelma lukemisessa: " + e.getMessage());
			System.err.println("Lopetetaan..");
			return;
		}
		System.out.println(String.format("long: %d! on: %d", luku, kertoma(luku)));
		lisätehtäväLaskeJaTulosta(luku);
	}

	protected static long kertoma(long luku) {
		long tulos=1;
		for(int i = 2 ; i <= luku ; ++i) {
			tulos *= i;
		}
		return tulos;
	}
	
	protected static void lisätehtäväLaskeJaTulosta(long luku) {
		BigInteger tulos = BigInteger.valueOf(luku);
		for(long l = luku - 1 ; l > 1 ; --l ) {
			tulos = tulos.multiply(BigInteger.valueOf(l));
		}
		System.out.println(String.format("BigInteger: %d! on: %s", luku, tulos.toString()));
	}
}
