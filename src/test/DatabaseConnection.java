package test;
import java.sql.*;
public class DatabaseConnection {
    private static Connection con;
    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","sarasu10");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
