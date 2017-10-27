package harjoitukset;

public class KonttiTranslate {

    public String kontiksi (String text) {
        
        String [] sanat = text.split(" ");
        StringBuilder print = new StringBuilder();
        
        for (String s : sanat) {
            s = s.replace("^[A-Za-z0-9]", "");
            
            char first = s.charAt(0);
            String firsts = "";
            String seconds = "";
            
            if (first == 'a' || 
                    first == 'e' ||
                    first == 'i' ||
                    first == 'o' ||
                    first == 'u' ||
                    first == 'y') {
                firsts = s.substring(0, 1);
                seconds = s.substring(1);
            } else {
                firsts = s.substring(0, 2);
                seconds = s.substring(2);
            }
            
            print.append("ko" + seconds + " " + firsts + "ntti ");
        }
        
        return print.toString();
        
    }
    
    public String suomeksi (String text) {
        
        StringBuilder print = new StringBuilder();
        String [] sanat = text.split(" ");
        
        for (int i = 0; i < sanat.length; i++) {
            
            if ("ko".equals(sanat[i].substring(0, 2))) {
                                
                String firsts = "";
                String seconds = sanat[i].substring(2);
                
                String s2 = sanat[i+1];
                
                char first = s2.charAt(0);
                
                if (first == 'a' || 
                        first == 'e' ||
                        first == 'i' ||
                        first == 'o' ||
                        first == 'u' ||
                        first == 'y') {
                    firsts = s2.substring(0, 1);
                } else {
                    firsts = s2.substring(0, 2);
                }
                
                 print.append(firsts + seconds + " ");
                
                i++;
                
            }
                        
        }
        
        return print.toString();
        
    }
    
}
