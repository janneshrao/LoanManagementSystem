package Test;
import java.sql.*;
public class DatabaseConnection {
    private static Connection con;
    static {
        try {
            con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch(Exception e) {
            System.out.println("Exception from DatabaseConnection Class..!!");
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }
}
