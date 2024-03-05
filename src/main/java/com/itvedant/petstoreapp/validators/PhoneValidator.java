package com.itvedant.petstoreapp.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//This class will contain isValid method
//which is called when we apply @Phone annotation
//on a field
public class PhoneValidator 
    implements ConstraintValidator<Phone, String>{

    @Override
    //Here arg0 will get the input value of the phone
    //which we have to validate
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        //[0-9] indicate any digit
        //+ indicates more than 1 digit
        boolean condition = arg0.length() == 10 && arg0.matches("[0-9]+");
        return condition;
    }
     
}
