package demot.oliot;

public class ElainTesti {
    public static void main(String[] args) {
        Kissa katti = new Kissa(-1);
        System.out.println(katti.getIkä());
        katti.setNimi("Pekka");
        System.out.println(katti.toString());
        katti.setIkä(-1);

    }
}
