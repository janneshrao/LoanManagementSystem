package Test;
import java.sql.*;
public class FetchTableDetails {
    public static void fetchTableDetails(String tableName) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from " + tableName;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Example : username       password");
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            con.close();
        } catch(Exception e) {
            System.out.println("Exception from FetchTableDetails Class..!!");
            e.printStackTrace();
        }
    }
}
