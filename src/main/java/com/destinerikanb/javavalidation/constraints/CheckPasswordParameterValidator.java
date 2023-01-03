package com.destinerikanb.javavalidation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {

    private int passwordParam;

    private int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        this.passwordParam = constraintAnnotation.passwordParam();
        this.retypePasswordParam = constraintAnnotation.retypePasswordParam();
        //lokasi parameter password dan retype pass
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext constraintValidatorContext) {
        String password = (String) value[passwordParam];
        String retypePassword = (String) value[retypePasswordParam];

        if(password == null || retypePassword == null){
            return true;
        }

        return password.equals(retypePassword);
    }
}
