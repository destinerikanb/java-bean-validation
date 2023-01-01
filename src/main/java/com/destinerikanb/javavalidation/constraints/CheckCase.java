package com.destinerikanb.javavalidation.constraints;

import com.destinerikanb.javavalidation.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckCaseValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    String message() default "invalid case format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    CaseMode mode();
}
