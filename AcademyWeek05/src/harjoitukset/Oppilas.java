package harjoitukset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.util.Locale;

import static java.text.DateFormat.LONG;

public class Oppilas {
    
    private int id;
    private String etunimi, sukunimi;
    private Date syntymäaika;
    private Koulu kouluid;
        
    public void updateKantaan(Connection con) throws SQLException {
        
        if(!tarkistaID(con)) {
            System.out.println("There were no students with that ID; added the student instead of update.\n");
            this.lisaaKantaan(con);
            return;
        }
            
        String sql = "update oppilas set (etunimi = ?, sukunimi = ?, syntymäaika = ?, kouluid = ?) where id = ?";
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, etunimi);
        ps.setString(2, sukunimi);
        ps.setDate(3, syntymäaika);
        
        if (kouluid == null) ps.setNull(4, Types.INTEGER);
        else {
            
            if (!kouluid.isKannassa(con)) {
                kouluid.lisaaKantaan(con);
            }
            
            ps.setInt(4, kouluid.getId());
        }
        
        ps.setInt(5, id);
                
        if (ps.executeUpdate() == 1) System.out.println("Update successful with the following:\n" + this);
    }
    
    public void lisaaKantaan(Connection con) throws SQLException {
        
        String sql;
        
        if (id != 0) {            
            if(tarkistaID(con)) {
                System.out.println("There was already a student with that ID; did not add anything.\n");
                return;
            }
            
            sql = "insert oppilas values ('" + id + "', ?, ?, ?, ?)";
            
        } else {
            sql = "insert oppilas (etunimi, sukunimi, syntymäaika, kouluid) values (?, ?, ?, ?)";
        }        
                
        // check for the string
        // System.out.println(sql);
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, etunimi);
        ps.setString(2, sukunimi);
        ps.setDate(3, syntymäaika);
        
        if (kouluid == null) ps.setNull(4, Types.INTEGER);
        else ps.setInt(4, kouluid.getId());
                
        if (ps.executeUpdate() == 1) System.out.println("Insert successful.\n");
    }
    
    private boolean tarkistaID(Connection con) throws SQLException {
                
        String sql = "select * from oppilas where id = ?";
        
        if (sql.charAt(sql.length() - 1) != ';') sql += ";";        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, id);
                
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) return true;
        else return false;                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKouluid() {
        return kouluid.getId();
    }

    public void setKouluid(Koulu kouluid) {
        this.kouluid = kouluid;
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

    public Date getSyntymäaika() {
        return syntymäaika;
    }

    public void setSyntymäaika(Date syntymäaika) {
        this.syntymäaika = syntymäaika;
    }
    
    public Oppilas(String etunimi, String sukunimi, Date syntymäaika) {
        this(0, etunimi, sukunimi, syntymäaika, null);
    }
    
    public Oppilas(String etunimi, String sukunimi, Date syntymäaika, Koulu kouluid) {
        this(0, etunimi, sukunimi, syntymäaika, kouluid);
    }
    
    public Oppilas(int id, String etunimi, String sukunimi, Date syntymäaika, int kouluid) {
        this.id = id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymäaika = syntymäaika;
        
        for (Koulu k : Koulu.koulut) {
            if(kouluid == k.getId()) this.kouluid = k;
        }
    }
    
    public Oppilas(int id, String etunimi, String sukunimi, Date syntymäaika, Koulu kouluid) {
        this.id = id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymäaika = syntymäaika;
        
        if (kouluid == null) this.kouluid = null;
        else this.kouluid = kouluid;
    }

    @Override
    public String toString() {
        
        Locale fi = new Locale("fi", "FI");
        
        DateFormat df = DateFormat.getDateInstance(LONG, fi);
        
        String synt = df.format(syntymäaika);
        
        return "Oppilas ID" + id + ", " + etunimi + " " + sukunimi + " \t(synt. " + synt + ") \tkävi koulua " + kouluid;
    }
    
}
