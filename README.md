# 🏦 Bank Management System

A **Java-based OOP (Object-Oriented Programming)** project that simulates real-world banking operations — including **Account Creation, Deposits, Withdrawals, and Transaction Records** — designed with clarity, modularity, and scalability in mind.

---

## 🚀 Features

✅ Create and manage multiple accounts  
✅ Deposit and withdraw money securely  
✅ Transaction history tracking using `HashMap`  
✅ Support for both **Current** and **Saving** accounts  
✅ Automatic date & time logging (`LocalDateTime`)  
✅ Follows full **OOP principles** (Encapsulation, Inheritance, Polymorphism, Abstraction)

---

## 🧩 Tech Stack

| Technology | Description |
|-------------|-------------|
| ☕ **Java** | Core language |
| 🧱 **OOP Concepts** | Class design & hierarchy |
| 🗂️ **Collections API** | `HashMap` for storing transactions |
| ⏰ **java.time API** | For date & time tracking |

---

## 🧠 OOP Concepts Used

| Concept | Example in Project |
|----------|--------------------|
| **Encapsulation** | Private fields with getters/setters in `Account` |
| **Inheritance** | `SavingAccount` & `CurrentAccount` extend `Account` |
| **Polymorphism** | Overridden `deposit()` and `withdraw()` methods |
| **Abstraction** | `Account` as a base abstract class |
| **Composition** | Each `Account` contains multiple `Transaction` objects |

---

## 🏗️ Project Structure
```
bankmanagementsystem/
│
├── model/
│ ├── Account.java
│ ├── CurrentAccount.java
│ ├── SavingAccount.java
│ ├── Transaction.java
│ └── Main.java
│
└── README.md
```

