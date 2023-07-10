package com.example.springvalidataion.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotAdminValidator implements ConstraintValidator<NotAdmin,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        return !s.equalsIgnoreCase("Admin");
    }
}
