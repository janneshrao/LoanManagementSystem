package test;

import java.sql.*;
import java.util.*;

public class LoanManagement {

    private static int id;
    private static Connection con;
    static {
        con = DatabaseConnection.getConnection();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("********** Welcome to Loan Management System **********");
            System.out.println("1. Add User");
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

                default:
                    System.out.println("Please enter valid option..!!");
                    break;
            }

        } catch(NumberFormatException e) {
            System.out.println("Please enter valid integer value..!!");
        } catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("User Already Exists..!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(int id, String name) throws Exception {
        try {
            PreparedStatement ps = con.prepareStatement("insert into users values(?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch(Exception e) {
            throw e;
        }
    }
}
