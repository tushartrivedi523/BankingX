package com.mi.assessment.BankingXApp.controllers;

import com.mi.assessment.BankingXApp.entities.Customer;
import com.mi.assessment.BankingXApp.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/onboard")
    public String onboard(@RequestBody Customer customer)
    {
        return customerService.onboard(customer);
    }
}
