package harjoitukset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC {

    private static Connection con = null;
    private static ResultSet rs = null;
    
    // DB to use
    private static String db = "//localhost:3306/world";

    public static void main(String[] args) {

        // load driver to memory (optional)
        lataaAjuri();

        // open connection, execute and close connection
        yhteys(con);


    }

    // driver loading to memory (optional > JDBC 4.0
    private static void lataaAjuri() {

        // variable setup for driver load
        String driverpath = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driverpath);
            System.out.println("Driver class '" + driverpath + "' loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class '" + driverpath + "' not found!");
        }

    }

    // open & close connection
    private static void yhteys(Connection con) {

        // variable setup for connection
        String url = "jdbc:mysql:" + db + "?useSSL=false";
        String u = "point";
        String p = "f4nt4stic";

        try {
            // open db connection
            con = DriverManager.getConnection(url, u, p);
            System.out.println("Connected to '" + db + "' succesfully.");
            
            query(con);
            printdata(rs);

        } catch (SQLException e) {

            System.out.println("SQL DB '" + db + "' not found.");
            System.out.println(e.getMessage());

        } finally {

            System.out.println("");
            
            // close db connection
            try {
                con.close();
                System.out.println("Connection to '" + db + "' closed.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException npe) {
                System.out.println("Connection con is null, could not close.");
            }

        }

    }

    private static void query(Connection con) {
        
        Scanner in = null;
        String query = "";
        
        try {
            in = new Scanner(System.in);
            System.out.println("\nEnter your SQL SELECT query for db " + db + ":");
            
            for(;;) {
                
                query += in.nextLine();
                
                if (query.charAt(query.length() - 1) == ';') break;
                if (query.charAt(query.length() - 1) != ' ') query += " ";
            }
            
            System.out.println("");
            
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException e) {
            System.out.println("There was an error while querying!");
            System.out.println(e.getMessage());
        } finally {
            try {in.close();} catch (NullPointerException npe) {
                System.out.println("Scanner was not initialised!");
            }
        }
        
    }

    private static void printdata(ResultSet rs) {
        
        if (rs == null) {
            System.out.println("\nThere was nothing to print.");
            return;
        }
                
        try {

            List<String> cols = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
                        
            StringBuilder columnNames = new StringBuilder();
            
            for (int i = 1 ; i <= rsmd.getColumnCount(); i++) {
                
                String s = rsmd.getColumnLabel(i).toUpperCase();
                
                cols.add(s);
                        
                if (s.length() < 8) {
                    columnNames.append(s.toUpperCase());
                    columnNames.append("\t\t\t");
                } else if (s.length() <= 15) {
                    columnNames.append(s.toUpperCase());
                    columnNames.append("\t\t");
                } else if (s.length() <= 22) {
                    columnNames.append(s.toUpperCase());
                    columnNames.append("\t");
                } else if (s.length() > 22) {
                    columnNames.append(s.substring(0, 20).toUpperCase());
                    columnNames.append("\t");
                }
               
            }
            
            System.out.println(columnNames.toString());
            
            int rowcounter = 0;
                        
            while(rs.next()) {

                StringBuilder print = new StringBuilder();

                for (String s : cols) {
                    
                    String d = rs.getString(s);

                    if (d.length() < 8) {
                        print.append(d);
                        print.append("\t\t\t");
                    } else if (d.length() <= 15) {
                        print.append(d);
                        print.append("\t\t");
                    } else if (d.length() <= 22) {
                        print.append(d);
                        print.append("\t");
                    } else if (d.length() > 22) {
                        print.append(d.substring(0, 20));
                        print.append("\t");
                    }
                }

                System.out.println(print.toString());
                
                rowcounter++;
                
            }
            
            System.out.println("\nThere were " + rowcounter + " rows in the result.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
