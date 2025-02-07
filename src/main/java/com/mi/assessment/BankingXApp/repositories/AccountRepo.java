package com.mi.assessment.BankingXApp.repositories;

import com.mi.assessment.BankingXApp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    public Account findByaccId(long accId);

}
