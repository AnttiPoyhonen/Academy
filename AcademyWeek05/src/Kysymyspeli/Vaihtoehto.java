package Kysymyspeli;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Vaihtoehto {

    int id, kysymysid;
    boolean oikeavaihtoehto;
    String teksti;

    @Override
    public String toString() {
        return teksti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKysymysid() {
        return kysymysid;
    }

    public void setKysymysid(int kysymysid) {
        this.kysymysid = kysymysid;
    }

    public boolean isCorrect() {
        return oikeavaihtoehto;
    }

    public void setCorrect(boolean oikeavaihtoehto) {
        this.oikeavaihtoehto = oikeavaihtoehto;
    }

    public String getText() {
        return teksti;
    }

    public void setText(String teksti) {
        this.teksti = teksti;
    }
    
    public Vaihtoehto(int kysymysid, boolean oikeavaihtoehto, String teksti) {
        this.kysymysid = kysymysid;
        this.oikeavaihtoehto = oikeavaihtoehto;
        this.teksti = teksti;
    }

    public Vaihtoehto(int id, int kysymysid, boolean oikeavaihtoehto, String teksti) {
        this.id = id;
        this.kysymysid = kysymysid;
        this.oikeavaihtoehto = oikeavaihtoehto;
        this.teksti = teksti;
    }
    
    
    public static Map<Integer, Vaihtoehto> lisääVaihtoehdot(int id, Scanner in) throws SQLException {
        
        Map<Integer, Vaihtoehto> vaihtoehdot = new HashMap<>();
        List<Vaihtoehto> list = new ArrayList<>();
        
        outer:
        for(int i = 0;;i++) {
            
            list.add(kysyVaihtoehto(in, i, id));
            
            if (i > 0) {
                System.out.println("\n   Do you want to add another WRONG answer? (y/n)");
                System.out.print("   ");
                String valinta = in.nextLine();
                if("y".equalsIgnoreCase(valinta)) continue;
                else break outer;
            }
            
        }
        
        
        Collections.shuffle(list);
        
        for (int j = 1; j <= list.size(); j++) {
            vaihtoehdot.put(j, list.get((j-1)));
        }
        
        return vaihtoehdot;
        
    }
        
    
    private static Vaihtoehto kysyVaihtoehto(Scanner in, int i, int id) throws SQLException {
        
            if (i == 0) System.out.println("\n   What is the text for a RIGHT answer?");
            else System.out.println("\n   What is the text for a WRONG answer?");
            
            String teksti = "";
            
            for(;;) {
                
                System.out.print("   ");
                teksti = in.nextLine();
                
                if ("".equals(teksti)) {
                    System.out.print("   ");
                    System.out.println("You entered nothing; enter some text for the answer.");
                    continue;
                }
                
                break;
            }
            
            boolean oikein;
            
            if (i == 0) oikein = true;
            else oikein = false;
            
            Vaihtoehto v = new Vaihtoehto(
                    id,
                    oikein,
                    teksti
            );
            
            Connect.lisääKantaan (v);
            
            return v;
    }
    
}
