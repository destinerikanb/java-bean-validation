package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidatorTest{

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("abcd");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
