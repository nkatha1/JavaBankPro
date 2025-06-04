import java.util.ArrayList;
import java.util.List;

// Class to represent a bank account
public class Account {
    private int accountNumber;
    private Customer customer;     // The owner of the account
    private double balance;
    private List<String> transactionHistory;  // List of transaction descriptions

    // Constructor to create a new account
    public Account(int accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;  // Initial balance is 0
        this.transactionHistory = new ArrayList<>();
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money and record transaction
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(String.format("Deposited: $%.2f", amount));
        }
    }

    // Withdraw money if sufficient balance and record transaction
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add(String.format("Withdrew: $%.2f", amount));
            return true;
        }
        return false;  // insufficient funds or invalid amount
    }

    // Add transfer transaction (outgoing or incoming)
    public void addTransaction(String description) {
        transactionHistory.add(description);
    }

    // Display account info
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Owner: " + customer.getName());
        System.out.printf("Balance: $%.2f\n", balance);
    }

    // Display all transactions
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactionHistory) {
                System.out.println(" - " + t);
            }
        }
    }
}