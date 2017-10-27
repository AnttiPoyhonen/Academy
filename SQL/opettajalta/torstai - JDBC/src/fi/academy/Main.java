package fi.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection con;

    public static void main(String[] args) {
        //lataaAjuri();
        String url = "jdbc:mysql://localhost:3306/world?useSSL=false";
        try  {
            con = DriverManager.getConnection(url,
                    "root", "adminadmin");
            System.out.println("Yhteys saatiin");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lataaAjuri() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Ajuri ladattu");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
