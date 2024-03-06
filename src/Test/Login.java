package Test;
import java.util.*;

public class Login {
    public static boolean login(String username, String password) {
        return ValidateUser.validateUser(username, password);
    }
    public static ArrayList<String> loginRequiements(Scanner sc) {
        ArrayList<String> list = new ArrayList<>();
        System.out.print("Enter username : ");
        list.add(sc.nextLine());
        System.out.print("Enter password : ");
        list.add(sc.nextLine());
        return list;
    }
}
