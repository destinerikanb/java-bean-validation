package com.destinerikanb.javavalidation.constraints;

import com.destinerikanb.javavalidation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext constraintValidatorContext) {
        if(value.getPassword() == null || value.getRetypePassword() == null) return true; //skip validation

        return value.getPassword().equals(value.getRetypePassword());
    }
}
