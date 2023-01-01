package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest{

    @Test
    void testMessage() {

        Payment payment = new Payment();
        payment.setOrderId("123456789012");
        payment.setAmount(5000L);
        payment.setVirtualAccount("123457");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
