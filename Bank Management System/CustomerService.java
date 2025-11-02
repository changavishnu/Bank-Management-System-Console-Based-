package com.bankmanagement.services;

import com.bankmanagement.models.Account;
import com.bankmanagement.models.Customer;

public class CustomerService {

    public Customer createCustomer(String name, String id, String accNo, double initialDeposit) {
        Account account = new Account(accNo, initialDeposit);
        Customer customer = new Customer(name, id, account);
        System.out.println("Account created successfully for " + name + "!");
        return customer;
    }
}
