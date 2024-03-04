package com.bank.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    private String acctNum;
    private String acctType;
    private Long balance;
}
