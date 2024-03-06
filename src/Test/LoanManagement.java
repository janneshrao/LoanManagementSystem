package Test;
import java.util.*;
public class LoanManagement {
    public static void main(String[] args) {
        private static int id;
    private static String creditor_name;
    private static String loan_details;
    private static double loan_amount;
    private static String return_date;

    private static Connection con;
    private static PreparedStatement ps;

    static {
        con = DatabaseConnection.getConnection();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("********** Welcome to Loan Management System **********");
            System.out.println("1. Add User\n2. Add Loan");
            System.out.println("----------------------------------------");

            System.out.print("Enter your choice : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:

                    System.out.print("Enter user id : ");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter user name : ");
                    String name = sc.nextLine();
                    addUser(id, name);
                    System.out.println("User added successfully..!!");
                    break;

                case 2:

                    System.out.print("Enter user id : ");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter creditor name : ");
                    creditor_name = sc.nextLine(); 
                    System.out.print("Enter loan details : ");
                    loan_details = sc.nextLine();
                    System.out.print("Enter loan amount : ");
                    loan_amount = Float.parseFloat(sc.nextLine());
                    System.out.print("Enter return date : ");
                    return_date = sc.nextLine();
                    addLoan(id,creditor_name,loan_details,loan_amount,Date.valueOf(return_date));
    
                    break;

                default:
                    System.out.println("Please enter valid option..!!");
                    break;
            }

        } catch(NumberFormatException e) {
            System.out.println("Please enter valid value..!!");
        } catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("Invalid user id..!!");
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid date values..!!");
        } catch(SQLDataException e) {
            System.out.println("Values are larger than specified precision allowed for this coloumn..!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(int id, String name) throws Exception {
            PreparedStatement ps = con.prepareStatement("insert into users values(?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
    }

    public static void addLoan(int id, String creditor_name, String loan_details, double loan_amount, Date return_date) throws Exception{
        ps = con.prepareStatement("insert into loans values(?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, creditor_name);
        ps.setString(3, loan_details);
        ps.setDouble(4, loan_amount);
        ps.setDate(5, return_date);
        ps.executeUpdate(); 
    }
}
