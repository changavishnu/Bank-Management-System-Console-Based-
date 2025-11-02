package com.bankmanagement.models;

public class Customer {
    private String name;
    private String id;
    private Account account;

    public Customer(String name, String id, Account account) {
        this.name = name;
        this.id = id;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }
}

