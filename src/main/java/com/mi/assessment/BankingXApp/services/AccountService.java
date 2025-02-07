package com.mi.assessment.BankingXApp.services;

import com.mi.assessment.BankingXApp.entities.Account;
import com.mi.assessment.BankingXApp.entities.Transactions;
import com.mi.assessment.BankingXApp.repositories.AccountRepo;
import com.mi.assessment.BankingXApp.repositories.TransactionRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    TransactionRepo transactionRepo;
    AccountRepo accountRepo;

    public AccountService(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    @Transactional
    public void transfer(long fromAccount, long toAccount, BigDecimal amount) throws Exception {
        Account fromAccDetail = accountRepo.findById(fromAccount).orElseThrow(()-> new RuntimeException("Wrong Account Id"));
        Account toAccDetail = accountRepo.findById(toAccount).orElseThrow(()-> new RuntimeException("Wrong Account Id"));

        if(fromAccDetail.getAccAmount().compareTo(amount)<0)
        {
            throw new IllegalArgumentException("Insufficient balance");
        }
        if(fromAccDetail.getAccType().equals("CURRENT")) {
            fromAccDetail.setAccAmount(fromAccDetail.getAccAmount().subtract(amount));
            toAccDetail.setAccAmount(toAccDetail.getAccAmount().add(amount));
            accountRepo.save(fromAccDetail);
            accountRepo.save(toAccDetail);
        }
        else
        {
            throw new Exception("Cannot Transfer Money");
        }
        Transactions transactions = new Transactions();
        transactions.setToAccount(toAccount);
        transactions.setFromAccount(fromAccount);
        transactions.setTimeStamp(LocalDateTime.now());
        transactions.setTransactionFee(amount.multiply(BigDecimal.valueOf(0.005)));
        transactions.setAmount(amount);
        transactionRepo.save(transactions);

    }

}
