package com.destinerikanb.javavalidation;

import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest{

    @Test
    void testHibernateValidatorConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(1000l);
        payment.setCreditCard("433");

        validate(payment);
    }

    @Test
    void testHibernateValidatorConstraintValid() {

        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(10_000_000L);
        payment.setCreditCard("4111111111111111");

        validate(payment);
    }
}
