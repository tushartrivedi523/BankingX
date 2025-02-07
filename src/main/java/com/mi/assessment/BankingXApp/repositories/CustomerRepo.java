package com.mi.assessment.BankingXApp.repositories;

import com.mi.assessment.BankingXApp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Long> {

    public Customer findBycustName(String name);
}
