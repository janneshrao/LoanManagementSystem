package Test;
import java.sql.*;
public class ValidateUser {
    public static boolean validateUser(String username, String password) {
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select password from users where username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(password)) return true;
            }
        } catch(Exception e) {
            System.out.println("Exception from ValidateUser Class..!!");
            e.printStackTrace();
        }
        return false;
    }
}
