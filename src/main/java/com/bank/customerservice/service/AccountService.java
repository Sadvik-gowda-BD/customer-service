package com.bank.customerservice.service;

import com.bank.customerservice.dto.AccountDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AccountService {

    @Value("${get.account.details.by.accountNumber.url}")
    private String ACCT_SERVICE_URL;
    private static final String GET_ACCOUNT_CB = "getAccount";
    @Autowired
    private RestTemplate restTemplate;


    @CircuitBreaker(name = GET_ACCOUNT_CB, fallbackMethod = "getAccountFallback")
    public AccountDto getAccount(String acctNo) {
        // Easy way :- restTemplate.getForObject(url,responseClass);
        ResponseEntity<AccountDto> response = restTemplate
                .exchange(ACCT_SERVICE_URL, HttpMethod.GET, getHttpEntity(),
                        AccountDto.class, getUriVariables(acctNo));
        return response.getBody();
    }

    public AccountDto getAccountFallback(Exception e) {
        log.error("ERRRRRRRRRRRRRRROR occurred :- {}", e.getMessage());
        return new AccountDto("000000", "UK", null);
    }

    private Map<String, String> getUriVariables(String acctNo) {
        Map<String, String> urilMap = new HashMap<>();
        urilMap.put("accountNumberValue", acctNo);
        return urilMap;
    }

    private HttpEntity<?> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.ALL));
        return new HttpEntity<>(null, httpHeaders);
    }

}
