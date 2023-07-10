package com.example.springvalidataion.validators;

import com.example.springvalidataion.ds.Author;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AuthorValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Author.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required.Name","Name is required!");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors,"genre","required.genre","Genre is required!");
        Author author=(Author) target;
    }
}
