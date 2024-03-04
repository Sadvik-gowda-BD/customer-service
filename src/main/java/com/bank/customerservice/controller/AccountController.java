package com.bank.customerservice.controller;

import com.bank.customerservice.dto.AccountDto;
import com.bank.customerservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/msg")
    public String getSimpleMsg() {
        return "Hello";
    }

    @GetMapping("/{acctNumber}")
    public AccountDto getAccount(@PathVariable("acctNumber") String acctNum) {
        return accountService.getAccount(acctNum);
    }


}
