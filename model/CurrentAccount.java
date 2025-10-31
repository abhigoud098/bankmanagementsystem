package bankmanagementsystem.model;

import java.util.UUID;
import java.time.LocalDateTime;
import bankmanagementsystem.model.Account;

class CurrentAccount extends Account {

    // Variables
    private double overDraftLimit;
    private int transactionCount;
    private int maxTransactions = 10;

    // Constructor
    public CurrentAccount(String accountNumber, String ownerName, double balance,
            LocalDateTime dateTime) {
        super(accountNumber, ownerName, balance, dateTime);
        this.transactionCount = 0;
    }

    // Withdraw method with overdraft and transaction limit
    @Override
    public void withdraw(double amount) {
        if (balance - amount <= overDraftLimit) {
            System.out.println("Withdrawal failed: Insufficient balance. Current balance: " + balance);
        } else if (transactionCount >= maxTransactions) {
            System.out.println("Transaction limit exceeded. Transactions done: " + transactionCount);
        } else {
            balance -= amount;
            transactionCount++;

            String transactionId = UUID.randomUUID().toString();
            LocalDateTime dateTime = LocalDateTime.now();
            String transactionType = "WITHDRAW";

            Transaction t = new Transaction(getAccountNumber(), "TransactionType: WITHDRAW", transactionId, amount,
                    dateTime,
                    "status");
            saveTransaction(t);
            System.out.println(
                    "Withdrawal successful. New balance: " + balance + " | Your transactionId is: " + transactionId);
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionCount++;

        String transactionId = UUID.randomUUID().toString();
        LocalDateTime dateTime = LocalDateTime.now();
        String transactionType = "DEPOSIT";

        Transaction t = new Transaction(getAccountNumber(), "TransactionType: DEPOSIT", transactionId, amount, dateTime,
                "status");
        saveTransaction(t);
        System.out
                .println("Deposit successful. New balance: " + balance + " | Your transactionId is: " + transactionId
                        + "| TransactionType:" + transactionType);
    }

    // GetOverDraftLimit Method
    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    // SetOverDraftLimit Method
    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + " | OverDraftLimit: " + overDraftLimit + " | Transactions done: " + transactionCount;
    }

}