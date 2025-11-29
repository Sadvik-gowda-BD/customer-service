package com.bank.customerservice.annotation;

import jakarta.validation.Payload;

public @interface CustomAgeCheck {

    String message() default "Age validation failed";

    int minAge();

    int maxAge();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
