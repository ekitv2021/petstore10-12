package com.itvedant.petstoreapp.entities;

import org.hibernate.validator.constraints.Length;

import com.itvedant.petstoreapp.validators.Phone;
import com.itvedant.petstoreapp.validators.VerifyPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@VerifyPassword(field1= "password", field2 = "confirmPassword")
public class User {
    private Integer id;

    @NotNull(message = "first name cannot be null")
    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotNull(message = "last name cannot be null")
    @Length(min = 3, max = 10, message = "last name should have 3 - 10 characters")
    private String lastName;

    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    @NotNull(message = "phone cannot be null")
    @Phone
    private String phone;

    private String password;
    private String confirmPassword;
}
