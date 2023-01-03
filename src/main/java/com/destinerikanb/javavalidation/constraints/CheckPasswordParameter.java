package com.destinerikanb.javavalidation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPasswordParameterValidator.class)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam(); // passwor dnya ada di parameter ke berapa
    int retypePasswordParam(); // retypePasswor dnya ada di parameter ke berapa
    String message() default "password and retypePassword must be the same";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
