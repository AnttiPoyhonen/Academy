package fi.academy;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class JdbcKoulu {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/koululaiset?useSSL=false";
        try(Connection con = DriverManager.getConnection(url, "root", "adminadmin")) {
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM Oppilas");
            stmt.execute("DELETE FROM Koulu");
            stmt.close();
            System.out.println("Oppilas tyhjennetty");
            luoOppilaatFirstClass(con);
            System.out.println("uudet oppilaat luotu");
            listaaKaikkiOppilaat(con);
            luoKoulut(con);
            lisaaOppilailleKouluja(con);
            System.out.println("\n---------------------\n");
            listaaOppilaatKouluineen(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lisaaOppilailleKouluja(Connection con) throws SQLException {
        int minid;
        int maxid;
        Statement stmt = con.createStatement();
        ResultSet r;
        r = stmt.executeQuery("select id from koulu order by id asc limit 1");
        if (!r.next()) {
            System.err.println("Ei kouluja, ei voi päivittää");
            return;
        }
        minid = r.getInt(1);
        r.close();
        r = stmt.executeQuery("select id from koulu order by id desc limit 1");
        r.next();
        maxid = r.getInt(1);
        List<Integer> oppilasidt = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("select id from oppilas");
        while(rs.next()) {
            oppilasidt.add(rs.getInt(1));
        }
        rs.close();
        String fmtupd = "UPDATE Oppilas SET kouluid=%d WHERE id=%d";
        for(Integer id : oppilasidt) {
            if(Math.random() < 0.5) continue;
            int kouluid = (int)((maxid+1-minid) * Math.random())+ minid;
            String sql = String.format(fmtupd, kouluid, id);
             System.out.println("** " + sql);
            stmt.executeUpdate(sql);
        }
    }

    private static void listaaKaikkiOppilaat(Connection con) throws SQLException {
        String sql = "SELECT * FROM Oppilas";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String fmtstr = "Oppilas: %s %s, %s (%d)";
        DateFormat df = DateFormat.getDateInstance();
        while(rs.next()) {
            int id = rs.getInt("id");
            String en = rs.getString("etunimi");
            String sn = rs.getString("sukunimi");
            Date d = rs.getDate("syntymaaika");
            LocalDate ld = LocalDate.parse(rs.getString("syntymaaika"));
            String s = String.format(fmtstr, en, sn, df.format(d), id);
            System.out.println(s);
        }
        stmt.close();
    }

    private static void listaaOppilaatKouluineen(Connection con) throws SQLException {
        String sql = "SELECT Oppilas.*, Koulu.nimi, Koulu.kaupunki FROM Oppilas LEFT JOIN Koulu on Oppilas.kouluid=Koulu.id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String ofmtstr = "Oppilas: %s %s, %s (%d)";
        DateFormat df = DateFormat.getDateInstance();
        while(rs.next()) {
            int id = rs.getInt("id");
            String en = rs.getString("etunimi");
            String sn = rs.getString("sukunimi");
            Date d = rs.getDate("syntymaaika");
            String s = String.format(ofmtstr, en, sn, df.format(d), id);
            System.out.println(s);
            int kouluid = rs.getInt("kouluid");
            if(!rs.wasNull()) {
                System.out.println("\tKoulu: " + rs.getString("nimi") + ", " + rs.getString("kaupunki"));
            }
        }
        stmt.close();
    }

    private static void luoOppilaatFirstClass(Connection con) throws SQLException {
        String [] etunimet = {"Tara", "Tessa", "Riku", "Robin", "Riikka", "Suheil", "Suri", "Sandra"};
        String [] sukunimet = {"Malli", "Kallio", "Kivi", "Louhikko"};
        Random random = new Random();
        Statement stmt = con.createStatement();
        for (int i = 0; i < 10; i++) {
            String en = etunimet[random.nextInt(etunimet.length)];
            String sn = sukunimet[random.nextInt(sukunimet.length)];
            int v = 2016 - random.nextInt(50);
            int k = random.nextInt(12) + 1;
            int p = random.nextInt(28) + 1;
            String pvm = String.format("%d-%d-%d", v, k, p);
            String sql = String.format("INSERT INTO Oppilas(etunimi, sukunimi, syntymaaika) VALUES('%s', '%s', '%s')",
                    en, sn, pvm);
            // System.out.println("\tsuoritetaan: " + sql);
            stmt.executeUpdate(sql);
        }
        stmt.close();
    }

    private static void luoKoulut(Connection con) throws SQLException {
        final int kouluja = 4;
        String [] nimet = {"FISTA", "Hanken", "Aalto", "Helsingin yliopisto", "Åbo academi"};
        String [] kaupungit = {"Helsinki", "Espoo", "Tampere", "Turku"};
        Random random = new Random();
        Statement stmt = con.createStatement();
        for (int i = 0; i < kouluja; i++) {
            String nimi = nimet[random.nextInt(nimet.length)];
            String kaupunki = kaupungit[random.nextInt(kaupungit.length)];
            String sql = String.format("INSERT INTO Koulu(nimi, kaupunki) VALUES('%s', '%s')",
                    nimi, kaupunki);
            // System.out.println("\tsuoritetaan: " + sql);
            stmt.executeUpdate(sql);
        }
        stmt.close();
    }


}
