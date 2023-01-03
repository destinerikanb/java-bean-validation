package com.destinerikanb.javavalidation.constraints;

import com.destinerikanb.javavalidation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if(value.getPassword() == null || value.getRetypePassword() == null) return true; //skip validation

        boolean isValid = value.getPassword().equals(value.getRetypePassword());

        if(!isValid){
            //Untuk disable default constraint violation
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("password and retype password is not the same")
//                    .addPropertyNode("password")
//                    .addConstraintViolation();
//            context.buildConstraintViolationWithTemplate("retype password and password is not the same")
//                    .addPropertyNode("retypePassword")
//                    .addConstraintViolation();

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }
        return isValid;

    }
}
