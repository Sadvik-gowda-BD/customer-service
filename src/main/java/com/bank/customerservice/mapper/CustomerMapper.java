package com.bank.customerservice.mapper;

import com.bank.customerservice.dto.AddressDto;
import com.bank.customerservice.dto.CustomerDto;
import com.bank.customerservice.entity.AddressEntity;
import com.bank.customerservice.entity.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDto map(CustomerEntity customerEntity) {
        return CustomerDto.builder()
                .userId(customerEntity.getCustomerId())
                .name(customerEntity.getName())
                .age(customerEntity.getAge())
                .emailId(customerEntity.getEmailId())
                .gender(customerEntity.getGender())
                .address(map(customerEntity.getAddressEntity()))
                .build();
    }

    public static CustomerEntity map(CustomerDto customerDto) {
        return CustomerEntity.builder()
                .customerId(customerDto.getUserId())
                .name(customerDto.getName())
                .age(customerDto.getAge())
                .emailId(customerDto.getEmailId())
                .gender(customerDto.getGender())
                .addressEntity(map(customerDto.getAddress()))
                .build();
    }

    public static AddressDto map(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        return AddressDto.builder()
                .addressId(addressEntity.getAddressId())
                .Country(addressEntity.getCountry())
                .state(addressEntity.getState())
                .build();
    }

    public static AddressEntity map(AddressDto dto) {
        if (dto == null) {
            return null;
        }

        return AddressEntity.builder()
                .addressId(dto.getAddressId())
                .state(dto.getState())
                .Country(dto.getCountry())
                .build();

    }


    public static List<CustomerDto> map(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(CustomerMapper::map).collect(Collectors.toList());
    }
}
