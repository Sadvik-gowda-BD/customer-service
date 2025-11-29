package com.bank.customerservice.controller;


import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vault")
public class HashicorpVaultController {

    @Value("${my.secret1}")
    private String secretVal1;
    @Value("${my.secret2}")
    private String secretVal2;
    @Value("${sec.val3}")
    private String secretVal3; //direct fetch from vault


    @GetMapping("/secret")
    public ResponseEntity<SecretDto> getSecretValues() {
        SecretDto dto = SecretDto.builder()
                .secretVal1(secretVal1)
                .secretVal2(secretVal2)
                .secretVal3(secretVal3)
                .build();

        return ResponseEntity.ok(dto);
    }

    @Builder
    @Setter
    @Getter
    public static class SecretDto {
        String secretVal1;
        String secretVal2;
        String secretVal3;
    }

}
