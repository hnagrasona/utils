package org.example;
import java.sql.*;

/*
 * Simple JDBC class for quick and basic DB connection testing
 *
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://" + args[0] + ":" + args[1] + "/" + args[2];
        String user = args[3];
        String password = args[4];
        Connection conn = null;
        DatabaseMetaData metadata = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url,user,password);
            if(conn != null) {
                System.out.println("Connection established");
                metadata = conn.getMetaData();
                System.out.println("Database name: " + metadata.getDatabaseProductName());
                System.out.println("Database version: " + metadata.getDatabaseProductVersion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
    }
}