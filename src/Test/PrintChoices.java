package Test;
import java.util.*;
public class PrintChoices {
    private static String finalChoice;
    public static String printChoices(Scanner sc) {
        System.out.println("********** Welcome to Loan Management System **********");
        System.out.println("1. Users Management\n2. Loan Management");
        System.out.println("-------------------------------------------------------");
        System.out.print("Enter your choice : ");
        String key = sc.nextLine();
        String choice = "";
        switch (key) {
            case "1":
                System.out.println("-------------------------------------------------------");
                System.out.println("*************** User Management Services **************");
                System.out.println("1. Create user\n2. Delete user");
                System.out.println("-------------------------------------------------------");
                System.out.print("Enter your choice : ");
                choice = sc.nextLine();
                break;
            case "2":
                System.out.println("--------------------------------------------------------");
                System.out.println("*************** Loan Management Services ***************");
                System.out.println("1. Add Loan");
                System.out.println("-------------------------------------------------------");
                System.out.print("Enter your choice : ");
                choice = sc.nextLine();
                break;
            default:
                break;
        }
        finalChoice = key + "." + choice;
        return finalChoice;
    }
}