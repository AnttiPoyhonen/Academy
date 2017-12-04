package Academy;


public class SBtest {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = sb1;
        sb2.append("B");
        System.out.println(sb1.append(sb2));
    }
}
