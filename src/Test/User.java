package Test;
import java.sql.*;
import java.util.*;

public class User {
    public static void createUser(String username, String password) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "insert into users values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2,password);
            ps.executeUpdate();
            //User has been successfully created in the database.
            con.close();
        } catch(Exception e) {
            System.out.println("Exception from User Class..!!");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> createUserRequirements(Scanner sc) {
        ArrayList<String> list = new ArrayList<>();
        System.out.print("Enter username : ");
        list.add(sc.nextLine());
        System.out.print("Enter password : ");
        list.add(sc.nextLine());
        return list;
    }

    public static String deleteUserRequirements(Scanner sc) {
        System.out.print("Enter username");
        String username = sc.nextLine();
        return username;
    }

    public static void deleteUser(String username) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "delete from users where username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println("Exception from User Class..!!");
        }
    }
}
