package harjoitukset;

// Object Relational Mapping = ORM

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ORM01 {

    private static List<Oppilas> oppilaat = null;
    public static List<Koulu> koulut = null;
    
    public static void main(String[] args) {
                
        String url = "jdbc:mysql://localhost:3306/jdbcharjoitus?useSSL=false";
        String u = "point";
        String p = "f4nt4stic";
        
        try (Connection con = DriverManager.getConnection(url, u, p)){

            System.out.println("Connected to '" + url + "' succesfully.\n");

            try {
                
                koulut = Koulu.haekoulut(con);
                print(koulut);
                
                oppilaat = haeoppilaat(con);
                print(oppilaat);
                
//                // try to add an existing oppilas again to db
//                oppilaat.get(0).lisaaKantaan(con);
//                oppilaat = haeoppilaat(con);
//                print(oppilaat);
                
//                // add Oppilas with all fields manually to db
//                Oppilas a = new Oppilas(5, "Michael", "Keaney", new Date(1962, 4, 3), 3);
//                a.lisaaKantaan(con);
//                oppilaat = haeoppilaat(con);
//                print(oppilaat);
//                
//                // add Oppilas with automatic id and null kouluid to db
//                Oppilas b = new Oppilas("Aila", "Laine", new Date(1934, 6, 24));
//                b.lisaaKantaan(con);
//                oppilaat = haeoppilaat(con);
//                print(oppilaat);
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private static List<Oppilas> haeoppilaat(Connection con) throws SQLException {
        
        String sql = "select * from oppilas";
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        List<Oppilas> list = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            
            Koulu koulu = null;
            
            for (Koulu k : koulut) {
                if (rs.getInt("kouluid") == k.getId()) koulu = k;
            }
                    
            Oppilas op = new Oppilas(
                    rs.getInt("id"),
                    rs.getString("etunimi"),
                    rs.getString("sukunimi"),
                    rs.getDate("syntymäaika"),
                    koulu);
            
            if (!list.contains(op)) list.add(op);
        }
        
        return list;
        
    }

    private static void print(List<?> list) {
        
        if (list == null || list.isEmpty()) return;
        
        System.out.println("LIST:");
        
        for (Iterator<?> i = list.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
        
        System.out.println("");
        
    }
    
}
