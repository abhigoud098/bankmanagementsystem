package bankmanagementsystem.model;

import java.time.LocalDateTime;
import bankmanagementsystem.model.CurrentAccount;
import bankmanagementsystem.model.SavingAccount;

public class Main {

    public static void main(String[] args) {

        CurrentAccount currentAccount = new CurrentAccount("0945abhi2324@12", "Abhishek", 50000.0,
                LocalDateTime.now());
        currentAccount.deposit(6000);
        System.out.println(currentAccount);
    }

}
