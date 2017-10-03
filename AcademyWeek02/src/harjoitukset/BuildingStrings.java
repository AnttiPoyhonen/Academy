package harjoitukset;

public class BuildingStrings {

    static String[] paivat = {"maanantai", "tiistai", "keskiviikko",
        "torstai", "perjantai", "lauantai", "sunnuntai"};

    public static void main(String[] args) {

        StringBuilder sbPaivat = new StringBuilder();

        for (String s : paivat) {
                        
            sbPaivat.append(s.substring(0,1).toUpperCase());
            sbPaivat.append(s.substring(1, s.length()-1));
            sbPaivat.append("\n");
            
            /* OR
            char[] paiva = s.toCharArray();
            String sP = "";
            
            for (int i = 0; i < paiva.length; i++) {
                if(i == 0) {
                    sP += String.valueOf(paiva[i]).toUpperCase();
                } else {
                    sP += String.valueOf(paiva[i]);
                }
            }
                        
            sbPaivat.append(sP);
            sbPaivat.append("\n");
            */
        }

        System.out.println(sbPaivat.toString());
    }

}
