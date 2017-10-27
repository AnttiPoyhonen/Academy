package fi.academy.data;

import java.sql.*;

public class Koulu {
    private int id;
    private String nimi;
    private String kaupunki;
    public Koulu() {
    }

    public Koulu(int id, String nimi, String kaupunki) {
        this.id = id;
        this.nimi = nimi;
        this.kaupunki = kaupunki;
    }

    public Koulu(String nimi, String kaupunki) {
        this.nimi = nimi;
        this.kaupunki = kaupunki;
    }

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

    @Override
    public String toString() {
        return "Koulu{" + "id=" + id + ", nimi='" + nimi + '\'' + ", kaupunki='" + kaupunki + '\'' + '}';
    }

    public boolean isKannassa(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT nimi from Koulu WHERE id=?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        boolean rv = rs.next();
        stmt.close();
        return rv;
    }

    public boolean paivitaKantaan(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE Koulu SET nimi=?, kaupunki=? WHERE id=?");
        stmt.setString(1, nimi);
        stmt.setString(2, kaupunki);
        stmt.setInt(3, id);
        boolean rv = stmt.execute();
        stmt.close();
        return rv;
    }

    public int lisaaKantaan(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO Koulu(nimi, kaupunki) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, nimi);
        stmt.setString(2, kaupunki);
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            id = rs.getInt(1);
        }
        stmt.close();
        return id;
    }

}
