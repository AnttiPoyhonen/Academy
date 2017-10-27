package harjoitukset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Koulu {
    
    public static List<Koulu> koulut = new ArrayList<>();
    
    public static List<Koulu> haekoulut (Connection con) throws SQLException {
        
        String sql = "select * from koulu";
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
                
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            
            Koulu k = new Koulu(
                    rs.getInt("id"),
                    rs.getString("nimi"),
                    rs.getString("kaupunki"));
            
            if (!koulut.contains(k)) koulut.add(k);
        }
        
        return koulut;
        
    }

    void lisaaKantaan(Connection con) throws SQLException {
        
        String sql;
                
        if(isKannassa(con)) {
            System.out.println("There was already a school with that ID; did not add anything.\n");
            return;
        }

        sql = "insert koulu values (" + id + ", ?, ?)";
                
        // check for the string
        // System.out.println(sql);
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, id);
        ps.setString(2, nimi);
        ps.setString(3, kaupunki);
                
        if (ps.executeUpdate() == 1) System.out.println("Insert successful.\n");
        
    }

    public boolean isKannassa(Connection con) throws SQLException {
        
        String sql = "select * from koulu where id = ?";
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, id);
                
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) return true;
        else return false; 
        
    }

    private int id;
    private String nimi, kaupunki;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public Koulu(int id, String nimi, String kaupunki) {
        this.id = id;
        this.nimi = nimi;
        this.kaupunki = kaupunki;
    }

    @Override
    public String toString() {
        return "(ID" + id + ") " + nimi + ", " + kaupunki;
    }
    
}
