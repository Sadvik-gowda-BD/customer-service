package com.bank.customerservice.controller;

import com.bank.customerservice.dto.CustomerDto;
import com.bank.customerservice.service.AsyncCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncCallController {

    @Autowired
    private AsyncCallService asyncCallService;

    @GetMapping("/async")
    public ResponseEntity<String> execute() throws InterruptedException, ExecutionException {
        asyncCallService.sync1();
        asyncCallService.sync2();

        //Async calls
        CompletableFuture<CustomerDto> response = asyncCallService.asyncWithReturnType();
        asyncCallService.async1();
        asyncCallService.async2();
        asyncCallService.async3();
        System.out.println("All method call happened");
        System.out.println("Waiting for async method to return customerDto");

        //This method will wait/block until task complete on async future method,
        // after completion of async task asyncWithReturnType method this method will resume
        // and execute below lines of code
        CustomerDto customerDto = response.get();
        System.out.println("Response from async return type method UserId:" + "customerDto.getUserId()");

        System.out.println("Message from controller before return");
        return new ResponseEntity<>("Execution completed", HttpStatus.OK);
    }
}
