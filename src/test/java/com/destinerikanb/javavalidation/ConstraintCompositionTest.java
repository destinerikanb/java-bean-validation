package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition() {

        Payment payment = new Payment();
        payment.setOrderId("36746384892hasnmbncbnbczvc");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
