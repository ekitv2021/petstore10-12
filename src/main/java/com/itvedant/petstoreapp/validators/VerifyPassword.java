package com.itvedant.petstoreapp.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //this annotation will be applied on class
@Constraint(validatedBy = VerifyPasswordValidator.class)
public @interface VerifyPassword {
    String field1();

    String field2();

    String message() default "Password and Confirm Mismatched";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
