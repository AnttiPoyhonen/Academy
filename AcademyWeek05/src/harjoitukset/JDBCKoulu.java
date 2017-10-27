package harjoitukset;

import java.sql.*;
import java.util.Random;

public class JDBCKoulu {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbcharjoitus?useSSL=false";
        String u = "point";
        String p = "f4nt4stic";

        try (Connection con = DriverManager.getConnection(url, u, p)){

            System.out.println("Connected to con succesfully.\n");

            Statement st = con.createStatement();

            String q = "";
            String up = "";

            try {
                run(q, up, st, con);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {

            System.out.println("SQL DB con not found.");
            System.out.println(e.getMessage());

        }

    }

    private static void run(String q, String up, Statement st, Connection con) throws SQLException {
        
        /*

        query =
                "select oppilas.etunimi, oppilas.sukunimi, "
                        + "floor(DATEDIFF(0 + curdate(), oppilas.syntymäaika) / 365.25)  as ikä, "
                        + "koulu.kaupunki, koulu.nimi  as ensimmäinen_koulu "
                        + "from oppilas join koulu on oppilas.kouluid = koulu.id";

        ResultSet rs = st.executeQuery(query + ";");
        
        print(rs);
        
        report(query);

        --------

        update =
                "update oppilas set kouluid=3 where etunimi='Antti' or etunimi='Mirka'";
        
        st.executeUpdate(update + ";");

        report(update);

        */
        
        PreparedStatement ps = null;

        // q = "";
        // query(q, st);

        // up = "";
        // update(up, st);

        // addOppilas("Tommi", "Teräsvirta", "1970-08-14", ps, con);
        
        // lisaaKoulut(ps, con);
        
        String etunimi = "Antti%";
        etsiNimenMukaan(etunimi, ps, con);

    }
    
    
    private static void etsiNimenMukaan(String etunimi, PreparedStatement ps, Connection con) throws SQLException {
        
        // query for students with the name as a parameter
        String s = "select * from oppilas where etunimi like ?;";
        
        // prepare the original sql before ? insertion
        ps = con.prepareStatement(s);
        
        String nimi = etunimi;
        
        if (etunimi.charAt(etunimi.length()-1) == '%') {nimi = etunimi;} else {nimi = etunimi + "%";}
        
        ps.setString(1, nimi);
        ResultSet rs = ps.executeQuery();
        
        print(rs);
        
        // layout and reporting on the function
        report(s);
        
    }
    
    // add kouluID (random) to all with null kouluid
    private static void lisaaKoulut(PreparedStatement ps, Connection con) throws SQLException {
        
        // sql to update the first record with null kouluid with a parameter
        String s = "update oppilas set kouluid = ? where kouluid is null limit 1;";

        int[] i = {1, 2, 3};
        Random rand = new Random();
        
        // prepare the original sql before ? insertion
        ps = con.prepareStatement(s);
        
        // check that there are any null kouluid records
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select oppilas.id from oppilas where kouluid is null");
        
        // add random kouluID until a null kouluid query turns up empty
        while (rs.next()) {
            
            // insert a random 0-2 number to the first parameter of ps
            ps.setInt(1, i[rand.nextInt(3)]);
            
            // launch update of the first record
            ps.executeUpdate();
            
            // requery to check if there are more null kouluid records
            rs = st.executeQuery("select * from oppilas where kouluid is null");
        }
        
        
        // layout and reporting on the function
        report(s);
    }

    private static void addOppilas (String etunimi, String sukunimi, String syntymäaika, PreparedStatement ps, Connection con) throws SQLException {

        String s = "insert oppilas (etunimi, sukunimi, syntymäaika) values (?, ?, ?);";

        ps = con.prepareStatement(s);
        ps.setString(1, etunimi);
        ps.setString(2, sukunimi);
        ps.setString(3, syntymäaika);

        ps.executeUpdate();

        
        // layout and reporting on the function
        report(s);

    }

    private static void update(String s, Statement st) throws SQLException {

        if (s.charAt(s.length()-1) == ';') st.executeUpdate(s); else st.executeUpdate(s + ";");

        report(s);

    }

    private static void query(String s, Statement st) throws SQLException {

        ResultSet rs;

        if (s.charAt(s.length()-1) == ';') rs = st.executeQuery(s); else rs = st.executeQuery(s + ";");

        print(rs);
    }

    private static void report(String s) {
        
        System.out.println("");

        String[] sanat = s.split(" ");

        char eka = sanat[0].charAt(0);
        char korvaava = Character.toUpperCase(eka);
        String toiminto = sanat[0].replace(eka, korvaava);

        System.out.println(toiminto + " successful!");
        
    }

    private static void print(ResultSet rs) throws SQLException {
        
        if (!rs.next()) {
            System.out.println("\nNothing to print!");
            return;
        }
        
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnLabel(i).toUpperCase() + "\t");
        }
        System.out.println("");

        // prepare for a print through looping, return to beginning of rs
        rs.beforeFirst();
        
        if (rs != null) {
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }
        }
        
    }



}
