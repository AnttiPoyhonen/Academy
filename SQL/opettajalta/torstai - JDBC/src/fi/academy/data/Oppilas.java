package fi.academy.data;

import java.sql.*;
import java.util.Date;

public class Oppilas {
    private int id;
    private String etunimi;
    private String sukunimi;
    private Date syntymaaika;
    private Koulu koulu;

    public Oppilas() {
    }

    public Oppilas(String etunimi, String sukunimi, Date syntymaaika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymaaika = syntymaaika;
    }

    public Oppilas(int id, String etunimi, String sukunimi, Date syntymaaika, Koulu koulu) {
        this.id = id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymaaika = syntymaaika;
        this.koulu = koulu;
    }

    public Oppilas(String etunimi, String sukunimi, Date syntymaaika, Koulu koulu) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymaaika = syntymaaika;
        this.koulu = koulu;
    }

    public void kaivaTiedot(Connection con, ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String en = rs.getString("etunimi");
        String sn = rs.getString("sukunimi");
        Date d = rs.getDate("syntymaaika");
        // tehdään asetukset vasta nyt, eli jos ei kaikkia tietoja saada haettua,
        // niin ei muuteta tätä oliota
        this.id = id;
        this.etunimi = en;
        this.sukunimi = sn;
        this.syntymaaika = d;

        // haetaan mahdollinen koulu
        int kouluid = rs.getInt("kouluid");
        if(!rs.wasNull()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * from koulu WHERE id=?");
            stmt.setInt(1, kouluid);
            rs = stmt.executeQuery();
            if (!rs.next())
                throw new SQLException("Ei koulua idllä: " + kouluid);
            String k_nimi = rs.getString("nimi");
            String k_kaupunki = rs.getString("kaupunki");
            Koulu k = new Koulu(kouluid, k_nimi, k_kaupunki);
            this.koulu = k;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public Date getSyntymaaika() {
        return syntymaaika;
    }

    public void setSyntymaaika(Date syntymaaika) {
        this.syntymaaika = syntymaaika;
    }

    public Koulu getKouluid() {
        return koulu;
    }

    public void setKoulu(Koulu koulu) {
        this.koulu = koulu;
    }

    @Override
    public String toString() {
        return "Oppilas{" + "id=" + id + ", etunimi='" + etunimi + '\'' + ", sukunimi='" + sukunimi + '\'' + ", syntymaaika=" + syntymaaika + ", koulu=" + koulu + '}';
    }

    public boolean paivitaKantaan(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE Oppilas SET etunimi=?, sukunimi=?, syntymaaika=?, kouluid=? WHERE id=?");
        if (koulu != null) {
            if(!koulu.isKannassa(con)) {
                koulu.lisaaKantaan(con);
            }
        }
        stmt.setString(1, etunimi);
        stmt.setString(2, sukunimi);
        stmt.setDate(3, new java.sql.Date(syntymaaika.getTime()));
        stmt.setString(4, koulu == null ? null : String.valueOf(koulu.getId()));
        stmt.setInt(5, id);
        boolean rv = stmt.execute();
        stmt.close();
        return rv;
    }

    public int lisaaKantaan(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO Oppilas(etunimi, sukunimi, syntymaaika, kouluid) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        if (koulu != null) {
            if(!koulu.isKannassa(con)) {
                koulu.lisaaKantaan(con);
            }
        }
        stmt.setString(1, etunimi);
        stmt.setString(2, sukunimi);
        stmt.setDate(3, new java.sql.Date(syntymaaika.getTime()));
        stmt.setString(4, koulu == null ? null : String.valueOf(koulu.getId()));
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            id = rs.getInt(1);
        }
        stmt.close();
        return id;
    }

}
