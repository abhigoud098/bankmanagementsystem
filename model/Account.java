package bankmanagementsystem.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//Abstract Account class
public abstract class Account {

    // Variables
    private String accountNumber;
    private String ownerName;
    protected double balance;
    static String bankName;
    protected String transactionId;
    protected LocalDateTime dateTime;

    // # HashMap for hold all transaction in one place
    private static Map<String, Transaction> allTransactionRecords = new HashMap<>();

    // Constructor
    public Account(String accountNumber, String ownerName, double balance, LocalDateTime dateTime) {
    this.accountNumber = accountNumber;
    this.ownerName = ownerName;
    this.balance = balance;
    this.dateTime = dateTime;
}

    // Set All transaction in Saving Account or current account both in Hash.
    protected void saveTransaction(Transaction t) {
        allTransactionRecords.put(transactionId, t);
    }

    // Get Transaction Details
    public static Transaction getTransactionDetails(String transactionId) {
        Transaction transactionDetails = allTransactionRecords.get(transactionId);
        return transactionDetails;
    }

    // Abstract Withdraw Method
    abstract void withdraw(double amount);

    // Abstract Deposit Method
    abstract void deposit(double amount);

    // Get AccountNumber Method
    public String getAccountNumber() {
        return accountNumber;
    }

    // Get OwnerName Method
    public String getOwnerName() {
        return ownerName;
    }

    // getBalance Method
    public double getBalance() {
        return balance;
    }

    // Get BankName method
    public String getBankName() {
        return bankName;
    }

    // Getter method to read transactionID
    public String getTransactionID() {
        return transactionId;
    }

    // Update Date Method
    public LocalDateTime getCreatedDate() {
        return dateTime;
    }

    public void setBankName(String bankName){
        this.bankName = bankName;
    }

    /*
     * #. Why we using here toString Method ?
     * 🧩 Why it happens [com.Bankapp.model.SavingsAccount@5a07e868]
     * Every class in Java inherits from Object by default.
     * --> Because, of if we not use a to string method, if we want to print the
     * account details so then we get a address of this account place @34a45 kind a
     * this so we don't want this kind of output that's way we use toString method.
     */

    // toString Method Override
    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | Balance: " + balance + " | Date&Time: " + dateTime;
    }

}