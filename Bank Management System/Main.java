package com.bankmanagement;

import com.bankmanagement.models.Customer;
import com.bankmanagement.services.AccountService;
import com.bankmanagement.services.CustomerService;
import com.bankmanagement.exceptions.InsufficientBalanceException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        Customer customer = null; // Only one customer (no array/collection)

        System.out.println("=== Welcome to Simple Bank Management System ===");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (customer != null) {
                        System.out.println("Account already exists!");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    String id = sc.next();
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();
                    customer = customerService.createCustomer(name, id, accNo, deposit);
                    break;

                case 2:
                    if (customer == null) {
                        System.out.println("Create an account first!");
                        break;
                    }
                    System.out.print("Enter Deposit Amount: ");
                    double depAmt = sc.nextDouble();
                    accountService.deposit(customer, depAmt);
                    break;

                case 3:
                    if (customer == null) {
                        System.out.println("Create an account first!");
                        break;
                    }
                    System.out.print("Enter Withdraw Amount: ");
                    double wdAmt = sc.nextDouble();
                    try {
                        accountService.withdraw(customer, wdAmt);
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    if (customer == null) {
                        System.out.println("Create an account first!");
                        break;
                    }
                    accountService.checkBalance(customer);
                    break;

                case 5:
                    System.out.println("Thank you for using our Bank!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
