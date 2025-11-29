package com.bank.customerservice.validator;

import com.bank.customerservice.annotation.CustomAgeCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomAgeValidator implements ConstraintValidator<CustomAgeCheck, Integer> {

    private int min;
    private int max;

    @Override
    public void initialize(CustomAgeCheck constraintAnnotation) {
        this.min = constraintAnnotation.minAge();
        this.max = constraintAnnotation.maxAge();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) {
            return true;
        }
        return integer >= min && integer <= max;
    }
}
