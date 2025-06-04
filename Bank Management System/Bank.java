import java.util.ArrayList;
import java.util.List;

// Bank class to manage customers, accounts, and transfers
public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    // Add a new customer to the bank
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Add a new account to the bank
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Find customer by ID
    public Customer findCustomerById(int customerId) {
        for (Customer c : customers) {
            if (c.getCustomerId() == customerId) {
                return c;
            }
        }
        return null;
    }

    // Find account by account number
    public Account findAccountByNumber(int accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        return null;
    }

    // Transfer money between accounts
    public boolean transfer(int fromAccountNum, int toAccountNum, double amount) {
        Account fromAccount = findAccountByNumber(fromAccountNum);
        Account toAccount = findAccountByNumber(toAccountNum);

        if (fromAccount == null || toAccount == null) {
            return false; // One of the accounts does not exist
        }

        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            // Record transactions
            fromAccount.addTransaction(String.format("Transferred $%.2f to Account %d", amount, toAccountNum));
            toAccount.addTransaction(String.format("Received $%.2f from Account %d", amount, fromAccountNum));
            return true;
        }
        return false; // insufficient funds
    }

    // Display all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : customers) {
            c.displayInfo();
            System.out.println("----------------------------");
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        for (Account a : accounts) {
            a.displayInfo();
            System.out.println("----------------------------");
        }
    }
}