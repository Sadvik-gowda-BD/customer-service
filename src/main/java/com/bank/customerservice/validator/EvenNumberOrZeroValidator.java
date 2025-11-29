package com.bank.customerservice.validator;

import com.bank.customerservice.annotation.EvenNumberOrZero;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenNumberOrZeroValidator implements ConstraintValidator<EvenNumberOrZero, Number> {

    @Override
    public void initialize(EvenNumberOrZero constraintAnnotation) {
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        // Allow null values
        if (value == null) {
            return true;
        }

        long longValue = value.longValue();
        return longValue % 2 == 0;
    }
}

