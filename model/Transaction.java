package bankmanagementsystem.model;

import java.util.UUID;
import java.time.LocalDateTime;
import bankmanagementsystem.model.Account;

class Transaction {

    // Consistent field names
    private final String transactionId;
    private final String accountNumber;
    private final double amount;
    private final String transactionType; // instead of "type"
    private final LocalDateTime dateTime; // added missing field
    private final String status;

    // Constructor field names
    public Transaction(String accountNumber, String transactionType, String transactionId,
            double amount, LocalDateTime dateTime, String status) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionId = transactionId;
        this.amount = amount;
        this.dateTime = dateTime;
        this.status = status;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }
}
