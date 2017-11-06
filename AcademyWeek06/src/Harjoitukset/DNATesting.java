package Harjoitukset;

public class DNATesting {

    public static void main(String[] args) {

         String toDecode = "TAC GAT GCA TGG CTA CYZ ZWX VAV YZT TAG ACT AGC ACT CGA";
        // String toDecode = "CYZ ZWX VAV YZT";

        String result = "";
        
        String editable = toDecode
                .replace("T", "")
                .replace("A", "")
                .replace("C", "")
                .replace("G", "")
                .replace(" ", "")
                .replace("V", "55")
                .replace("W", "4E")
                .replace("X", "46")
                .replace("Y", "52")
                .replace("Z", "45");
        
        // TAC GAT GCA TGG CTA C 5245454E46 A 55555245 T TAG ACT AGC ACT CGA

        while (!("".equals(editable))) {
            String hex = editable.substring(0, 2);
            editable = editable.replaceFirst(hex, "");
            result += (char)Integer.parseInt(hex, 16);
        }
        
        // REENFUURE
        
        System.out.println(result);
        
    }

}
