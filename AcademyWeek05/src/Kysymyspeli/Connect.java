package Kysymyspeli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Connect {
    
    private static String url = "jdbc:mysql://localhost:3306/kysymyspeli?useSSL=false";
    private static String u = "point";
    private static String p = "f4nt4stic";
    
    public static Connection con = null;


    static List<Kysymys> haeKysymykset(int tyyppi) throws SQLException {
        
        List<Kysymys> list = new ArrayList<>();
        
        try {
            con = DriverManager.getConnection(url, u, p);
        } catch (SQLException ex) {
            System.out.print("   ");
            System.out.println("Could not connect to " + url);
            return list;
        }
        
        String sql = "select * from kysymys where tyyppiid = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, tyyppi);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            Kysymys k = new Kysymys(
                    rs.getInt("id"),
                    rs.getInt("tyyppiid"),
                    rs.getInt("kategoriaid"),
                    rs.getString("teksti")
            );
            
            list.add(k);
        }
        
        Collections.shuffle(list);
        
        return list;
        
    }
    
    
    public static Map<Integer, Vaihtoehto> haeVaihtoehdot(int id) throws SQLException {
        
        Map<Integer, Vaihtoehto> map = new HashMap<>();
        List<Vaihtoehto> list = new ArrayList<>();
        
        try {
            con = DriverManager.getConnection(url, u, p);
        } catch (SQLException ex) {
            System.out.print("   ");
            System.out.println("Could not connect to " + url);
            return map;
        }
        
        String sql = "select * from vaihtoehto where kysymysid = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            Vaihtoehto v = new Vaihtoehto(
                    rs.getInt("id"),
                    rs.getInt("kysymysid"),
                    rs.getBoolean("oikeavaihtoehto"),
                    rs.getString("teksti")
            );
            
            list.add(v);
        }
        
        Collections.shuffle(list);
        
        int laskuri = 1;
        
        for (Vaihtoehto v : list) {
            map.put(laskuri, v);
            laskuri++;
        }
        
        return map;
        
    }
    
    
    public static int lisääKantaan(Kysymys k) throws SQLException {
        
        try {
            con = DriverManager.getConnection(url, u, p);
        } catch (SQLException ex) {
            System.out.print("   ");
            System.out.println("Could not connect to " + url);
        }
        
        String sql = "insert kysymys (tyyppiid, kategoriaid, teksti) values (?, ?, ?);";
        
        PreparedStatement ps = con.prepareStatement(sql, new String[] {"id"});
        ps.setInt(1, k.getTypeid());
        ps.setInt(2, k.getCategoryid());
        ps.setString(3, k.getText());
        
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        
        while(rs.next()) {
            return rs.getInt(1);
        }
        
        return 0;
                
    }
    
    
    public static void lisääKantaan(Vaihtoehto v) throws SQLException {
        
        try {
            con = DriverManager.getConnection(url, u, p);
        } catch (SQLException ex) {
            System.out.print("   ");
            System.out.println("Could not connect to " + url);
        }
        
        String sql = "insert vaihtoehto (kysymysid, oikeavaihtoehto, teksti) values (?, ?, ?);";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, v.getKysymysid());
        ps.setBoolean(2, v.isCorrect());
        ps.setString(3, v.getText());
        
        ps.executeUpdate();
        
    }

}
