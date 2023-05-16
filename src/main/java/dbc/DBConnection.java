package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logiman_Sysdb;user=sa;password=Xh710708";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Fail to load driver!");
        }
        try {
            conn = DriverManager.getConnection(URL);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Fail to get connection object!");
        }
        return conn;
    }

    public void connClose() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Fail to close connection object!");
            }
        }
    }
}
