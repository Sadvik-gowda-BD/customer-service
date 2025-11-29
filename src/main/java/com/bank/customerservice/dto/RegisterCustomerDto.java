package com.bank.customerservice.dto;

import com.bank.customerservice.annotation.CustomAgeCheck;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterCustomerDto {
    @NotBlank(message = "User name should no be empty")
    @Size(min = 2, max = 20)
    private String name;
    private char gender;
    //@Email
    @Email(
            regexp = "\"[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}\"",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Inavlid email address"
    )
    private String emailId;
    @CustomAgeCheck(minAge = 10, maxAge = 30, message = "age should be between 10 and 20")
    private int age;
    @Pattern(
            regexp = "^[a-zA-Z]{2}\\d{2}[eEnN]$",
            message = "User code must be 5 characters long: 2 letters, 2 numbers, and ends with E or N"
    )
    private String userCode;
    private String number;
    private AddressDto address;
}
