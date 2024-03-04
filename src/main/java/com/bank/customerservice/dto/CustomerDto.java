package com.bank.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {
    private int userId;
    @NotBlank(message = "User name should no be empty")
    private String name;
    private char gender;
    private String emailId;
    private int age;
    private AddressDto address;
}
