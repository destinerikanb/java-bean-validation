package com.destinerikanb.javavalidation.constraints;

import com.destinerikanb.javavalidation.enums.CaseMode;
import com.destinerikanb.javavalidation.group.CreditCardPaymentGroup;
import com.destinerikanb.javavalidation.group.VirtualAccountPaymentGroup;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@ReportAsSingleViolation
@CheckCase(mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(message = "{order.id.notblank}")
@Size(min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {}) //dikosongkan saja
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckOrderId {

    String message() default "invalid order id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
