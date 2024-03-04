package com.bank.customerservice.controller;


import com.bank.customerservice.dto.CustomerDto;
import com.bank.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/msg")
    public String getSimpleMsg() {
        return "Hello";
    }

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerDto> getAccount(@PathVariable("custId") String custId) {
        return ResponseEntity.ok(customerService.getCustomer(custId));
    }

    @PostMapping("")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto response = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} is optional,
    // springboot automatically bind XML/JSON request to object
    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.updateCustomer(customerDto));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteCustomer(@RequestParam("custId") String custId) {
        customerService.deleteCustomer(custId);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT); This or below anything is fine
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<CustomerDto> getCustomerByEmailId(@PathVariable(name = "emailId", required = true) String emailId) {
        return ResponseEntity.ok(customerService.getCustomerByEmailId(emailId));
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerDto>> getCustomerByAge(
            @RequestParam(defaultValue = "0", name = "age", required = false) int age) {
        return ResponseEntity.ok(customerService.getCustomerByAge(age));
    }

}
