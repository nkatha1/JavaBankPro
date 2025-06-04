import java.util.Scanner;

// Main class with colorful, eye-catching UI
public class Main {

    // ANSI color codes for terminal (works on most terminals)
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        printSplash();

        int choice;
        do {
            printMenu();
            System.out.print(CYAN + "Enter your choice: " + RESET);

            while (!scanner.hasNextInt()) {
                System.out.print(RED + "Invalid input. Enter a number: " + RESET);
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            clearScreen();

            switch (choice) {
                case 1 -> createCustomer(scanner, bank);
                case 2 -> createAccount(scanner, bank);
                case 3 -> depositMoney(scanner, bank);
                case 4 -> withdrawMoney(scanner, bank);
                case 5 -> transferMoney(scanner, bank);
                case 6 -> viewAccountDetails(scanner, bank);
                case 7 -> viewAllCustomers(bank);
                case 8 -> viewAllAccounts(bank);
                case 0 -> System.out.println(GREEN + "Thank you for using the Bank Management System! Goodbye!" + RESET);
                default -> System.out.println(RED + "Invalid choice, please try again." + RESET);
            }

            if (choice != 0) {
                System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
                scanner.nextLine();
                clearScreen();
            }

        } while (choice != 0);

        scanner.close();
    }

    // Splash screen with ASCII art and loading dots
    private static void printSplash() throws InterruptedException {
        clearScreen();
        System.out.println(PURPLE + "=======================================");
        System.out.println("       WELCOME TO BANK SYSTEM");
        System.out.println("=======================================" + RESET);
        System.out.print("Loading");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(400);
            System.out.print(".");
        }
        System.out.println("\n");
        Thread.sleep(500);
        clearScreen();
    }

    // Print main menu options
    private static void printMenu() {
        System.out.println(CYAN + "========= BANK MANAGEMENT MENU =========" + RESET);
        System.out.println("1. Create Customer");
        System.out.println("2. Create Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Transfer Money");
        System.out.println("6. View Account Details");
        System.out.println("7. View All Customers");
        System.out.println("8. View All Accounts");
        System.out.println("0. Exit");
        System.out.println("=======================================");
    }

    // Create a new customer
    private static void createCustomer(Scanner scanner, Bank bank) {
        System.out.println(YELLOW + "--- Create New Customer ---" + RESET);
        try {
            System.out.print("Enter Customer ID (integer): ");
            int id = Integer.parseInt(scanner.nextLine());

            if (bank.findCustomerById(id) != null) {
                System.out.println(RED + "Customer ID already exists!" + RESET);
                return;
            }

            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Customer customer = new Customer(id, name, phone, email);
            bank.addCustomer(customer);

            System.out.println(GREEN + "Customer created successfully!" + RESET);

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input! Customer ID must be a number." + RESET);
        }
    }

    // Create a new account for an existing customer
    private static void createAccount(Scanner scanner, Bank bank) {
        System.out.println(YELLOW + "--- Create New Account ---" + RESET);
        try {
            System.out.print("Enter Account Number (integer): ");
            int accNum = Integer.parseInt(scanner.nextLine());

            if (bank.findAccountByNumber(accNum) != null) {
                System.out.println(RED + "Account number already exists!" + RESET);
                return;
            }

            System.out.print("Enter Customer ID: ");
            int custId = Integer.parseInt(scanner.nextLine());

            Customer customer = bank.findCustomerById(custId);
            if (customer == null) {
                System.out.println(RED + "Customer not found!" + RESET);
                return;
            }

            Account account = new Account(accNum, customer);
            bank.addAccount(account);

            System.out.println(GREEN + "Account created successfully for " + customer.getName() + RESET);

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input! Account Number and Customer ID must be numbers." + RESET);
        }
    }

    // Deposit money into an account
    private static void depositMoney(Scanner scanner, Bank bank) {
        System.out.println(YELLOW + "--- Deposit Money ---" + RESET);
        try {
            System.out.print("Enter Account Number: ");
            int accNum = Integer.parseInt(scanner.nextLine());

            Account account = bank.findAccountByNumber(accNum);
            if (account == null) {
                System.out.println(RED + "Account not found!" + RESET);
                return;
            }

            System.out.print("Enter amount to deposit: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println(RED + "Amount must be positive!" + RESET);
                return;
            }

            account.deposit(amount);
            System.out.printf(GREEN + "Deposited $%.2f successfully!\n" + RESET, amount);

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input! Please enter numeric values." + RESET);
        }
    }

    // Withdraw money from an account
    private static void withdrawMoney(Scanner scanner, Bank bank) {
        System.out.println(YELLOW + "--- Withdraw Money ---" + RESET);
        try {
            System.out.print("Enter Account Number: ");
            int accNum = Integer.parseInt(scanner.nextLine());

            Account account = bank.findAccountByNumber(accNum);
            if (account == null) {
                System.out.println(RED + "Account not found!" + RESET);
                return;
            }

            System.out.print("Enter amount to withdraw: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println(RED + "Amount must be positive!" + RESET);
                return;
            }

            if (account.withdraw(amount)) {
                System.out.printf(GREEN + "Withdrew $%.2f successfully!\n" + RESET, amount);
            } else {
                System.out.println(RED + "Insufficient balance!" + RESET);
            }

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input! Please enter numeric values." + RESET);
        }
    }

    // Transfer money between accounts
    private static void transferMoney(Scanner scanner, Bank bank) {
        System.out.println(YELLOW + "--- Transfer Money ---" + RESET);
        try {
            System.out.print("Enter Sender Account Number: ");
            int fromAcc = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Receiver Account Number: ");
            int toAcc = Integer.parseInt(scanner.nextLine());

            if (fromAcc == toAcc) {
                System.out.println(RED + "Sender and receiver accounts cannot be the same!" + RESET);
                return;
            }

            System.out.print("Enter amount to transfer: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println(RED + "Amount must be positive!" + RESET);
                return;
            }

            if (bank.transfer(fromAcc, toAcc, amount)) {
                System.out.printf(GREEN + "Transferred $%.2f from account %d to %d successfully!\n" + RESET, amount, fromAcc, toAcc);
            } else {
                System.out.println(RED + "Transfer failed! Check account numbers or balance." + RESET);
            }

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input! Please enter numeric values." + RESET);
        }
    }

    // View account details and transaction history
    private static void viewAccountDetails(Scanner scanner, Bank bank) {
        System.out.println(YELLOW + "--- View Account Details ---" + RESET);
        try {
            System.out.print("Enter Account Number: ");
            int accNum = Integer.parseInt(scanner.nextLine());

            Account account = bank.findAccountByNumber(accNum);
            if (account == null) {
                System.out.println(RED + "Account not found!" + RESET);
                return;
            }

            account.displayInfo();
            System.out.println();
            account.displayTransactionHistory();

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input! Account Number must be a number." + RESET);
        }
    }

    // View all customers
    private static void viewAllCustomers(Bank bank) {
        System.out.println(YELLOW + "--- All Customers ---" + RESET);
        bank.displayAllCustomers();
    }

    // View all accounts
    private static void viewAllAccounts(Bank bank) {
        System.out.println(YELLOW + "--- All Accounts ---" + RESET);
        bank.displayAllAccounts();
    }

    // Clear console screen for better UI (works on most terminals)
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clear fails, no big deal
        }
    }
}
