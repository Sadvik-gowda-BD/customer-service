package com.bank.customerservice.service;

import com.bank.customerservice.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncCallService {

    @Autowired
    private CustomerService customerService;

    public void sync1(){
        System.out.println("SYNC1 call Thread:"+Thread.currentThread().getName());
    }

    public void sync2(){
        System.out.println("SYNC2 call Thread:"+Thread.currentThread().getName());
    }

    @Async
    public void async1(){
        System.out.println("ASYNC1 call Thread:"+Thread.currentThread().getName());
    }

    @Async
    public void async2() throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("ASYNC2 call Thread:"+Thread.currentThread().getName());
    }

    @Async
    public void async3(){
        System.out.println("ASYNC3 call Thread:"+Thread.currentThread().getName());
    }

    @Async
    public CompletableFuture<CustomerDto> asyncWithReturnType() throws InterruptedException {
        System.out.println("Async call with return type :"+Thread.currentThread().getName());
        CustomerDto response = customerService.getDummyCustomer();
        CompletableFuture<CustomerDto> completedFuture = CompletableFuture.completedFuture(response);
        Thread.sleep(20000L);
        return completedFuture;
    }

}
