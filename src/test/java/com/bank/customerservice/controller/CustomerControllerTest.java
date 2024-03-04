package com.bank.customerservice.controller;

import com.bank.customerservice.dto.CustomerDto;
import com.bank.customerservice.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;
    @Mock
    CustomerService customerService;

    @Test
    void testGetAccount(){
        CustomerDto customerDto = buildCustomerDto();
        when(customerService.getCustomer("101")).thenReturn(customerDto);
        ResponseEntity<CustomerDto> response = customerController.getAccount("101");
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertCustomerData(customerDto, response.getBody());
    }

    private void assertCustomerData(CustomerDto expected, CustomerDto actual) {
        assertEquals(expected.getUserId(), actual.getUserId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getEmailId(),actual.getEmailId());
    }

    private CustomerDto buildCustomerDto(){
        return CustomerDto.builder()
                .userId(101)
                .name("virat")
                .age(27)
                .build();
    }
}
