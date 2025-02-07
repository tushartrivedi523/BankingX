# Banking Application (Spring Boot + MySQL)

## Overview
This is a **Banking Application** built using **Spring Boot** and **MySQL**. It provides features like:
- Customer onboarding with automatic account creation (Current & Savings Account)
- Money transfers between accounts
- Transaction tracking with fees and interest calculations

## Features
### 1. **Customer Onboarding**
- Creates a **Customer** with a **Current Account** and **Savings Account**.
- Savings Account receives a **R500.00 joining bonus**.

### 2. **Money Transfers**
- Customers can transfer money between their accounts.
- Only the **Current Account** can make payments to other accounts.

### 3. **Transaction Fees & Interest**
- **0.05% fee** is charged on outgoing payments.

### 4. **Transaction History & Notifications**
- The application records all transactions.

## Technology Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL 9**
- **Lombok** (for reducing boilerplate code)
- **Maven** (for dependency management)

## Database Schema
### Customers Table
| Column     | Type    | Description |
|------------|---------|-------------|
| id         | Long    | Primary Key |
| name       | String  | Customer Name |
| email      | String  | Customer Email |

### Accounts Table
| Column      | Type    | Description |
|-------------|---------|-------------|
| id          | Long    | Primary Key |
| customer_id | Long    | Foreign Key (Customers) |
| account_type | String  | CURRENT / SAVINGS |
| balance     | Decimal | Account Balance |

### Transactions Table
| Column         | Type    | Description |
|---------------|---------|-------------|
| id            | Long    | Primary Key |
| from_account_id | Long  | Sender Account ID |
| to_account_id | Long    | Receiver Account ID |
| amount        | Decimal | Transaction Amount |
| transaction_fee | Decimal | Transaction Fee |
| timestamp     | DateTime | Transaction Timestamp |

## Installation & Setup
### Prerequisites
- Install **Java 17**
- Install **MySQL 8**
- Install **Maven**

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/bankingx.git
   cd bankingx
   ```
2. Configure **MySQL Database**:
   ```sql
   CREATE DATABASE bankx;
   ```
3. Update **application.properties**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bankx
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   ```
4. Build & Run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
5. The application will start on **http://localhost:8080**.

## API Endpoints
### 1. **Customer Onboarding**
```http
POST /onboard
```

### 2. **Transfer Money**
```http
POST /transfer
```

## Future Enhancements
- **Add Authentication & Authorization** using Spring Security & JWT
- **Proper Exception Handling**
- **Contanerising the app with docker and kubernates**

