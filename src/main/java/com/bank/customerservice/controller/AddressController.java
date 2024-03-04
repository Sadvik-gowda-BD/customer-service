package com.bank.customerservice.controller;

import com.bank.customerservice.dto.CustomerDto;
import com.bank.customerservice.entity.AddressEntity;
import com.bank.customerservice.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressEntity> getAccount(@PathVariable("addressId") Integer addressId) {
        return ResponseEntity.ok(addressRepo.findById(addressId).get());
    }
}
