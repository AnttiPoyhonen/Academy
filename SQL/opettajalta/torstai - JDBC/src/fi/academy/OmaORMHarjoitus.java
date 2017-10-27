package fi.academy;

import fi.academy.data.Koulu;
import fi.academy.data.Oppilas;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmaORMHarjoitus {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/koululaiset?useSSL=false";
        try(Connection con = DriverManager.getConnection(url, "root", "adminadmin")) {
            List<Oppilas> lista = oppilaat(con);
            for(Oppilas o : lista) {
                System.out.println(o);
                if(o.getEtunimi().equalsIgnoreCase("riku")) {
                    o.setEtunimi("Diku");
                    o.paivitaKantaan(con);
                }
            }
            System.out.println("-------------------------");
            for(Oppilas o : oppilaat(con)) {
                System.out.println(o);
            }
            System.out.println("-------------------------");
            Oppilas oppilas = new Oppilas("Orm", "Onnekas", new Date());
            oppilas.lisaaKantaan(con);
            System.out.println(oppilas);
            System.out.println("-------------------------");
            for(Oppilas o : oppilaat(con)) {
                System.out.println(o);
            }

            Koulu k = new Koulu("Elämämkoulu", "Katu");
            oppilas.setKoulu(k);
            oppilas.paivitaKantaan(con);
            System.out.println("-------------------------");
            for(Oppilas o : oppilaat(con)) {
                System.out.println(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Oppilas> oppilaat(Connection con) throws SQLException {
        ArrayList<Oppilas> oppilaat = new ArrayList<>();
        String sql = "SELECT * FROM Oppilas";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Oppilas o = new Oppilas();
            o.kaivaTiedot(con, rs);
            oppilaat.add(o);
        }
        return oppilaat;
    }
}
