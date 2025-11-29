package com.bank.customerservice.service;

import com.bank.customerservice.dto.CustomerDto;
import com.bank.customerservice.dto.RegisterCustomerDto;
import com.bank.customerservice.entity.CustomerEntity;
import com.bank.customerservice.mapper.CustomerMapper;
import com.bank.customerservice.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bank.customerservice.config.CaffeineCacheConfig.CUSTOMER_CACHE_NAME;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    //Here creating cache with key as userId, here key and cache names are optional
    // we can remove cache on condition by using condition and unless = "#result.gender=M"
    @Cacheable(cacheNames = CUSTOMER_CACHE_NAME, key = "#custId")
    public CustomerDto getCustomer(String custId) {
        log.info("******* Get customer by id - {} *****", custId);
        CustomerEntity response = customerRepo
                .findById(custId).orElseThrow(() -> new RuntimeException("Customer Not Fount"));
        return CustomerMapper.map(response);
    }

    public CustomerDto createCustomer(RegisterCustomerDto RegisterCustomerDto) {
        CustomerEntity response = customerRepo.save(CustomerMapper.map(RegisterCustomerDto));
        return CustomerMapper.map(response);
    }

    @CachePut(cacheNames = CUSTOMER_CACHE_NAME, key = "#customerDto.userId")
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        CustomerEntity response = customerRepo.save(CustomerMapper.map(customerDto));
        return CustomerMapper.map(response);
    }

    @CacheEvict(cacheNames = CUSTOMER_CACHE_NAME, key = "#custId")
    public void deleteCustomer(String custId) {
        customerRepo.deleteById(custId);
    }

    public CustomerDto getDummyCustomer() {
        return CustomerDto.builder()
                .userId(101)
                .name("Virat")
                .gender('M')
                .emailId("test@gamil.com")
                .age(27)
                .build();
    }

    public CustomerDto getCustomerByEmailId(String emailId) {
        Optional<CustomerEntity> response = customerRepo.findByEmailId(emailId);
        CustomerEntity customer = response
                .orElseThrow(() -> new RuntimeException("User not found by emailId:" + emailId));
        return CustomerMapper.map(customer);
    }

    public List<CustomerDto> getCustomerByAge(int age) {
        return CustomerMapper.map(customerRepo.findByAge(age));
    }
}
