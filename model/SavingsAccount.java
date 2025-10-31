package bankmanagementsystem.model;

import java.util.UUID;
import java.time.LocalDateTime;
import bankmanagementsystem.model.Account;

class SavingAccount extends Account {

    private double interestRate;
    private int minimumBalance = 1000;
    private int transactionCount;
    private int maxTransactions = 3;

    // # Constructor
    public SavingAccount(String accountNumber, String ownerName, double balance, LocalDateTime dateTime) {
       super(accountNumber, ownerName, balance, dateTime);
        this.transactionCount = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount <= minimumBalance) {
            System.out.println("Withdrawal failed: Insufficient balance. Current balance: " + balance);
        } else if (transactionCount >= maxTransactions) {
            System.out.println("Transaction limit exceeded. Transactions done: " + transactionCount);
        } else {
            balance -= amount;
            transactionCount++;
            transactionId = UUID.randomUUID().toString();
            Transaction t = new Transaction(getAccountNumber(), "WITHDRAW", transactionId, amount, dateTime,
                    "status");
            saveTransaction(t);
            System.out.println(
                    "Withdrawal successful. New balance: " + balance + " | Your transactionId is: " + transactionId);
        }
    }

    // # Calculate Interest In a yearly
    public void calculateInterest() {
       balance += balance * interestRate / 100;
    }

    // # Deposit amount
    public void depositAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionCount++;
        transactionId = UUID.randomUUID().toString();
        Transaction t = new Transaction(getAccountNumber(), "DEPOSIT", transactionId, amount, dateTime, "status");
        saveTransaction(t);
        System.out
                .println("Deposit successful. New balance: " + balance + " | Your transactionId is: " + transactionId);
    }

    // #Get InterestRate
    public double getInterestRate() {
        return interestRate;
    }

    // Set Interest Rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + " | interestRate: " + interestRate + " | Transactions done: " + transactionCount;
    }

}
