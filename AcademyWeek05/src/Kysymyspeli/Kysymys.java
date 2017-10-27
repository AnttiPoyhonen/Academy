package Kysymyspeli;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Kysymys {

    // tyyppiid: 1(Java), 2(Java OCJP), 3(SCRUM)
    // kategoriaid: multiplechoice, multiplechoice multiple correct, true/false, text input)
    private int id, tyyppiid, kategoriaid;
    private String teksti;
    private Map<Integer, Vaihtoehto> vaihtoehdot = new HashMap<>();
    
    public Kysymys(int id, int tyyppiid, int kategoriaid, String teksti) throws SQLException {
        this.id = id;
        this.tyyppiid = tyyppiid;
        this.kategoriaid = kategoriaid;
        this.teksti = teksti;
        this.vaihtoehdot = Connect.haeVaihtoehdot(id);
    }
    
    public Kysymys(int tyyppiid, int kategoriaid, String teksti) throws SQLException {
        this.tyyppiid = tyyppiid;
        this.kategoriaid = kategoriaid;
        this.teksti = teksti;
    }
        
    public void setVaihtoehdot(Map<Integer, Vaihtoehto> vaihtoehdot) {
        this.vaihtoehdot = vaihtoehdot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeid() {
        return tyyppiid;
    }

    public void setTypeid(int tyyppiid) {
        this.tyyppiid = tyyppiid;
    }

    public int getCategoryid() {
        return kategoriaid;
    }

    public void setCategoryid(int kategoriaid) {
        this.kategoriaid = kategoriaid;
    }

    public String getText() {
        return teksti;
    }

    public void setText(String teksti) {
        this.teksti = teksti;
    }

    public Map<Integer, Vaihtoehto> getVaihtoehdot() {
        return vaihtoehdot;
    }

    @Override
    public String toString() {
        return teksti;
    }
    
    
    
    static void lisääKysymys(int tyyppi, Scanner in) {
        
        System.out.println("\n   What is the question text?");
        
        System.out.print("   ");
        String teksti = in.nextLine();
        
        try {

            Kysymys k = new Kysymys (tyyppi, 1, teksti);

            int id = Connect.lisääKantaan(k);

            Map<Integer, Vaihtoehto> vaihtoehdot = Vaihtoehto.lisääVaihtoehdot(id, in);

            k.setVaihtoehdot(vaihtoehdot);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
    }
    
    
}
