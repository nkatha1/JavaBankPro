Bank Management System


Overview
The Bank Management System is a Java-based console application that simulates essential banking operations such as user registration, login, account creation, deposits, withdrawals, transaction tracking, and password management. It uses JSON for data persistence and leverages the Gson library for seamless serialization and deserialization.

This project is ideal for learning Java object-oriented programming, file handling, and implementing basic banking logic. It also serves as a strong portfolio piece demonstrating backend logic, user management, and data storage techniques.

Features
User Registration & Authentication
Secure registration and login system with password hashing for basic security.

Account Management
Users can create multiple bank accounts.

Transactions
Support for deposits, withdrawals, and viewing transaction history.

Password Management
Includes options for password reset and change password functionality.

Persistent Storage
User data and accounts are saved to JSON files to maintain state between sessions.

Console-based UI
Intuitive menu-driven interface for ease of use.

Technologies Used
Java 17+

Gson Library for JSON handling

File I/O for data persistence

OOP concepts (Encapsulation, Inheritance, Polymorphism)

Installation & Setup
Prerequisites
Java Development Kit (JDK) 17 or higher installed.

Git installed (optional, for cloning the repo).

Clone the Repository
bash
Copy
Edit
git clone https://github.com/YourUsername/YourRepoName.git
cd YourRepoName
Download Dependencies
Ensure the Gson library JAR (gson-2.8.9.jar) is placed inside the lib directory.

You can download it from Maven Central.

Compile the Code
Use the following command to compile the Java files, including the Gson dependency:

bash
Copy
Edit
javac -cp ".;lib/gson-2.8.9.jar" Main.java model/*.java service/*.java
Note: On Linux/macOS, replace the semicolon ; with a colon : in the classpath.

Run the Application
bash
Copy
Edit
java -cp ".;lib/gson-2.8.9.jar" Main
Usage
Register a new user.

Login with your credentials.

Access the User Menu to create accounts, deposit or withdraw funds, view transactions, or manage your password.

Data is automatically saved on logout.

Project Structure
nginx
Copy
Edit
Bank Management System/
├── lib/                  # External libraries (Gson jar)
├── model/                # Java classes representing data models (User, Account, Transaction)
├── service/              # Business logic services (AuthService, BankService)
├── storage/              # JSON data storage files (users.json)
├── Main.java             # Main application entry point and UI
├── README.md             # Project documentation
Future Enhancements
Add GUI using JavaFX or Swing.

Integrate real encryption for passwords.

Support for multiple user roles (admin, teller, customer).

Connect to a real database (MySQL, PostgreSQL).

Add interest calculations and loan management features.

Implement automated tests (JUnit).

Contribution
Contributions, issues, and feature requests are welcome! Feel free to check issues page.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
Your Name

GitHub: YourUsername

Email: your.email@example.com

Thank you for checking out the Bank Management System! 🚀
