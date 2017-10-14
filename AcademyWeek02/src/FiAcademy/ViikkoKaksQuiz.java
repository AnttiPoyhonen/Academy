public class ViikkoKaksQuiz {

    private static StringBuilder sb;

    public static void main(String[] args) {
        sb = new StringBuilder();
        boolean b = false;
        String s = "2";
        int i = 2;
        Koira k = new Koira();
        sb.append(b).append(s).append(i).append(k);
        System.out.println(sb);
    }
}

class Koira {
}
