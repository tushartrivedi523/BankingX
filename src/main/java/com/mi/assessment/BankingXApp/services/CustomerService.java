package com.mi.assessment.BankingXApp.services;

import com.mi.assessment.BankingXApp.entities.Account;
import com.mi.assessment.BankingXApp.entities.Customer;
import com.mi.assessment.BankingXApp.repositories.AccountRepo;
import com.mi.assessment.BankingXApp.repositories.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CustomerService {

    CustomerRepo customerRepo;
    AccountRepo accountRepo;

    public CustomerService(CustomerRepo customerRepo, AccountRepo accountRepo) {
        this.customerRepo = customerRepo;
        this.accountRepo = accountRepo;
    }

    @Transactional
    public String onboard(Customer customer){
        if(customerRepo.findBycustName(customer.getCustName()) != null)
        {
            throw new RuntimeException(customer.getCustName()+" existing customer");
        }
        customerRepo.save(customer);

        //For Savings Account
        Account newAccount = new Account();
        newAccount.setCustId(customer.getCustId());
        newAccount.setAccType("SAVINGS");
        newAccount.setAccAmount(BigDecimal.valueOf(500.00));
        newAccount.setAccTimeStamp(LocalDateTime.now());
        accountRepo.save(newAccount);

        //For Current Account
        Account newAccount2 = new Account();
        newAccount2.setCustId(customer.getCustId());
        newAccount2.setAccType("CURRENT");
        newAccount2.setAccAmount(BigDecimal.ZERO);
        newAccount2.setAccTimeStamp(LocalDateTime.now());
        accountRepo.save(newAccount2);

        return customer.getCustName()+" onboarded Successfully!";
    }
}
