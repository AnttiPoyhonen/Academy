package harjoitukset;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumbers_Fibonacci {

    public static void main(String[] args) {
        
        BigNumbers_Fibonacci fib = new BigNumbers_Fibonacci();
        
        for (int i = 1; i < 93; i++) {
            System.out.println(fib.binetfibonacci(i));
        }
        
        for (int i = 93; i < 99; i++) {
            System.out.println(i + ": " + fib.binetfibonacci2(i));
        }
        
        // i = 93 gives the max value with the long version
        System.out.println("\nPieni muistutus:");
        System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
    }

    public long binetfibonacci(int n) {
        
        /*
        if (n <= 1) {
            return n;
        } else {
            return rekursiinvinenfibonacci(n - 1) + rekursiinvinenfibonacci(n - 2);
        }
        */
        
        double sqrt5 = Math.sqrt(5.0);
        double phi = (1 + sqrt5) / 2;
        
        System.out.print(n + ": (" + Math.pow(phi, n) + " - " + Math.pow(-phi, -n) + ") / sqrt5 : ");
        
        return (long) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / sqrt5);
    }

    public BigInteger binetfibonacci2(int n) {
        
        double sqrt5 = Math.sqrt(5.0);
        double phi = (1 + sqrt5) / 2;
        double minPhi = -phi;
                
        // as BI: (long) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / sqrt5);
        
        BigDecimal phiOne = BigDecimal.valueOf(phi);
        BigDecimal phiTwo = BigDecimal.valueOf(minPhi);
        
        // form the first positive exponent section
        BigDecimal one = phiOne.pow(n);
        BigDecimal valueOne = BigDecimal.valueOf(1);
        
        // negative power from BigDecimal! TODO have to include the negative exponent
        BigDecimal twoOne = phiTwo.pow(n);
        BigDecimal twoTwo = valueOne.divide(twoOne);
        
        // divide subtracted with sqrt5
        BigDecimal toDiv = one.subtract(twoTwo);
        BigDecimal div = toDiv.divide(BigDecimal.valueOf(sqrt5));
        
        return div.toBigInteger();
    }
}
