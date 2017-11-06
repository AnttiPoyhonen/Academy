package Harjoitukset;

public class generationsrules {
    
    public static void main(String[] args) {
        
        String orig = "HHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHUNTTGTGTGTGTGGNRHTGTGGNRHTGTGGNRHTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNORHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHRHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGATGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHERHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTG";
        String result = "", mid = "", editable;
        
        String[] chars = orig.split("[AEIOU]");
        
        int counter = 1;
        
        for (String s : chars) {
            System.out.println(s);
                                                
            for (int i = 0; i < 6; i++) {
                if (i == 0) editable = s;
                else editable = mid;
                
                mid = "";
                
                while (!("".equals(editable))) {
                    String duo = editable.substring(0, 2);
                    editable = editable.replaceFirst(duo, "");
                    mid += decode(duo);
                }
                
                System.out.println(counter + " - " + i + ": " + mid);
                
            }
            
            result += mid + " ";
            
            System.out.println("");
            counter++;
        }
        
        System.out.println(result);
        
        /*
        
        HHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRH
                U
                NTTGTGTGTGTGGNRHTGTGGNRHTGTGGNRHTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGN
                        O
                        RHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHRHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTG
                                A
                                TGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRH
                                        E
                                        RHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTG
        
        */
        
        
    }
    
    private static String decode(String duo) {
        
        String decoded;
        
        switch(duo) {
            case "GN":
                decoded = "G"; break;
            case "NT":
                decoded = "R"; break;
            case "RH":
                decoded = "N"; break;
            case "TG":
                decoded = "H"; break;
            case "HH":
                decoded = "T"; break;
            default:
                decoded = "!"; break;
        }
        
        return decoded;
    }

}
