package fi.academy.tiistai;

import java.util.Scanner;

public class Binaarilaskin {
	public static void main(String[] args) {
		run();
	}
	public static void run() {
		long binaari1, binaari2;
		long sum = 0;
		// halutaan sulkea Scanner, joten try with resources
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Anna ensimmäinen binaarinumero: ");
			// Luetaan Stringinä, ja parseroidaan Long-luokalla
			binaari1 = Long.parseUnsignedLong(in.next(), 2);
			System.out.print("Anna toinen binaarinumero: ");
			// käytetään esimerkin vuoksi toista tapaa, eli Scannerin valmista parserointimetodia
			binaari2 = in.nextLong(2);
		} catch (Exception e) {
			System.err.println("Ongelma lukemisessa: " + e.getMessage());
			System.err.println("Lopetetaan..");
			return;
		}
		sum = binaari1 + binaari2;
		System.out.print("Binaarilukujen summa: ");
		System.out.println(Long.toBinaryString(sum));
	}
}