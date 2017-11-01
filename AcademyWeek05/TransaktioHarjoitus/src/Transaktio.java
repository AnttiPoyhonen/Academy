import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transaktio {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/world?useSSL=false";
        String u = "point";
        String p = "f4nt4stic";
        String sql1 = "update country set headofstate = 'Paavo Pesusieni';";
        String sql2 = "update country set population = 9999;";

        Connection con = null;

        try (Scanner in = new Scanner(System.in)) {

            con = DriverManager.getConnection(url, u, p);

            Statement st = con.createStatement();

            con.setAutoCommit(false);

            System.out.println("");

            st.executeUpdate(sql1);
            System.out.println(sql1);
            st.executeUpdate(sql2);
            System.out.println(sql2);

            System.out.println("\nCommit prepared, waiting for ENTER...");
            in.nextLine();

            con.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            if(con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        } finally {

            if(con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }

        }

    }

}
