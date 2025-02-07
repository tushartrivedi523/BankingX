package com.mi.assessment.BankingXApp.repositories;

import com.mi.assessment.BankingXApp.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {



}
