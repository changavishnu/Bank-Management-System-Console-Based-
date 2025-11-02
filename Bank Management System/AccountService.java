
package com.bankmanagement.services;

import com.bankmanagement.models.Customer;
import com.bankmanagement.exceptions.InsufficientBalanceException;

public class AccountService {

    public void deposit(Customer customer, double amount) {
        if (customer != null) {
            customer.getAccount().deposit(amount);
        } else {
            System.out.println("No account found!");
        }
    }

    public void withdraw(Customer customer, double amount) throws InsufficientBalanceException {
        if (customer != null) {
            if (amount > customer.getAccount().getBalance()) {
                throw new InsufficientBalanceException("Insufficient balance!");
            }
            customer.getAccount().withdraw(amount);
        } else {
            System.out.println("No account found!");
        }
    }

    public void checkBalance(Customer customer) {
        if (customer != null) {
            System.out.println("Current Balance: ₹" + customer.getAccount().getBalance());
        } else {
            System.out.println("No account found!");
        }
    }
}
