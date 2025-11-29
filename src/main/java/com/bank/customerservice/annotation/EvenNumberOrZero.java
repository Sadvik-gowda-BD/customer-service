package com.bank.customerservice.annotation;

import jakarta.validation.Payload;

public @interface EvenNumberOrZero {

    String message() default "Value must be an even number or zero";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
