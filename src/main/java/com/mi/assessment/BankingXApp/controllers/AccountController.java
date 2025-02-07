package com.mi.assessment.BankingXApp.controllers;

import com.mi.assessment.BankingXApp.services.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class AccountController {


    AccountService accountService;

    @PostMapping("/transfer")
    public void transfer(@RequestBody Map<String, String> request) throws Exception {
        Long fromAccountId = Long.parseLong(request.get("fromAccountId"));
        Long toAccountId = Long.parseLong(request.get("toAccountId"));
        BigDecimal amount = new BigDecimal(request.get("amount"));
        accountService.transfer(fromAccountId, toAccountId, amount);
    }
}
