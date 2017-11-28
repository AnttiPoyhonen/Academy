package fi.academy.saikeet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Runnable r = new Suorittaja(i, 40);
            ex.execute(r);
        }
        ex.shutdown();
        System.out.println("* main: shutdown tehty");
    }
}

class Suorittaja implements Runnable {
    private int suurin;
    private int id;

    public Suorittaja( int id, int suurin) {
        this.suurin = suurin;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 2; i <= suurin; i++) {
            System.out.println("Runnable " + id + " *** " + i + ": " + rekursiinvinenfibonacci(i));
        }

    }

    public long rekursiinvinenfibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return rekursiinvinenfibonacci(n-1) + rekursiinvinenfibonacci(n-2);
    }

}