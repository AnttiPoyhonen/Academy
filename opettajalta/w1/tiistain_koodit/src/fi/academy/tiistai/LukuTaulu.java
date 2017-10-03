package fi.academy.tiistai;

import java.util.Arrays;
import java.util.function.Supplier;

public class LukuTaulu {
	private final static boolean TULOSTA_LUVUT = false;
	private final static int LUKUJA = 100; 
	private final static int MAX_LUKU = 1000;
	
	public static void main(String[] args) {
		int [] arvotutLuvut = arvoluvut();
		laskeJaTulosta(arvotutLuvut);
		streamAPInTapa(arvotutLuvut);
	}
	
	private static int[] arvoluvut() {
		int [] luvut = new int[LUKUJA];
		for (int i = 0; i < luvut.length; i++) {
			luvut[i] = (int)(Math.random()*MAX_LUKU);
		}
		return luvut;
	}
	
	private static void laskeJaTulosta(int[]luvut) {
		int pienin, suurin; 
		long summa;
		summa = pienin = suurin = luvut[0];
		double ka;
		for (int i = 1; i < luvut.length; i++) {
			if (luvut[i]<pienin) pienin = luvut[i];
			if (luvut[i]>suurin) suurin = luvut[i];
			summa += luvut[i];
		}
		ka = summa / (double)luvut.length;
		tulosta(pienin, suurin, summa, ka);
		tulostaLuvut(luvut);
	}
	
	private static void tulosta(int pienin, int suurin, long summa, double ka) {
		System.out.println("Statistiikkaa luvuista:");
		System.out.println(String.format("\tpienin: %d\n\tsuurin: %d\n\tsumma: %d\n\tkeskiarvo: %.2f",
				pienin, suurin, summa, ka));
	}
	
	private static void tulostaLuvut(int[]luvut) {
		if (!TULOSTA_LUVUT) return;
		for (int i = 0; i < luvut.length-1; i++) {
			System.out.print(luvut[i]+", ");
		}
		System.out.println(luvut[luvut.length-1]);
	}
	
	// Esimerkkiä tulevaisuutta varten, miten tämä hoituisi Java 8:n Stream APIn kanssa
	// Eli tekee saman kuin yllä perinteisen taulukon kanssa. Huom. koska esimerkki, niin
	// tässä käytetty muutamaa vaihtoehtoista tapaa saman asian tekemiseen.
	private static void streamAPInTapa(int[]luvut) {
		int pienin, suurin; 
		long summa;
		double ka;
		// "Yksinkertainen" tapa etsiä suurin, käyttäen IntStream-tyypin max() metodia 
		suurin = Arrays			// Apuluokka taulukoille
				.stream(luvut)  // IntStream
				.max()			// OptionalInt
				.getAsInt(); 	// NoSuchElementException jos ei lukuja
		// Jos oman poikkeuksen haluaa heittää
		pienin = Arrays.stream(luvut).min().orElseThrow(new Supplier<RuntimeException>() {
			@Override
			public RuntimeException get() {
				return new RuntimeException("Tyhjä taulukko!");
			}
		});
		summa = Arrays.stream(luvut).sum();
		// Keskiarvoin voisi toki laskea summa / lkm...
		ka = Arrays.stream(luvut).average().getAsDouble();
		// Tulostus samalla metodilla kuin taulukollakin
		tulosta(pienin, suurin, summa, ka);
		tulostaLuvut(luvut);
	}

}
