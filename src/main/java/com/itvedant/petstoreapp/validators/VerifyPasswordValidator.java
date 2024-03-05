package com.itvedant.petstoreapp.validators;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VerifyPasswordValidator 
    implements ConstraintValidator<VerifyPassword, Object>{

    //Here field1 will get the value as password
    //field2 will get the value as confirmPassword
    private String field1;
    private String field2;

    @Override
    public void initialize(VerifyPassword constraintAnnotation) {
        this.field1 = constraintAnnotation.field1();
        this.field2 = constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
        //To get the actual value from field1 and field2
        Object field1Value = new BeanWrapperImpl(arg0).getPropertyValue(field1);
        Object field2Value = new BeanWrapperImpl(arg0).getPropertyValue(field2);

        return field1Value.equals(field2Value);
    }    
}
