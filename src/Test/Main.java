package Test;
import java.util.*;
public class Main {
    public static void main(String[] nothing) {
        try(Scanner sc = new Scanner(System.in)) {
            String choice = PrintChoices.printChoices(sc);
            switch(choice) {
                case "1.1": //create user
                    ArrayList<String> list = User.createUserRequirements(sc);
                    User.createUser(list.get(0), list.get(1));
                    System.out.println("User has been created successfully..!!");
                    break;
                case "1.2": //delete user
                    String str = User.deleteUserRequirements(sc);
                    User.deleteUser(str);
                    System.out.println("User has been deleted successfully..!!");
                    break;
                case "2.1": //add loan
                    ArrayList<String> loginList = Login.loginRequiements(sc);
                    boolean validate = Login.login(loginList.get(0), loginList.get(1));
                    if(validate) {
                        //resume
                    } else {
                        System.out.println("Please enter valid user credentials..!!");
                    }
                    break;
                default:
                    FetchTableDetails.fetchTableDetails("users");
                    break;
            }
        } catch(Exception e) {
            System.out.println("Exception from Main Class...!!!");
            e.printStackTrace();
        }
    }
}
